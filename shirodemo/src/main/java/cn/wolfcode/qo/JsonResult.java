package cn.wolfcode.qo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    private boolean success = true;
    private String msg;
    private Object data; //用于成功时传参数给前端用

    public JsonResult(boolean success,String msg){
        this.success = success;
        this.msg = msg;
    }
}
