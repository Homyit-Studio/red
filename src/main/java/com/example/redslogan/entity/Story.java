package com.example.redslogan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.redslogan.entity.Enum.StoryContentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("story_content")
public class Story {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private StoryContentType type;

    private String content;
    private Integer storyId;
    private Integer contentOrder;

    public Story(StoryContentType type, String content, Integer storyId, Integer contentOrder) {
        this.type = type;
        this.content = content;
        this.storyId = storyId;
        this.contentOrder = contentOrder;
    }
}
