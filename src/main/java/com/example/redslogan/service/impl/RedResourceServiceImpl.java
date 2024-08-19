package com.example.redslogan.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.redslogan.Utils.ImageUtils;
import com.example.redslogan.dao.FameDao;
import com.example.redslogan.dao.ImagesDao;
import com.example.redslogan.dao.SloganDao;
import com.example.redslogan.dao.SongDao;
import com.example.redslogan.entity.Enum.Code;
import com.example.redslogan.entity.Fame;
import com.example.redslogan.entity.Slogan;
import com.example.redslogan.entity.Song;
import com.example.redslogan.entity.VO.*;
import com.example.redslogan.exception.SystemException;
import com.example.redslogan.service.RedResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RedResourceServiceImpl implements RedResourceService {
    @Autowired
    private SongDao songDao;
    @Autowired
    private ImagesDao imagesDao;

    @Autowired
    private SloganDao sloganDao;

    @Autowired
    private FameDao fameDao;
    @Override
    public List<CoverListVo> getSongList(String name) {
        List<Song> list=new ArrayList<>();
        if(name==null||name.isEmpty()){
            list=songDao.selectList(null);
        }else {
            LambdaQueryChainWrapper<Song> lambdaQueryChainWrapper=new LambdaQueryChainWrapper<>(songDao);
            list=lambdaQueryChainWrapper.like(Song::getSongName,name).list();
        }
        return list.stream().map(m->new CoverListVo(m.getId(),m.getSongName(),m.getCoverImage())).collect(Collectors.toList());
    }


    @Override
    public SongVo getSong(Integer id) {
        Song song=songDao.selectById(id);
        if(song==null){
            throw new SystemException(Code.NULL_ERR.getMsg(), Code.NULL_ERR.getStateNum());
        }
        SongVo songVo=new SongVo();
        BeanUtils.copyProperties(song,songVo);
        songVo.setOpernImages(ImageUtils.getImageList(song.getOpernImageList(),imagesDao));
        return songVo;

    }

    @Override
    public List<CoverListVo> getSloganList(String content) {
        List<Slogan> list=new ArrayList<>();
        if(content==null||content.isEmpty()){
            list=sloganDao.selectList(null);

        }else{
            LambdaQueryChainWrapper<Slogan> lambdaQueryChainWrapper=new LambdaQueryChainWrapper<>(sloganDao);
            list=lambdaQueryChainWrapper.like(Slogan::getIntro,content).list();

        }
        return list.stream()
                .map(m->{
                    String[] img=m.getSloganImageList().split(",");
                    return new CoverListVo(m.getId(),m.getIntro(),imagesDao.selectById(img[0]).getImageLink());
                })
                .collect(Collectors.toList());

    }

    @Override
    public SloganVo getSlogan(Integer id) {
        Slogan slogan=sloganDao.selectById(id);
        if(slogan==null){
            throw new SystemException(Code.NULL_ERR.getMsg(), Code.NULL_ERR.getStateNum());
        }
        SloganVo sloganVo=new SloganVo();
        BeanUtils.copyProperties(slogan,sloganVo);
        sloganVo.setSloganImage(ImageUtils.getImageList(slogan.getSloganImageList(),imagesDao));
        return sloganVo;
    }


    @Override
    public List<CoverListVo> getFameList(String name) {
        if(name==null||name.isEmpty()) {

            return getCoverList(fameDao.selectList(null));
        }else{
            LambdaQueryChainWrapper<Fame> lambdaQueryChainWrapper=new LambdaQueryChainWrapper<>(fameDao);
            return getCoverList(lambdaQueryChainWrapper.like(Fame::getFameName,name).list());

        }


    }

    private List<CoverListVo> getCoverList(List<Fame> list){
        return list.stream()
                .map(m->{
                    String[] img=m.getImageIdList().split(",");
                    return new CoverListVo(m.getId(),m.getFameName(),imagesDao.selectById(img[0]).getImageLink());
                })
                .collect(Collectors.toList());

    }

    @Override
    public FameVo getFame(Integer id) {
        Fame fame=fameDao.selectById(id);
        if(fame==null){
            throw new SystemException(Code.NULL_ERR.getMsg(), Code.NULL_ERR.getStateNum());
        }
        FameVo fameVo=new FameVo();
        BeanUtils.copyProperties(fame,fameVo);
        fameVo.setImageList(ImageUtils.getImageList(fame.getImageIdList(),imagesDao));
        return fameVo;

    }


}
