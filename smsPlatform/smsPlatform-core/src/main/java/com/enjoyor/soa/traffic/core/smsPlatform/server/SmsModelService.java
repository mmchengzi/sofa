package com.enjoyor.soa.traffic.core.smsPlatform.server;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsModelPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;

import java.util.List;
import java.util.Map;

public interface SmsModelService {

	Page querySmsModel(Map map, Page page);
	List querySmsModel(String token,Map map);
	int insertSmsModel(String token,SmsModelPojo smsModelPojo);
	int updataSmsModel(String token,SmsModelPojo smsModelPojo);
	int delSmsModel(String token,Map map);
}
