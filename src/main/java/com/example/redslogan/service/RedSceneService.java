package com.example.redslogan.service;

import com.example.redslogan.entity.Dto.StoryDto;
import com.example.redslogan.entity.StoryList;
import com.example.redslogan.entity.VO.StoryContentListVo;
import com.example.redslogan.entity.VO.StoryContentVo;

import java.util.List;

public interface RedSceneService {
    List<StoryList> getStoryList();
    List<StoryContentVo> getStory(Integer id);

    void addNotice(String notice);
    String getNotice();

    void addStory(StoryDto storyDto);
}
