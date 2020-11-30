package com.edt.cookie_session.cookie;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Mytest {
    public static void main(String[] args) {
        System.out.println(URLEncoder.encode("谭泽豪"));
        System.out.println(URLDecoder.decode("%E8%B0%AD%E6%B3%BD%E8%B1%AA"));
    }
}
