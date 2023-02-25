package com.example.springBoot.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

@Slf4j
@Controller
public class TestDonload {

    /**
     * 实现下载功能
     * @throws IOException
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> testDownload() throws IOException {
        String realPath = "D:\\idea\\springBoot\\springBoot\\src\\main\\resources\\static\\img\\1.jpg";
        //创建输入流
        InputStream inputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[inputStream.available()];
        // 将流读入数组中
        inputStream.read(bytes);

        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置下载的方式和文件名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus status = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity =  new ResponseEntity<>(bytes, headers, status);
        inputStream.close();
        return responseEntity;
    }

    /**
     * 文件上传的方式必须为post
     * form表单的上传格式必须为multipart/form-data（二进制形式上传）
     * 上传的文件可以使用MultipartFile接收
     * 如果要上传多个文件，则先得在input中加上 multiple，然后使用MultipartFile[]数组接受就行
     */
    @SneakyThrows(Exception.class)
    @RequestMapping("/upload")
    public String update(MultipartFile photo){
        // 获取上传的文件的名字
        String photoName = photo.getOriginalFilename();
        // 获取文件的后缀名
        String substring = photoName.substring(photoName.lastIndexOf("."));
        // 获取UUID
        String uuid = UUID.randomUUID().toString();
        // 拼接位新的文件名
        photoName = uuid + substring;

        System.out.println(photoName);
        String savePath = "D:\\idea\\springBoot\\springBoot\\src\\main\\resources\\static\\img" + File.separator + photoName;
        // 将文件保存至指定路径
        photo.transferTo(new File(savePath));
        return "index";

    }
}
