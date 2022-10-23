package com.xiaoxu.learn.bean;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Commodity {
    private Integer id;
    private String name;
    private Double price;
    @Version
    private Integer version;
}
