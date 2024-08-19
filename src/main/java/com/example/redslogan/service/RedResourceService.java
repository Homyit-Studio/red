package com.example.redslogan.service;

import com.example.redslogan.entity.VO.*;

import java.util.List;

public interface RedResourceService {

    List<CoverListVo> getSongList(String name);
    SongVo getSong(Integer id);

    List<CoverListVo> getSloganList(String content);

    SloganVo getSlogan(Integer id);

    List<CoverListVo> getFameList(String name);

    FameVo getFame(Integer id);






}
