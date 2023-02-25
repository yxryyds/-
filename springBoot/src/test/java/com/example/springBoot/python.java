package com.example.springBoot;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Slf4j
public class python {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 12000;

    public static void main(String[] args) throws JSONException {
        System.out.println("请输入一段话：");
        String context ;
        while(true){
            Scanner scanner = new Scanner(System.in);
            context = scanner.nextLine();
            String res = (String) remoteCall(context);
            System.out.println(res);
        }
    }

    private static Object remoteCall(String content) throws JSONException {
        // 访问服务进程的套接字
        Socket socket = null;
        log.info("调用远程接口:host=>"+HOST+",port=>"+PORT);
        try {
            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
            socket = new Socket(HOST,PORT);
            // 获取输出流对象
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            // 发送内容
            out.print(content);
            // 告诉服务进程，内容发送完毕，可以开始处理
            out.print("over");
            // 获取服务进程的输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String tmp = null;
            StringBuilder sb = new StringBuilder();
            // 读取内容
            while((tmp=br.readLine())!=null)
                sb.append(tmp).append('\n');
            // 解析结果
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(socket!=null) socket.close();
            }
            catch (IOException e) {}
            log.info("远程接口调用结束.");
        }
        return null;
    }
}
