package com.example.hongxing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hongxing.dto.ArticleDto;
import com.example.hongxing.entity.ArticleEntity;

import java.util.List;

public interface ArticleService extends IService<ArticleEntity> {

    ArticleDto getArticleById(Integer acId);

    List<ArticleDto> getArticleBySubjectId(Integer subjectId);
}
