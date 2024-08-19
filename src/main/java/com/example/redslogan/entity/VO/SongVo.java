package com.example.redslogan.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongVo {
    private Integer id;

    private String songName;
    private String songLink;
    private List<ListVo> opernImages;
    private String text;

    private String coverImage;
}
