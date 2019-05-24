package com.movebrick.hbase.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.*;

public class HBaseService {
    private Logger log = LoggerFactory.getLogger(HBaseService.class);

    /**
     * 声明静态配置
     */
    private Configuration conf = null;
    private Connection connection = null;

    public HBaseService(Configuration conf) {

        this.conf = conf;
        try {
            connection = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            log.error("获取HBase连接失败");
        }
    }

    /**
     * 创建表
     *
     * @param tableName    表名
     * @param columnFamily 列族名
     * @return void
     * @author zifangsky
     * @date 2018/7/3 17:50
     * @since 1.0.0
     */
    public boolean creatTable(String tableName, List<String> columnFamily) {
        Admin admin = null;
        try {
            admin = connection.getAdmin();

            List<ColumnFamilyDescriptor> familyDescriptors = new ArrayList<>(columnFamily.size());

            columnFamily.forEach(cf -> {
                familyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(cf)).build());
            });

            TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName))
                    .setColumnFamilies(familyDescriptors)
                    .build();

            if (admin.tableExists(TableName.valueOf(tableName))) {
                log.debug("table Exists!");
            } else {
                admin.createTable(tableDescriptor);
                log.debug("create table Success!");
            }
        } catch (IOException e) {
            log.error(MessageFormat.format("创建表{0}失败", tableName), e);
            return false;
        } finally {
            close(admin, null, null);
        }
        return true;
    }

    /**
     * 预分区创建表
     *
     * @param tableName    表名
     * @param columnFamily 列族名的集合
     * @param splitKeys    预分期region
     * @return 是否创建成功
     */
    public boolean createTableBySplitKeys(String tableName, List<String> columnFamily, byte[][] splitKeys) {
        Admin admin = null;
        try {
            if (StringUtils.isBlank(tableName) || columnFamily == null
                    || columnFamily.size() == 0) {
                log.error("===Parameters tableName|columnFamily should not be null,Please check!===");
                return false;
            }
            admin = connection.getAdmin();
            if (admin.tableExists(TableName.valueOf(tableName))) {
                return true;
            } else {
                List<ColumnFamilyDescriptor> familyDescriptors = new ArrayList<>(columnFamily.size());

                columnFamily.forEach(cf -> {
                    familyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(cf)).build());
                });

                TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName))
                        .setColumnFamilies(familyDescriptors)
                        .build();

                //指定splitkeys
                admin.createTable(tableDescriptor, splitKeys);
                log.info("===Create Table " + tableName
                        + " Success!columnFamily:" + columnFamily.toString()
                        + "===");
            }
        } catch (IOException e) {
            log.error("", e);
            return false;
        } finally {
            close(admin, null, null);
        }

        return true;
    }

    /**
     * 自定义获取分区splitKeys
     */
    public byte[][] getSplitKeys(String[] keys) {
        if (keys == null) {
            //默认为10个分区
            keys = new String[]{"1|", "2|", "3|", "4|",
                    "5|", "6|", "7|", "8|", "9|"};
        }
        byte[][] splitKeys = new byte[keys.length][];
        //升序排序
        TreeSet<byte[]> rows = new TreeSet<byte[]>(Bytes.BYTES_COMPARATOR);
        for (String key : keys) {
            rows.add(Bytes.toBytes(key));
        }

        Iterator<byte[]> rowKeyIter = rows.iterator();
        int i = 0;
        while (rowKeyIter.hasNext()) {
            byte[] tempRow = rowKeyIter.next();
            rowKeyIter.remove();
            splitKeys[i] = tempRow;
            i++;
        }
        return splitKeys;
    }

    /**
     * 按startKey和endKey，分区数获取分区
     */
    public static byte[][] getHexSplits(String startKey, String endKey, int numRegions) {
        byte[][] splits = new byte[numRegions - 1][];
        BigInteger lowestKey = new BigInteger(startKey, 16);
        BigInteger highestKey = new BigInteger(endKey, 16);
        BigInteger range = highestKey.subtract(lowestKey);
        BigInteger regionIncrement = range.divide(BigInteger.valueOf(numRegions));
        lowestKey = lowestKey.add(regionIncrement);
        for (int i = 0; i < numRegions - 1; i++) {
            BigInteger key = lowestKey.add(regionIncrement.multiply(BigInteger.valueOf(i)));
            byte[] b = String.format("%016x", key).getBytes();
            splits[i] = b;
        }
        return splits;
    }

    /**
     * 获取table
     *
     * @param tableName 表名
     * @return Table
     * @throws IOException IOException
     */
    private Table getTable(String tableName) throws IOException {
        return connection.getTable(TableName.valueOf(tableName));
    }

    /**
     * 查询库中所有表的表名
     */
    public List<String> getAllTableNames() {
        List<String> result = new ArrayList<>();

        Admin admin = null;
        try {
            admin = connection.getAdmin();
            TableName[] tableNames = admin.listTableNames();

            for (TableName tableName : tableNames) {
                result.add(tableName.getNameAsString());
            }
        } catch (IOException e) {
            log.error("获取所有表的表名失败", e);
        } finally {
            close(admin, null, null);
        }

        return result;
    }

    /**
     * 遍历查询指定表中的所有数据
     *
     * @param tableName 表名
     * @return java.util.Map<java.lang.String, java.util.Map < java.lang.String, java.lang.String>>
     * @author zifangsky
     * @date 2018/7/3 18:21
     * @since 1.0.0
     */
    public Map<String, Map<String, String>> getResultScanner(String tableName) {
        Scan scan = new Scan();
        return this.queryData(tableName, scan);
    }

    /**
     * 根据startRowKey和stopRowKey遍历查询指定表中的所有数据
     *
     * @param tableName   表名
     * @param startRowKey 起始rowKey
     * @param stopRowKey  结束rowKey
     * @return java.util.Map<java.lang.String, java.util.Map < java.lang.String, java.lang.String>>
     * @author zifangsky
     * @date 2018/7/4 18:21
     * @since 1.0.0
     */
    public Map<String, Map<String, String>> getResultScanner(String tableName, String startRowKey, String stopRowKey) {
        Scan scan = new Scan();

        if (StringUtils.isNoneBlank(startRowKey) && StringUtils.isNoneBlank(stopRowKey)) {
            scan.withStartRow(Bytes.toBytes(startRowKey));
            scan.withStopRow(Bytes.toBytes(stopRowKey));
        }

        return this.queryData(tableName, scan);
    }

    /**
     * 通过行前缀过滤器查询数据
     *
     * @param tableName 表名
     * @param prefix    以prefix开始的行键
     * @return java.util.Map<java.lang.String, java.util.Map < java.lang.String, java.lang.String>>
     * @author zifangsky
     * @date 2018/7/4 18:21
     * @since 1.0.0
     */
    public Map<String, Map<String, String>> getResultScannerPrefixFilter(String tableName, String prefix) {
        Scan scan = new Scan();

        if (StringUtils.isNoneBlank(prefix)) {
            Filter filter = new PrefixFilter(Bytes.toBytes(prefix));
            scan.setFilter(filter);
        }

        return this.queryData(tableName, scan);
    }

    /**
     * 通过列前缀过滤器查询数据
     *
     * @param tableName 表名
     * @param prefix    以prefix开始的列名
     * @return java.util.Map<java.lang.String, java.util.Map < java.lang.String, java.lang.String>>
     * @author zifangsky
     * @date 2018/7/4 18:21
     * @since 1.0.0
     */
    public Map<String, Map<String, String>> getResultScannerColumnPrefixFilter(String tableName, String prefix) {
        Scan scan = new Scan();

        if (StringUtils.isNoneBlank(prefix)) {
            Filter filter = new ColumnPrefixFilter(Bytes.toBytes(prefix));
            scan.setFilter(filter);
        }

        return this.queryData(tableName, scan);
    }

    /**
     * 查询行键中包含特定字符的数据
     *
     * @param tableName 表名
     * @param keyword   包含指定关键词的行键
     * @return java.util.Map<java.lang.String, java.util.Map < java.lang.String, java.lang.String>>
     * @author zifangsky
     * @date 2018/7/4 18:21
     * @since 1.0.0
     */
    public Map<String, Map<String, String>> getResultScannerRowFilter(String tableName, String keyword) {
        Scan scan = new Scan();

        if (StringUtils.isNoneBlank(keyword)) {
            Filter filter = new RowFilter(CompareOperator.GREATER_OR_EQUAL, new SubstringComparator(keyword));
            scan.setFilter(filter);
        }

        return this.queryData(tableName, scan);
    }

    /**
     * 查询列名中包含特定字符的数据
     *
     * @param tableName 表名
     * @param keyword   包含指定关键词的列名
     * @return java.util.Map<java.lang.String, java.util.Map < java.lang.String, java.lang.String>>
     * @author zifangsky
     * @date 2018/7/4 18:21
     * @since 1.0.0
     */
    public Map<String, Map<String, String>> getResultScannerQualifierFilter(String tableName, String keyword) {
        Scan scan = new Scan();

        if (StringUtils.isNoneBlank(keyword)) {
            Filter filter = new QualifierFilter(CompareOperator.GREATER_OR_EQUAL, new SubstringComparator(keyword));
            scan.setFilter(filter);
        }

        return this.queryData(tableName, scan);
    }


    /**
     * 通过表名以及过滤条件查询数据
     *
     * @param tableName 表名
     * @param scan      过滤条件
     * @return java.util.Map<java.lang.String, java.util.Map < java.lang.String, java.lang.String>>
     * @author zifangsky
     * @date 2018/7/4 16:13
     * @since 1.0.0
     */
    private Map<String, Map<String, String>> queryData(String tableName, Scan scan) {
        //<rowKey,对应的行数据>
        Map<String, Map<String, String>> result = new HashMap<>();

        ResultScanner rs = null;
        // 获取表
        Table table = null;
        try {
            table = getTable(tableName);
            rs = table.getScanner(scan);
            for (Result r : rs) {
                //每一行数据
                Map<String, String> columnMap = new HashMap<>();
                String rowKey = null;
                for (Cell cell : r.listCells()) {
                    if (rowKey == null) {
                        rowKey = Bytes.toString(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
                    }
                    columnMap.put(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()), Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }

                if (rowKey != null) {
                    result.put(rowKey, columnMap);
                }
            }
        } catch (IOException e) {
            log.error(MessageFormat.format("遍历查询指定表中的所有数据失败,tableName:{0}"
                    , tableName), e);
        } finally {
            close(null, rs, table);
        }

        return result;
    }

    /**
     * 根据tableName和rowKey精确查询一行的数据
     *
     * @param tableName 表名
     * @param rowKey    行键
     * @return java.util.Map<java.lang.String, java.lang.String> 返回一行的数据
     * @author zifangsky
     * @date 2018/7/3 16:07
     * @since 1.0.0
     */
    public Map<String, String> getRowData(String tableName, String rowKey) {
        //返回的键值对
        Map<String, String> result = new HashMap<>();

        Get get = new Get(Bytes.toBytes(rowKey));
        // 获取表
        Table table = null;
        try {
            table = getTable(tableName);
            Result hTableResult = table.get(get);
            if (hTableResult != null && !hTableResult.isEmpty()) {
                for (Cell cell : hTableResult.listCells()) {
//                System.out.println("family:" + Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength()));
//                System.out.println("qualifier:" + Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()));
//                System.out.println("value:" + Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
//                System.out.println("Timestamp:" + cell.getTimestamp());
//                System.out.println("-------------------------------------------");
                    result.put(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()), Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
            }
        } catch (IOException e) {
            log.error(MessageFormat.format("查询一行的数据失败,tableName:{0},rowKey:{1}"
                    , tableName, rowKey), e);
        } finally {
            close(null, null, table);
        }

        return result;
    }

    /**
     * 根据tableName、rowKey、familyName、column查询指定单元格的数据
     *
     * @param tableName  表名
     * @param rowKey     rowKey
     * @param familyName 列族名
     * @param columnName 列名
     * @return java.lang.String
     * @author zifangsky
     * @date 2018/7/4 10:58
     * @since 1.0.0
     */
    public String getColumnValue(String tableName, String rowKey, String familyName, String columnName) {
        String str = null;
        Get get = new Get(Bytes.toBytes(rowKey));
        // 获取表
        Table table = null;
        try {
            table = getTable(tableName);
            Result result = table.get(get);
            if (result != null && !result.isEmpty()) {
                Cell cell = result.getColumnLatestCell(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
                if (cell != null) {
                    str = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                }
            }
        } catch (IOException e) {
            log.error(MessageFormat.format("查询指定单元格的数据失败,tableName:{0},rowKey:{1},familyName:{2},columnName:{3}"
                    , tableName, rowKey, familyName, columnName), e);
        } finally {
            close(null, null, table);
        }

        return str;
    }

    /**
     * 根据tableName、rowKey、familyName、column查询指定单元格多个版本的数据
     *
     * @param tableName  表名
     * @param rowKey     rowKey
     * @param familyName 列族名
     * @param columnName 列名
     * @param versions   需要查询的版本数
     * @return java.util.List<java.lang.String>
     * @author zifangsky
     * @date 2018/7/4 11:16
     * @since 1.0.0
     */
    public List<String> getColumnValuesByVersion(String tableName, String rowKey, String familyName, String columnName, int versions) {
        //返回数据
        List<String> result = new ArrayList<>(versions);

        // 获取表
        Table table = null;
        try {
            table = getTable(tableName);
            Get get = new Get(Bytes.toBytes(rowKey));
            get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
            //读取多少个版本
            get.readVersions(versions);
            Result hTableResult = table.get(get);
            if (hTableResult != null && !hTableResult.isEmpty()) {
                for (Cell cell : hTableResult.listCells()) {
                    result.add(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
            }
        } catch (IOException e) {
            log.error(MessageFormat.format("查询指定单元格多个版本的数据失败,tableName:{0},rowKey:{1},familyName:{2},columnName:{3}"
                    , tableName, rowKey, familyName, columnName), e);
        } finally {
            close(null, null, table);
        }

        return result;
    }

    /**
     * 为表添加 or 更新数据
     *
     * @param tableName  表名
     * @param rowKey     rowKey
     * @param familyName 列族名
     * @param columns    列名数组
     * @param values     列值得数组
     * @author zifangsky
     * @date 2018/7/3 17:26
     * @since 1.0.0
     */
    public void putData(String tableName, String rowKey, String familyName, String[] columns, String[] values) {
        // 获取表
        Table table = null;
        try {
            table = getTable(tableName);

            putData(table, rowKey, tableName, familyName, columns, values);
        } catch (Exception e) {
            log.error(MessageFormat.format("为表添加 or 更新数据失败,tableName:{0},rowKey:{1},familyName:{2}"
                    , tableName, rowKey, familyName), e);
        } finally {
            close(null, null, table);
        }
    }

    /**
     * 为表添加 or 更新数据
     *
     * @param table      Table
     * @param rowKey     rowKey
     * @param tableName  表名
     * @param familyName 列族名
     * @param columns    列名数组
     * @param values     列值得数组
     * @author zifangsky
     * @date 2018/7/3 17:26
     * @since 1.0.0
     */
    private void putData(Table table, String rowKey, String tableName, String familyName, String[] columns, String[] values) {
        try {
            //设置rowkey
            Put put = new Put(Bytes.toBytes(rowKey));

            if (columns != null && values != null && columns.length == values.length) {
                for (int i = 0; i < columns.length; i++) {
                    if (columns[i] != null && values[i] != null) {
                        put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columns[i]), Bytes.toBytes(values[i]));
                    } else {
                        throw new NullPointerException(MessageFormat.format("列名和列数据都不能为空,column:{0},value:{1}"
                                , columns[i], values[i]));
                    }
                }
            }

            table.put(put);
            log.debug("putData add or update data Success,rowKey:" + rowKey);
            table.close();
        } catch (Exception e) {
            log.error(MessageFormat.format("为表添加 or 更新数据失败,tableName:{0},rowKey:{1},familyName:{2}"
                    , tableName, rowKey, familyName), e);
        }
    }

    /**
     * 为表的某个单元格赋值
     *
     * @param tableName  表名
     * @param rowKey     rowKey
     * @param familyName 列族名
     * @param column1    列名
     * @param value1     列值
     * @author zifangsky
     * @date 2018/7/4 10:20
     * @since 1.0.0
     */
    public void setColumnValue(String tableName, String rowKey, String familyName, String column1, String value1) {
        Table table = null;
        try {
            // 获取表
            table = getTable(tableName);
            // 设置rowKey
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(column1), Bytes.toBytes(value1));

            table.put(put);
            log.debug("add data Success!");
        } catch (IOException e) {
            log.error(MessageFormat.format("为表的某个单元格赋值失败,tableName:{0},rowKey:{1},familyName:{2},column:{3}"
                    , tableName, rowKey, familyName, column1), e);
        } finally {
            close(null, null, table);
        }
    }

    /**
     * 删除指定的单元格
     *
     * @param tableName  表名
     * @param rowKey     rowKey
     * @param familyName 列族名
     * @param columnName 列名
     * @return boolean
     * @author zifangsky
     * @date 2018/7/4 11:41
     * @since 1.0.0
     */
    public boolean deleteColumn(String tableName, String rowKey, String familyName, String columnName) {
        Table table = null;
        Admin admin = null;
        try {
            admin = connection.getAdmin();

            if (admin.tableExists(TableName.valueOf(tableName))) {
                // 获取表
                table = getTable(tableName);
                Delete delete = new Delete(Bytes.toBytes(rowKey));
                // 设置待删除的列
                delete.addColumns(Bytes.toBytes(familyName), Bytes.toBytes(columnName));

                table.delete(delete);
                log.debug(MessageFormat.format("familyName({0}):columnName({1})is deleted!", familyName, columnName));
            }

        } catch (IOException e) {
            log.error(MessageFormat.format("删除指定的列失败,tableName:{0},rowKey:{1},familyName:{2},column:{3}"
                    , tableName, rowKey, familyName, columnName), e);
            return false;
        } finally {
            close(admin, null, table);
        }
        return true;
    }

    /**
     * 根据rowKey删除指定的行
     *
     * @param tableName 表名
     * @param rowKey    rowKey
     * @return boolean
     * @author zifangsky
     * @date 2018/7/4 13:26
     * @since 1.0.0
     */
    public boolean deleteRow(String tableName, String rowKey) {
        Table table = null;
        Admin admin = null;
        try {
            admin = connection.getAdmin();

            if (admin.tableExists(TableName.valueOf(tableName))) {
                // 获取表
                table = getTable(tableName);
                Delete delete = new Delete(Bytes.toBytes(rowKey));

                table.delete(delete);
                log.debug(MessageFormat.format("row({0}) is deleted!", rowKey));
            }
        } catch (IOException e) {
            log.error(MessageFormat.format("删除指定的行失败,tableName:{0},rowKey:{1}"
                    , tableName, rowKey), e);
            return false;
        } finally {
            close(admin, null, table);
        }
        return true;
    }

    /**
     * 根据columnFamily删除指定的列族
     *
     * @param tableName    表名
     * @param columnFamily 列族
     * @return boolean
     * @author zifangsky
     * @date 2018/7/4 13:26
     * @since 1.0.0
     */
    public boolean deleteColumnFamily(String tableName, String columnFamily) {
        Admin admin = null;
        try {
            admin = connection.getAdmin();

            if (admin.tableExists(TableName.valueOf(tableName))) {
                admin.deleteColumnFamily(TableName.valueOf(tableName), Bytes.toBytes(columnFamily));
                log.debug(MessageFormat.format("familyName({0}) is deleted!", columnFamily));
            }
        } catch (IOException e) {
            log.error(MessageFormat.format("删除指定的列族失败,tableName:{0},columnFamily:{1}"
                    , tableName, columnFamily), e);
            return false;
        } finally {
            close(admin, null, null);
        }
        return true;
    }

    /**
     * 删除表
     *
     * @param tableName 表名
     * @author zifangsky
     * @date 2018/7/3 18:02
     * @since 1.0.0
     */
    public boolean deleteTable(String tableName) {
        Admin admin = null;
        try {
            admin = connection.getAdmin();

            if (admin.tableExists(TableName.valueOf(tableName))) {
                admin.disableTable(TableName.valueOf(tableName));
                admin.deleteTable(TableName.valueOf(tableName));
                log.debug(tableName + "is deleted!");
            }
        } catch (IOException e) {
            log.error(MessageFormat.format("删除指定的表失败,tableName:{0}"
                    , tableName), e);
            return false;
        } finally {
            close(admin, null, null);
        }
        return true;
    }

    /**
     * 关闭流
     */
    private void close(Admin admin, ResultScanner rs, Table table) {
        if (admin != null) {
            try {
                admin.close();
            } catch (IOException e) {
                log.error("关闭Admin失败", e);
            }
        }

        if (rs != null) {
            rs.close();
        }

        if (table != null) {
            try {
                table.close();
            } catch (IOException e) {
                log.error("关闭Table失败", e);
            }
        }
    }
}
