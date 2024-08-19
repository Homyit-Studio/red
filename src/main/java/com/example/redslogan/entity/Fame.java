package com.example.redslogan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("resource_fame")
public class Fame {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String intro;

    private String imageIdList;
    private String fameName;
}
