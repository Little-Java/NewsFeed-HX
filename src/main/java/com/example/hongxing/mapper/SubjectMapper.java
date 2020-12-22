package com.example.hongxing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hongxing.dto.SubjectDto;
import com.example.hongxing.dto.TreeChidrenDto;
import com.example.hongxing.entity.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectMapper extends BaseMapper<SubjectEntity> {

    List<SubjectDto> selectSubjectByIndex(@Param("idsList")List<Integer> idsList);

    List<TreeChidrenDto> getSubjectListById(@Param("sbId")String sbId);

    List<TreeChidrenDto> querySubjectTree();

    List<TreeChidrenDto> querySubjectTrees(@Param("sbId")String sbId, @Param("length") Integer length);
}