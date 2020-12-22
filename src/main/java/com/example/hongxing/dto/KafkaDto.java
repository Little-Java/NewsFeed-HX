package com.example.hongxing.dto;

import java.util.List;

public class KafkaDto {

    private List<String> obsUrl;

    private ArticleDto articleDto;

    public List<String> getObsUrl() {
        return obsUrl;
    }

    public void setObsUrl(List<String> obsUrl) {
        this.obsUrl = obsUrl;
    }

    public ArticleDto getArticleDto() {
        return articleDto;
    }

    public void setArticleDto(ArticleDto articleDto) {
        this.articleDto = articleDto;
    }
}
