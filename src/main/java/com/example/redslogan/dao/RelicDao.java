package com.example.redslogan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.redslogan.entity.Relic;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RelicDao extends BaseMapper<Relic> {
}
