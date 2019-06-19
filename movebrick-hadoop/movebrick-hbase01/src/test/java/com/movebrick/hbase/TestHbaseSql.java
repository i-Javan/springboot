package com.movebrick.hbase;

import com.movebrick.hbase.service.HBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 测试Hbase SQL
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HbaseApplication.class)
public class TestHbaseSql {
    @Autowired
    private HBaseService hbaseService;

    /**
     * 测试删除、创建表
     */
    @Test
    public void testCreateTable() {
        //删除表
        hbaseService.deleteTable("test_base");

        //创建表
        hbaseService.createTableBySplitKeys("test_base", Arrays.asList("f", "back"), hbaseService.getSplitKeys(null));

        //插入三条数据
        hbaseService.putData("test_base", "66804_000001", "f", new String[]{"project_id", "varName", "coefs", "pvalues", "tvalues", "create_time"}, new String[]{"40866", "mob_3", "0.9416", "0.0000", "12.2293", "null"});
        hbaseService.putData("test_base", "66804_000002", "f", new String[]{"project_id", "varName", "coefs", "pvalues", "tvalues", "create_time"}, new String[]{"40866", "idno_prov", "0.9317", "0.0000", "9.8679", "null"});
        hbaseService.putData("test_base", "66804_000003", "f", new String[]{"project_id", "varName", "coefs", "pvalues", "tvalues", "create_time"}, new String[]{"40866", "education", "0.8984", "0.0000", "25.5649", "null"});

        //查询数据
        //1. 根据rowKey查询
        Map<String, String> result1 = hbaseService.getRowData("test_base", "66804_000001");
        System.out.println("+++++++++++根据rowKey查询+++++++++++");
        result1.forEach((k, value) -> {
            System.out.println(k + "---" + value);
        });
        System.out.println();

        //精确查询某个单元格的数据
        String str1 = hbaseService.getColumnValue("test_base", "66804_000002", "f", "varName");
        System.out.println("+++++++++++精确查询某个单元格的数据+++++++++++");
        System.out.println(str1);
        System.out.println();

        //2. 遍历查询
        Map<String, Map<String, String>> result2 = hbaseService.getResultScanner("test_base");
        System.out.println("+++++++++++遍历查询+++++++++++");
        result2.forEach((k, value) -> {
            System.out.println(k + "---" + value);
        });
    }


    @Test
    public void test03() {
        List<String> allTableNames = hbaseService.getAllTableNames();
        for (String tablename : allTableNames) {
            System.err.println(tablename);
        }
    }
}
