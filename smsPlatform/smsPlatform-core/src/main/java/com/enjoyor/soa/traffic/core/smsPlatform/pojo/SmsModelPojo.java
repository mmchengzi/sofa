package com.enjoyor.soa.traffic.core.smsPlatform.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SmsModelPojo {
    private String modelCode;

    private String modelName;

    private String modelContent;

    private String wfxwCode;

    private String modelType;

    private Date modelTime;

    private String modelXgr;

    private String wfxw;

    private String deptId;

    private String deptName;
    private BigDecimal plateCount;

    private BigDecimal roadCount;

    private BigDecimal dateCount;

    private BigDecimal placeCount;
    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getModelContent() {
        return modelContent;
    }

    public void setModelContent(String modelContent) {
        this.modelContent = modelContent == null ? null : modelContent.trim();
    }

    public String getWfxwCode() {
        return wfxwCode;
    }

    public void setWfxwCode(String wfxwCode) {
        this.wfxwCode = wfxwCode == null ? null : wfxwCode.trim();
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType == null ? null : modelType.trim();
    }

    public Date getModelTime() {
        return modelTime;
    }

    public void setModelTime(Date modelTime) {
        this.modelTime = modelTime;
    }

    public String getModelXgr() {
        return modelXgr;
    }

    public void setModelXgr(String modelXgr) {
        this.modelXgr = modelXgr == null ? null : modelXgr.trim();
    }

    public String getWfxw() {
        return wfxw;
    }

    public void setWfxw(String wfxw) {
        this.wfxw = wfxw == null ? null : wfxw.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public BigDecimal getPlateCount() {
        return plateCount;
    }

    public void setPlateCount(BigDecimal plateCount) {
        this.plateCount = plateCount;
    }

    public BigDecimal getRoadCount() {
        return roadCount;
    }

    public void setRoadCount(BigDecimal roadCount) {
        this.roadCount = roadCount;
    }

    public BigDecimal getDateCount() {
        return dateCount;
    }

    public void setDateCount(BigDecimal dateCount) {
        this.dateCount = dateCount;
    }

    public BigDecimal getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(BigDecimal placeCount) {
        this.placeCount = placeCount;
    }
}