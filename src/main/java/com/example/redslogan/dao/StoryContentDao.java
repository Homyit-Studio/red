package com.example.redslogan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.redslogan.entity.Story;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoryContentDao extends BaseMapper<Story> {
}
