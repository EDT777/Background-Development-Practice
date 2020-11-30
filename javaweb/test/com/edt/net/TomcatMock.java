package com.edt.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatMock {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10010);
        while (true){
            Socket s = ss.accept();
            new Thread(new RequestHandle(s)).start();//并发情况下，效率低，此情况也有io阻塞，传输数据效率低
        }


    }
}
