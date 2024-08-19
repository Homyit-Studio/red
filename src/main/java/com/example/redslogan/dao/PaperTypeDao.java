package com.example.redslogan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.redslogan.entity.PaperType;
import org.apache.catalina.mbeans.BaseCatalinaMBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperTypeDao extends BaseMapper<PaperType> {
}
