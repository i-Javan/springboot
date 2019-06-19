package com.movebtick.hadoop01;

import com.movebrick.hadoop01.Hadoop01Appcaliction;
import com.movebrick.hadoop01.module.reduce.mapper.WordCountMap;
import com.movebrick.hadoop01.module.reduce.reducer.WordCountReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Hadoop01Appcaliction.class)
public class Test01 extends Test02 {

    //@Value("${hdfs.path}")
    private String path = "hdfs://172.16.104.203:9000";
    //@Value("${hdfs.username}")
    private String username = "root";

    private static FileSystem fileSystem;
    private static Configuration configuration;

    private static String hdfsPath;
    private static String hdfsName;
    private static final int bufferSize = 1024 * 1024 * 64;

    static {
        System.err.println("----- 静态块 -----");
    }

    {
        System.err.println("----- 代码块 -----");
    }

    public Test01() {
        System.err.println("----- 构造函数 -----");
    }

    @PostConstruct
    public void getPath() {
        System.err.println("----- PostConstruct -----");
        hdfsPath = this.path;
    }

    @PostConstruct
    public void getName() {
        hdfsName = this.username;
    }

    public static String getHdfsPath() {
        return hdfsPath;
    }

    public String getUsername() {
        return username;
    }

    /**
     * 获取HDFS配置信息
     *
     * @return
     */
    private static Configuration getConfiguration() {
        if (StringUtils.isEmpty(configuration)) {
            configuration = new Configuration();
            configuration.set("fs.defaultFS", hdfsPath);
            //configuration.set("mapred.job.tracker", hdfsPath);
        }
        return configuration;
    }

    /**
     * 获取HDFS文件系统对象
     *
     * @return
     * @throws Exception
     */
    public static FileSystem getFileSystem() {
        // 客户端去操作hdfs时是有一个用户身份的，默认情况下hdfs客户端api会从jvm中获取一个参数作为自己的用户身份 DHADOOP_USER_NAME=hadoop
//        也可以在构造客户端fs对象时，通过参数传递进去
        if (StringUtils.isEmpty(fileSystem)) {
            System.setProperty("HADOOP_USER_NAME", "hadoop");
            try {
                fileSystem = FileSystem.get(new URI(hdfsPath), getConfiguration(), hdfsName);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return fileSystem;
    }

    @Test
    public void application() throws Exception {
        System.err.println("---------- Start ------------");
        // 服务器文件
        Path serverPath = new Path("/input/三国演义.txt");
        // 原始文件
        Path localhostDataPath = new Path("D:\\work space\\git-springboot\\movebrick-hadoop\\movebrick-hadoop01\\src\\main\\resources\\data\\1500000.txt");
        // 目标目录
        Path serverCatalog = new Path("/input");
        // 服务器文件
        Path deletePath = new Path("/input/delete.txt");

        // 统计文件
        Path statisticsPath = new Path("/input/三国演义无换行版.txt");
        // 统计结果输出文件目录
        Path outputPath = new Path("/output/三国演义无换行版");
        // 统计结果输出文件
        Path outputFilePath = new Path("/output/三国演义无换行版/part-r-00000");

        System.err.println(getConfiguration());
        System.err.println(getFileSystem());
        System.err.println(getHdfsPath());
        System.err.println(getUsername());
        getParant();
        System.err.println("----------------------");
        FileSystem fs = getFileSystem();
        System.err.println("FileSystem:" + fs);
        System.err.println("---------- HDFS ------------");
        // 调用文件系统的文件复制方法，第一个参数是否删除原文件true为删除，默认为false
        fs.copyFromLocalFile(false, localhostDataPath, serverPath);
        System.err.println("从本地复制文件到服务器:" + fs.exists(serverPath));
        System.err.println("重命名:" + fs.rename(serverPath, deletePath));
        System.err.println("判断是否存在:" + fs.exists(deletePath));
        System.err.println("删除文件:" + fs.deleteOnExit(deletePath));
        System.err.println("复制文件:");
        //HdfsUtil.copyFile("/feng/31878.txt","/input/三国演义.txt");
        System.err.println("---------- 查询目录下全部文件 ------------");
        RemoteIterator<LocatedFileStatus> filesList = fs.listFiles(serverCatalog, true);
        List<Map<String, String>> returnList = new ArrayList<>();
        while (filesList.hasNext()) {
            LocatedFileStatus next = filesList.next();
            String fileName = next.getPath().getName();
            Path filePath = next.getPath();
            Map<String, String> map = new HashMap<>();
            map.put("fileName", fileName);
            map.put("filePath", filePath.toString());
            returnList.add(map);
            System.err.println("\t全部文件:" + map);
        }
        System.err.println("----------- 词频统计 ----------");

        Thread.sleep(1000);//睡眠一秒

        System.err.println("输出目录是否存在：" + fs.exists(outputPath));
        Configuration conf = getConfiguration();
        System.err.println("conf:" + conf);
        Job job = Job.getInstance(conf, "1500000.txt");
        job.setMapperClass(WordCountMap.class);
        job.setCombinerClass(WordCountReduce.class);
        job.setReducerClass(WordCountReduce.class);


        job.setOutputKeyClass(Text.class);//设置输出Key类型
        job.setOutputValueClass(IntWritable.class);//设置输出Value类型
        job.setInputFormatClass(CombineTextInputFormat.class);// 小文件合并设置
        CombineTextInputFormat.setMaxInputSplitSize(job, 10 * 1024 * 1024);// 最大分片
        CombineTextInputFormat.setMinInputSplitSize(job, 4 * 1024 * 1024);// 最小分片

        FileInputFormat.addInputPath(job, statisticsPath);
        FileOutputFormat.setOutputPath(job, outputPath);
        job.waitForCompletion(true);
        System.err.println("---------- 读取内容：------------");
        FSDataInputStream inputStream = fs.open(outputFilePath);
        // 防止中文乱码
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String lineTxt = "";
        StringBuffer sb = new StringBuffer();
        while ((lineTxt = reader.readLine()) != null) {
            sb.append(lineTxt);
        }
        System.err.println("------------ 文件内容： ----------");
        System.err.println(sb.toString());
        if (fs.exists(outputPath)) {//判断输出目录是否存在
            fs.deleteOnExit(outputPath);//删除已有内容
        }
        System.err.println("------------ End ----------");
        reader.close();
        fs.close();
    }

    @Test
    public void curd() throws Exception {
        // 服务器文件
        Path serverPath = new Path("/input/groupSort2.txt");
        // 原始文件
        Path localhostDataPath = new Path("D:\\work space\\git-springboot\\movebrick-hadoop\\movebrick-hadoop01\\src\\main\\resources\\data\\groupSort2.txt");

        FileSystem fs = getFileSystem();
        Configuration conf = getConfiguration();
        fs.copyFromLocalFile(false, localhostDataPath, serverPath);
        System.err.println("从本地复制文件到服务器:" + fs.exists(serverPath));
    }


}
