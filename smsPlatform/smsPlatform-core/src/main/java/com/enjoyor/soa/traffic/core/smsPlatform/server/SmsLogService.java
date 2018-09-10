package com.enjoyor.soa.traffic.core.smsPlatform.server;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;

import java.util.List;
import java.util.Map;

public interface SmsLogService {
	Page querySmsLog(Map map, Page page);

	List  querySmsLog(String token,Map map);

	int insertSmsLog(String token,SmsLogPojo smsLogPojo);
	int updataSmsLog(String token,SmsLogPojo smsLogPojo);

	int delSmsLog(String token,Map map);
}
