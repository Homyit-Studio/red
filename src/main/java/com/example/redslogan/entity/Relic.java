package com.example.redslogan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("relic")
public class Relic {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private String introduction;

    private String imageIdList;
    private Integer typeId;
    private String relicName;

}
