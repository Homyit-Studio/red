package com.example.redslogan.entity.VO;

import com.example.redslogan.entity.Enum.StoryContentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoryContentVo {
    private Integer order;

    private StoryContentType type;
    private String content;


}
