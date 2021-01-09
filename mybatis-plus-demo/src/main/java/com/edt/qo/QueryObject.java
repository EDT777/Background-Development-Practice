package com.edt.qo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QueryObject {
    private int currentPage=1;
    private int pageSize=3;
}
