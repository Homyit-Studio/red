package com.example.redslogan.controller;

import com.example.redslogan.entity.Dto.StoryDto;
import com.example.redslogan.entity.Result;
import com.example.redslogan.entity.VO.StoryContentListVo;
import com.example.redslogan.service.RedSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/scene")
public class RedSceneController {
    @Autowired
    private RedSceneService redSceneService;
    @GetMapping("/storylist")
    public Result getStoryList(){
        return Result.success(redSceneService.getStoryList());

    }
    @GetMapping("/story")
    public Result getStory(@RequestParam(value = "id",required = false) Integer id){
        return Result.success(redSceneService.getStory(id));

    }
    @PostMapping("/notice")
    public Result addNotice(@RequestBody String notice){

        redSceneService.addNotice(notice);
        return Result.success();

    }


    @GetMapping("/getnotice")
    public Result getNotice(){

        return Result.success(redSceneService.getNotice());

    }

//    @PostMapping("/addStory")
//    public Result addStory(@RequestBody StoryDto storyDto){
//
//        redSceneService.addStory(storyDto);
//        return Result.success();
//
//    }

//    @DeleteMapping("/deleteStory/{id}")
//    public Result deleteStory(@PathVariable Integer id){
//
//    }
//
//    @PutMapping("/updateStory")
//    public Result updateStory(@RequestBody StoryDto storyDto){
//
//    }
//
//    @PostMapping("/uploadfile")
//    public Result upload(@RequestParam("file")MultipartFile[] multipartFile){
//
//
//    }
}
