package com.example.hongxing.entity;

import lombok.Data;

@Data
public class PDeptEntity {

    private String deptId;

    private String deptName;

    private String deptEnName;

    private String upperId;

    private Integer sortId;

    private String childWebId;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptEnName() {
        return deptEnName;
    }

    public void setDeptEnName(String deptEnName) {
        this.deptEnName = deptEnName;
    }

    public String getUpperId() {
        return upperId;
    }

    public void setUpperId(String upperId) {
        this.upperId = upperId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getChildWebId() {
        return childWebId;
    }

    public void setChildWebId(String childWebId) {
        this.childWebId = childWebId;
    }
}
