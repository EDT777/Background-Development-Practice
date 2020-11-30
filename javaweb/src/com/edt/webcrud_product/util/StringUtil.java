package com.edt.webcrud_product.util;
public class StringUtil {
//    字符串的判空功能
    public static boolean hasLength(String val){
        return val!=null && !"".equals(val.trim());
    }

}
