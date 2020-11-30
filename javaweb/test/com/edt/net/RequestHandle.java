package com.edt.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RequestHandle implements Runnable{
    private Socket s;

    public RequestHandle(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try{
            //读浏览器发送过来的数据
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line =null;
            while ((line=br.readLine())!=null){
                if("".equals(line)){
                    return;
                }
                System.out.println(line);
            }
            s.shutdownInput();
            //给浏览器反馈页面数据
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type: text/html;charset=utf-8");
            ps.println();
            ps.println("<html><head></head><body>hello browser</body></html>");
            ps.flush();
            s.shutdownOutput();
            s.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
