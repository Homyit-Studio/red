package com.example.redslogan.service;

import com.example.redslogan.entity.Paper;
import com.example.redslogan.entity.PaperType;
import com.example.redslogan.entity.VO.ListVo;

import java.util.List;

public interface PaperService {
    List<ListVo> getPaperList(Integer id,String content);
    Paper getPaper(Integer id);

    List<PaperType> getTypeList();
}
