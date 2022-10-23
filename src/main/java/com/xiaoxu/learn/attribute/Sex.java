package com.xiaoxu.learn.attribute;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum Sex {
    /**
     *
     */
    MALE(1, "男"),
    FEMALE(2, "女");
    @EnumValue
    private final int flag;
    private final String name;

    Sex(int flag, String name) {
        this.flag = flag;
        this.name = name;
    }
}
