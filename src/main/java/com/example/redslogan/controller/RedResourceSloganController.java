package com.example.redslogan.controller;

import com.example.redslogan.entity.Result;
import com.example.redslogan.entity.Slogan;
import com.example.redslogan.entity.VO.SloganVo;
import com.example.redslogan.service.RedResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/redResourceSlogan")
public class RedResourceSloganController {
    @Autowired
    RedResourceService redResourceService;
    @GetMapping("/getSloganList")
    public Result getSloganList(@RequestParam(value = "content",required = false) String content){
        return Result.success(redResourceService.getSloganList(content));

    }

    @GetMapping("/getSlogan/{id}")
    public Result getSlogan(@PathVariable Integer id){

        return Result.success(redResourceService.getSlogan(id));

    }


//    @DeleteMapping("/delete/{id}")
//    public Result deleteSlogan(@PathVariable Integer id){
//
//    }
//
//    @PostMapping("/addslogan")
//    public Result addslogan(@RequestBody Slogan slogan){
//
//    }
//
//    @PutMapping("/updateslogan")
//    public Result updateSlogan(@RequestBody SloganVo sloganVo){
//
//    }
}
