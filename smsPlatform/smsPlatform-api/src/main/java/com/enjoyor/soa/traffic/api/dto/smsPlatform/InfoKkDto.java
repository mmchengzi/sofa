package com.enjoyor.soa.traffic.api.dto.smsPlatform;

import java.io.Serializable;

public class InfoKkDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 点位编码（有向编号）
	 */
	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
