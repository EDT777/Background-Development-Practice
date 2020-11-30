package com.edt.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//tcp 客户端
public class Client {
    public static void main(String[] args) throws IOException {
        //创建一个连接某个服务器的Socket对象
        Socket socket = new Socket("127.0.0.1",10086);
        //从Socket中拿到输出流往服务端发送数据
        OutputStream out = socket.getOutputStream();
        out.write("你好，服务器".getBytes());
        //调用socket 对象 shutdownOutput 方法通知服务端数据发送完毕
        socket.shutdownOutput();
        //从 socket中拿到输入流服务端回馈的数据
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len=0;
        while ((len=is.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }
        //调用socket对象 shutdownInput 方法通知服务端数据接收完毕
        socket.shutdownInput();
        //关闭socket对象
        socket.close();
    }
}
