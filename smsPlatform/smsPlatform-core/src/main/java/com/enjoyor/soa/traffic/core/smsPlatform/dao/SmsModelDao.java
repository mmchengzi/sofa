package com.enjoyor.soa.traffic.core.smsPlatform.dao;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsModelPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;

import java.util.List;
import java.util.Map;

public interface SmsModelDao {

	Page querySmsModel(Map<String, Object> map, Page page);
	List<SmsModelPojo> querySmsModel(Map<String,Object> map);
	int insertSmsModel(SmsModelPojo smsModelPojo);
	int updateSmsModel(SmsModelPojo smsModelPojo);
	int delSmsModel(Map<String,Object> map);
}
