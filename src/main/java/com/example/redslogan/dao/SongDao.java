package com.example.redslogan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.redslogan.entity.Song;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongDao extends BaseMapper<Song> {
}
