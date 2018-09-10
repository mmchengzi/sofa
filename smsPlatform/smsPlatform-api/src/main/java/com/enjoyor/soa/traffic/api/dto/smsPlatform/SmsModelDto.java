package com.enjoyor.soa.traffic.api.dto.smsPlatform;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SmsModelDto implements Serializable {
	private static final long serialVersionUID = 1L;
	//模版编码
	private String modelCode;
	//模版名称
	private String modelName;
	//模版类型
	private String modelType;
	//模版类型
	private String modelTypeName;
	//部门编号
	private String deptId;
	//部门名称
	private String deptName;
	//创建用户
	private String modelXgr;
	// 模板内容：& 替换时间,*替换车牌 ,#替换地点
	private String modelContent;
	//创建时间
	private Date modelTime;
	private BigDecimal plateCount;

	private BigDecimal roadCount;

	private BigDecimal dateCount;

	private BigDecimal placeCount;
	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

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

	public String getModelXgr() {
		return modelXgr;
	}

	public void setModelXgr(String modelXgr) {
		this.modelXgr = modelXgr;
	}

	public String getModelContent() {
		return modelContent;
	}

	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}

	public Date getModelTime() {
		return modelTime;
	}

	public void setModelTime(Date modelTime) {
		this.modelTime = modelTime;
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

	public String getModelTypeName() {
		return modelTypeName;
	}

	public void setModelTypeName(String modelTypeName) {
		this.modelTypeName = modelTypeName;
	}
}
