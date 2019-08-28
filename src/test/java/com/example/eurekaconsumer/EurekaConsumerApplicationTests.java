package com.example.eurekaconsumer;

import com.example.eurekaconsumer.feignClient.UploadService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaConsumerApplicationTests {
    @Autowired
    private UploadService uploadService;
    @Test
    public void contextLoads() {
        File file = new File("E:\\电子图书\\1056864-Eromanga Sensei\\00000001.jpg");
        DiskFileItem fileItem = (DiskFileItem)new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE,true, file.getName());
        try (InputStream input = new FileInputStream(file);
             OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);

        System.out.println(uploadService.handlerFileUpload(multi));
        while (true){}
    }

}
