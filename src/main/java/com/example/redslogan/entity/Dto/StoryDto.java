package com.example.redslogan.entity.Dto;

import com.example.redslogan.entity.VO.StoryContentVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoryDto {
    private String storyName;
    private List<StoryContentVo> content;
}
