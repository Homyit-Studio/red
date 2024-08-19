package com.example.redslogan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.redslogan.Utils.ImageUtils;
import com.example.redslogan.dao.ImagesDao;
import com.example.redslogan.dao.RelicDao;
import com.example.redslogan.dao.RelicTypeDao;
import com.example.redslogan.entity.*;
import com.example.redslogan.entity.Enum.Code;
import com.example.redslogan.entity.VO.CoverListVo;
import com.example.redslogan.entity.VO.ListVo;
import com.example.redslogan.entity.VO.RelicVo;
import com.example.redslogan.exception.SystemException;
import com.example.redslogan.service.RelicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RelicServiceImpl implements RelicService {

    @Autowired
    private RelicTypeDao relicTypeDao;
    @Autowired
    private RelicDao relicDao;
    @Autowired
    private ImagesDao imagesDao;

    @Override
    public List<RelicType> getRelicType() {
        return relicTypeDao.selectList(null);
    }

    @Override
    public List<CoverListVo> getRelicList(Integer id,String name) {
        LambdaQueryChainWrapper<Relic> lambdaQueryChainWrapper=new LambdaQueryChainWrapper<>(relicDao);
        if(Objects.nonNull(id)){
            lambdaQueryChainWrapper.eq(Relic::getTypeId,id);
        }
        if(name!=null&&!name.isEmpty()){
            lambdaQueryChainWrapper.like(Relic::getRelicName,name);
        }
        List<Relic> list=lambdaQueryChainWrapper.list();
        return getCoverList(list);


    }

    private List<CoverListVo> getCoverList(List<Relic> list){
        return list.stream()
                .map(m->{
                    String[] img=m.getImageIdList().split(",");
                    return new CoverListVo(m.getId(),m.getRelicName(),imagesDao.selectById(img[0]).getImageLink());
                })
                .collect(Collectors.toList());

    }

    @Override
    public RelicVo getRelic(Integer id) {
        Relic relic=relicDao.selectById(id);
        if(relic==null){
            throw new SystemException(Code.NULL_ERR.getMsg(),Code.NULL_ERR.getStateNum());
        }
        RelicVo relicVo=new RelicVo();
        BeanUtils.copyProperties(relic,relicVo);
        relicVo.setImageList(ImageUtils.getImageList(relic.getImageIdList(),imagesDao));
        return relicVo;
    }


}
