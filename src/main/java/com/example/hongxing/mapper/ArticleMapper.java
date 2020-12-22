package com.example.hongxing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hongxing.dto.ArticleDto;
import com.example.hongxing.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

    ArticleDto getArticleById(@Param("acId") Integer acId);

    List<ArticleDto> getArticleBySubjectId(@Param("subjectId")Integer subjectId);

}
