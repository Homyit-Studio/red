package com.example.redslogan.entity.Enum;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StoryContentType {

    TEXT("0"),
    VIDEO("1"),
    IMAGE("2");
    @EnumValue
    private String num;

    StoryContentType(String num) {
        this.num = num;
    }
}
