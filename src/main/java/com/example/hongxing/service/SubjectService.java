package com.example.hongxing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hongxing.dto.SubjectDto;
import com.example.hongxing.dto.TreeChidrenDto;
import com.example.hongxing.entity.SubjectEntity;

import java.util.List;

public interface SubjectService extends IService<SubjectEntity> {

    List<SubjectDto> querySubjectListByTopicId(Integer topicId);

    List<TreeChidrenDto> getSubjectListById(String sbId);

    List<TreeChidrenDto> querySubjectTree(String subjectId);
}
