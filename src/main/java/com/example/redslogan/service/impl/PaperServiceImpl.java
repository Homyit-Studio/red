package com.example.redslogan.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.redslogan.dao.PaperDao;
import com.example.redslogan.dao.PaperTypeDao;
import com.example.redslogan.entity.Paper;
import com.example.redslogan.entity.PaperType;
import com.example.redslogan.entity.VO.ListVo;
import com.example.redslogan.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperDao paperDao;

    @Autowired
    PaperTypeDao paperTypeDao;
    @Override
    public List<ListVo> getPaperList(Integer id,String content) {
        LambdaQueryChainWrapper<Paper> paperLambdaQueryChainWrapper=new LambdaQueryChainWrapper<>(paperDao);
        if(Objects.isNull(id)&&(Objects.isNull(content)||content.isEmpty())){
            return paperDao.selectList(null).stream()
                    .map(m->new ListVo(m.getId(),m.getPaperName()))
                    .collect(Collectors.toList());
        }
        if(Objects.nonNull(id)){
            paperLambdaQueryChainWrapper.eq(Paper::getTypeId,id);
        }
        if(content!=null&&!content.isEmpty()){
            paperLambdaQueryChainWrapper.like(Paper::getPaperName,content);
        }
        return paperLambdaQueryChainWrapper.list().stream()
                .map(m->new ListVo(m.getId(),m.getPaperName()))
                .collect(Collectors.toList());

    }


    @Override
    public Paper getPaper(Integer id) {
        return paperDao.selectById(id);
    }

    @Override
    public List<PaperType> getTypeList() {
        return paperTypeDao.selectList(null);
    }

}
