package com.heima.minio.test;


import com.heima.file.service.FileStorageService;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.FileInputStream;
import java.io.FileNotFoundException;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MinIOTest {

    @Autowired
    private FileStorageService fileStorageService;

    @Test
    public void test() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Afile\\studynote\\heima-leadnews\\tmp\\css\\index.css");
       String path = fileStorageService.uploadHtmlFile("","list.html",fileInputStream);
        System.out.println(path);
    }

    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        try {

            fileInputStream =  new FileInputStream("D:\\Afile\\studynote\\heima-leadnews\\tmp\\js\\index.js");;

            //1.创建minio链接客户端
            MinioClient client = MinioClient.builder()
                    .credentials("minio", "minio123")
                    .endpoint("http://106.14.202.122:9000")
                    .build();

             //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("plugins/js/index.js")//文件名
                    .contentType("text/js")//文件类型
                    .bucket("leadnews")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
                    .build();
           client.putObject(putObjectArgs);

            System.out.println("http://106.14.202.122:9090/leadnews/list.html");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}