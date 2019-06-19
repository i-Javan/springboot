package com.movebrick.sqoop.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.sqoop.Sqoop;
import org.apache.sqoop.tool.SqoopTool;
import org.apache.sqoop.util.OptionsFileUtil;

public class SqoopService {
    private static int importDataFromMysql() throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");
        String[] args = new String[]{
                "--connect", "jdbc:mysql://172.16.104.204:3306/air",
                "--driver", "com.mysql.cj.jdbc.Driver",
                "-username", "root",
                "-password", "bigdata",
                "--table", "dept",
                "-m", "1",
                "--target-dir", "/home/sqoop/fenga"
        };

        String[] expandArguments = OptionsFileUtil.expandArguments(args);

        SqoopTool tool = SqoopTool.getTool("import");

        Configuration conf = new Configuration();
        conf.set("fs.default.name", "hdfs://172.16.104.203:9000");//设置HDFS服务地址
        Configuration loadPlugins = SqoopTool.loadPlugins(conf);

        Sqoop sqoop = new Sqoop((com.cloudera.sqoop.tool.SqoopTool) tool, loadPlugins);
        return Sqoop.runSqoop(sqoop, expandArguments);
    }

    public static void main(String[] args) throws Exception {
        importDataFromMysql();
    }
}
