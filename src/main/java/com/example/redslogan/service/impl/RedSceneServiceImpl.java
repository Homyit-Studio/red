package com.example.redslogan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.redslogan.Utils.RedisCache;
import com.example.redslogan.dao.StoryContentDao;
import com.example.redslogan.dao.StoryListDao;
import com.example.redslogan.entity.Dto.StoryDto;
import com.example.redslogan.entity.Enum.Code;
import com.example.redslogan.entity.Enum.StoryContentType;
import com.example.redslogan.entity.Story;
import com.example.redslogan.entity.StoryList;
import com.example.redslogan.entity.VO.StoryContentListVo;
import com.example.redslogan.entity.VO.StoryContentVo;
import com.example.redslogan.exception.SystemException;
import com.example.redslogan.service.RedSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RedSceneServiceImpl implements RedSceneService {
    @Autowired
    private StoryListDao storyListDao;

    @Autowired
    private StoryContentDao storyContentDao;
    @Override
    public List<StoryList> getStoryList() {
        return storyListDao.selectList(null);


    }

    @Override
    public List<StoryContentVo> getStory(Integer id) {
        LambdaQueryChainWrapper<Story> lambdaQueryChainWrapper=new LambdaQueryChainWrapper<>(storyContentDao);
        return lambdaQueryChainWrapper.eq(Story::getStoryId,id).list().stream()
                .map(m->new StoryContentVo(m.getContentOrder(),m.getType(),m.getContent()))
                .collect(Collectors.toList());

    }
    @Autowired
    private RedisCache redisCache;
    @Override
    public void addNotice(String notice) {

        redisCache.setCacheObject("notice",notice);

    }

    @Override
    public String getNotice() {
        return redisCache.getCacheObject("notice");
    }

    @Override
    public void addStory(StoryDto storyDto) {

        StoryList storyList=new StoryList(storyDto.getStoryName());

        if(storyListDao.insert(storyList)==0){
            throw new SystemException(Code.ADD_ERR.getMsg(),Code.ADD_ERR.getStateNum());
        }

        storyDto.getContent().forEach(m->{
            if(storyContentDao.insert(new Story(m.getType(),m.getContent(),storyList.getId(),m.getOrder()))==0){
                throw new SystemException(Code.ADD_ERR.getMsg(), Code.ADD_ERR.getStateNum());
            }
        });




    }
}
