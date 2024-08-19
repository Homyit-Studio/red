package com.example.redslogan.controller;

import com.example.redslogan.entity.Result;
import com.example.redslogan.entity.Song;
import com.example.redslogan.entity.VO.SongVo;
import com.example.redslogan.service.RedResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redresourceSong")
public class RedResourceSongController {
    @Autowired
    RedResourceService redResourceService;
    @GetMapping("/getSongList")
    public Result getSongList(@RequestParam(value = "name",required = false) String name){
        return Result.success(redResourceService.getSongList(name));

    }

    @GetMapping("/getSong")
    public Result getSong(@RequestParam(value = "id",required = false) Integer id){

        return Result.success(redResourceService.getSong(id));

    }

//    @DeleteMapping("/delete/{id}")
//    public Result deleteSong(@PathVariable Integer id){
//
//    }
//
//    @PostMapping("/addsong")
//    public Result addSong(@RequestBody Song song){
//
//    }
//
//    @PutMapping("/updatesong")
//    public Result updateSong(@RequestBody SongVo songVo){
//
//    }
}
