package com.example.redslogan.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoryContentListVo {

    List<StoryContentVo>  storyContentVoList;

}
