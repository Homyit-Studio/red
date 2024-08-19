package com.example.redslogan.controller;

import com.example.redslogan.entity.Paper;
import com.example.redslogan.entity.Result;
import com.example.redslogan.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    PaperService paperService;
    @GetMapping("/getPaperList")
    public Result getPaperList(@RequestParam(value = "id",required = false) Integer id,
                               @RequestParam(value = "content",required = false) String content){

        return Result.success(paperService.getPaperList(id,content));

    }


    @GetMapping("/getPaper")
    public Result getPaper(@RequestParam(value = "id",required = false) Integer id){

        return Result.success(paperService.getPaper(id));

    }

//    @DeleteMapping("/delete/{id}")
//    public Result deletePaper(@PathVariable Integer id){
//
//    }
//
//    @PostMapping("/addpaper")
//    public Result addPaper(@RequestBody Paper paper){
//
//    }
    @GetMapping("/typelist")
    public Result getTypeList(){
        return Result.success(paperService.getTypeList());

    }

//    @DeleteMapping("/deletetype/{id}")
//    public Result deletetype(@PathVariable Integer id){
//
//    }
//
//    @PostMapping("/addtype")
//    public Result addtype(@RequestBody Paper paper){
//
//    }



}
