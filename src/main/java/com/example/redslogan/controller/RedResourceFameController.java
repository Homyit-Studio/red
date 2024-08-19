package com.example.redslogan.controller;

import com.example.redslogan.entity.Fame;
import com.example.redslogan.entity.Result;
import com.example.redslogan.entity.VO.FameVo;
import com.example.redslogan.service.RedResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redresourceFame")
public class RedResourceFameController {
    @Autowired
    private RedResourceService redResourceService;
    @GetMapping("/getFameList")
    public Result getFameList(@RequestParam(value = "name",required = false) String name){
        return Result.success(redResourceService.getFameList(name));

    }

    @GetMapping("/getFame")
    public Result getFame(@RequestParam(value = "id",required = false) Integer id){

        return Result.success(redResourceService.getFame(id));

    }

//    @DeleteMapping("/delete/{id}")
//    public Result deleteFame(@PathVariable Integer id){
//
//    }
//
//    @PostMapping("/addfame")
//    public Result addfame(@RequestBody Fame fame){
//
//    }
//
//    @PutMapping("/updatesong")
//    public Result updatefame(@RequestBody FameVo fameVo){
//
//    }
}
