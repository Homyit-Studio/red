package com.example.redslogan.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelicVo {

    private Integer id;

    private String introduction;

    private List<ListVo> imageList;
    private Integer typeId;
    private String relicName;
}
