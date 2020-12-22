package com.example.hongxing.controller;

import com.example.hongxing.common.Result;
import com.example.hongxing.dto.ArticleDto;
import com.example.hongxing.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getArticleBySubjectId")
    @ResponseBody
    public Result getArticleBySubjectId(String subjectId){
       List<ArticleDto> list = articleService.getArticleBySubjectId(Integer.valueOf(subjectId));
        return new Result(200, "请求成功", list);
    }

    @RequestMapping("/getArticleById")
    public Result getArticleById(Integer acId){
        ArticleDto articleDto = articleService.getArticleById(acId);
        return new Result(200, "请求成功", articleDto);
    }
}
