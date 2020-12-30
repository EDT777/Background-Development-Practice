package cn.wolfcode.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Setter
@Getter
public abstract class BaseDomain implements Serializable {
    /** 主键*/
    protected Long id;
}
