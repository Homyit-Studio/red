package com.example.redslogan.Utils;

import com.example.redslogan.dao.ImagesDao;
import com.example.redslogan.entity.VO.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ImageUtils {
    static public List<ListVo> getImageList(String imageIdList,ImagesDao imagesDao){

        String[] str=imageIdList.split(",");
        List<ListVo> map=new ArrayList<>();
        for (String s : str) {
            if(!s.isEmpty()&&s!=null){
                map.add(new ListVo(Integer.parseInt(s),imagesDao.selectById(Integer.parseInt(s)).getImageLink()));
            }
        }
        return map;

    }
}
