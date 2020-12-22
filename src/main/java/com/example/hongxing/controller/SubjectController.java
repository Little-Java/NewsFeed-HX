package com.example.hongxing.controller;

import com.example.hongxing.common.Result;
import com.example.hongxing.dto.SubjectDto;
import com.example.hongxing.dto.TreeChidrenDto;
import com.example.hongxing.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value="/subjectTree")
    public String subjectTree(){
        return "subjectTree";
    }

    @RequestMapping("/querySubjectListByTopicId")
    @ResponseBody
    public Result<List<SubjectDto>> querySubjectListByTopicId(Integer topicId){
        if(topicId == null){
            return new Result(500, "专题不能为空");
        }
        Result<List<SubjectDto>> result = new Result<List<SubjectDto>>();
        result.setMessage("请求成功");
        result.setStatusCode(200);
        result.setResult(subjectService.querySubjectListByTopicId(topicId));
        return result;
    }

    @RequestMapping("/getSubjectListById")
    @ResponseBody
    public Result<List<TreeChidrenDto>> getSubjectListById(String sbId){
        List<TreeChidrenDto> list = subjectService.getSubjectListById(sbId);
        if(list == null || list.size()<=0){
            return new Result(500, "没有栏目");
        }
        return new Result(0, "请求成功", list, list.size());
    }

    @RequestMapping("/querySubjectTree")
    @ResponseBody
    public Result<List<TreeChidrenDto>> querySubjectTree(String sbId){
        List<TreeChidrenDto> list = subjectService.querySubjectTree(sbId);
        return new Result(200, "请求成功", list);
    }
}
