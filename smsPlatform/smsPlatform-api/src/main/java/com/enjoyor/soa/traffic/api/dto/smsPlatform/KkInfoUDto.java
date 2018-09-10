package com.enjoyor.soa.traffic.api.dto.smsPlatform;

import java.io.Serializable;

public class KkInfoUDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String outSbbh;
	private String kkmc;

	public String getOutSbbh() {
		return outSbbh;
	}

	public void setOutSbbh(String outSbbh) {
		this.outSbbh = outSbbh;
	}

	public String getKkmc() {
		return kkmc;
	}

	public void setKkmc(String kkmc) {
		this.kkmc = kkmc;
	}

	@Override
	public String toString() {
		return "KkInfoUDto{" +
				"outSbbh='" + outSbbh + '\'' +
				", kkmc='" + kkmc + '\'' +
				'}';
	}
}
