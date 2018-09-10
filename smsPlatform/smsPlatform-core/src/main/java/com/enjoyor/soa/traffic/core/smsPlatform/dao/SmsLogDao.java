package com.enjoyor.soa.traffic.core.smsPlatform.dao;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;

import java.util.List;
import java.util.Map;

public interface SmsLogDao {

	Page querySmsLog(Map<String, Object> map,Page page);

	List<SmsLogPojo> querySmsLog(Map<String, Object> map);

	int insertSmsLog(SmsLogPojo area);

	int updateSmsLog(SmsLogPojo area);

	int delSmsLog(Map<String, Object> map);
}