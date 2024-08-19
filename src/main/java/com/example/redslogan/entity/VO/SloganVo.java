package com.example.redslogan.entity.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SloganVo {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private List<ListVo> sloganImage;
    private String intro;
}
