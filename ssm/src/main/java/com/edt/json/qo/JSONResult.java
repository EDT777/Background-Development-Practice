package com.edt.json.qo;

import lombok.*;
import org.aspectj.weaver.ast.Or;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JSONResult {
    private  String msg;
    private boolean success;
}
