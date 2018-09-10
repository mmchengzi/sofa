package com.enjoyor.soa.traffic.api.dto.smsPlatform;

import java.io.Serializable;

public class HighFreqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String licenseNum;
	private String licenseType;
	private String carUserName;
	private String carUserTel;
	private String carColor;
	private int freq;

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getCarUserName() {
		return carUserName;
	}

	public void setCarUserName(String carUserName) {
		this.carUserName = carUserName;
	}

	public String getCarUserTel() {
		return carUserTel;
	}

	public void setCarUserTel(String carUserTel) {
		this.carUserTel = carUserTel;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}
}
