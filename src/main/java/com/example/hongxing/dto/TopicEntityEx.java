package com.example.hongxing.dto;

import com.example.hongxing.entity.TopicEntity;

public class TopicEntityEx extends TopicEntity {

    private String rootSubjectName;

    public String getRootSubjectName() {
        return rootSubjectName;
    }

    public void setRootSubjectName(String rootSubjectName) {
        this.rootSubjectName = rootSubjectName;
    }
}
