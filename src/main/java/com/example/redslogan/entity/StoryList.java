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
@TableName("story_list")
public class StoryList {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String storyName;

    public StoryList(String storyName) {
        this.storyName = storyName;
    }
}
