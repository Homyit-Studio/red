package com.example.redslogan.controller;

import com.example.redslogan.entity.Relic;
import com.example.redslogan.entity.Result;
import com.example.redslogan.entity.VO.RelicVo;
import com.example.redslogan.service.RelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relic")
public class RelicController {

    @Autowired
    RelicService relicService;

    @GetMapping("/getlist")
    public Result getRelicList(@RequestParam(value = "id",required = false) Integer id,
                               @RequestParam(value = "name",required = false) String name){
        return Result.success(relicService.getRelicList(id,name));

    }

    @GetMapping("/getRelicType")
    public Result getRelicType(){

        return Result.success(relicService.getRelicType());

    }

    @GetMapping("/getRelic/{id}")
    public Result getRelic(@PathVariable Integer id){
        return Result.success(relicService.getRelic(id));

    }
//    @DeleteMapping("/deletetype/{id}")
//    public Result deleteType(@PathVariable Integer id){
//
//    }
//
//    @PutMapping("/updatetype/{name}")
//    public Result updateType(@PathVariable String name){
//
//    }
//
//    @PostMapping("/addtype/{name}")
//    public Result addType(@PathVariable String name){
//
//
//    }


//    @PostMapping("/addRelic")
//    public Result addRelic(@RequestBody Relic relicVo){
//
//    }


//    @PutMapping("/updateRelic")
//    public Result updateRelic(@RequestBody Relic relicVo){
//
//    }
//    @DeleteMapping("/deleteRelic/{id}")
//    public Result deleteRelic(@PathVariable Integer id){
//
//    }


}
