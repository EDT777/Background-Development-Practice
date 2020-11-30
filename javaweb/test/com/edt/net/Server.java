package com.edt.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建一个服务端对象 serverSocket
        ServerSocket ss = new ServerSocket(10086);
        //监听客户端的连接，获取和客户端通信的socket对象
        Socket socket =ss.accept();
        //从socket获取输入流，接收客户端发送的数据
        InputStream is =socket.getInputStream();
        byte[] buff = new byte[1024];
        int len=0;
        while ((len=is.read())!=-1){
            System.out.println(new String(buff,0,len));
        }
        //调用socket对象 shutdownInput 方法通知客户端数据接收完毕
        socket.shutdownInput();
        //从socket中拿到输出流亡客户端发送数据
        OutputStream os = socket.getOutputStream();
        os.write("你好，客户端".getBytes());
        //调用socket 对象 shutdownOutput 方法通知客户端数据发送完毕
        socket.shutdownOutput();
        //关闭socket对象
        socket.close();
    }
}
