package com.edt.util;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JsonResult {
    private boolean success;
    private String msg;
    private Object data;



    public static JsonResult success(){
        return new JsonResult(true,null,null);
    }

    public static JsonResult fail(String msg){
        return new JsonResult(false,msg,null);
    }
}
