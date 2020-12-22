package com.example.hongxing.dto;

import java.util.List;

public class TreeChidrenDto {

    private String sbId;

    private String sbName;

    private Integer sbIndex;

    private List<TreeChidrenDto> children;

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public Integer getSbIndex() {
        return sbIndex;
    }

    public void setSbIndex(Integer sbIndex) {
        this.sbIndex = sbIndex;
    }

    public List<TreeChidrenDto> getChildren() {
        return children;
    }

    public void setChildren(List<TreeChidrenDto> children) {
        this.children = children;
    }
}
