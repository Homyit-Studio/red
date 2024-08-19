package com.example.redslogan.service;

import com.example.redslogan.entity.Relic;
import com.example.redslogan.entity.RelicType;
import com.example.redslogan.entity.VO.CoverListVo;
import com.example.redslogan.entity.VO.RelicVo;

import java.util.List;

public interface RelicService {

    List<RelicType> getRelicType();
    List<CoverListVo> getRelicList(Integer id, String name);

    RelicVo getRelic(Integer id);
}
