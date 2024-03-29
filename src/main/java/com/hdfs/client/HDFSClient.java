package com.hdfs.client;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSClient {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //1、获取fs对象
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.0.101:9000"), configuration, "root");

        //2、执行上传api
        fileSystem.copyFromLocalFile(new Path("/home/rison/data/test.txt"),
                new Path("/test.txt"));
        //3、关闭
        fileSystem.close();
        System.out.println("upload-file end!");

    }
}
