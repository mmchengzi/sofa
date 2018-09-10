package com.enjoyor.soa.traffic.core.smsPlatform.server.impl;

import com.enjoyor.soa.traffic.core.smsPlatform.dao.SmsLogDao;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.server.SmsLogService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"unchecked", "rawtypes"})
@Service
public class SmsLogServiceImpl implements SmsLogService {
	@Autowired
	private SmsLogDao dao;

	@Override
	public Page querySmsLog(Map map, Page page) {
		return dao.querySmsLog(map, page);
	}

	@Override
	public List querySmsLog(String token, Map map) {
		return dao.querySmsLog(map);
	}

	@Override
	public int insertSmsLog(String token, SmsLogPojo smsLogPojo) {
		return dao.insertSmsLog(smsLogPojo);
	}

	@Override
	public int updataSmsLog(String token, SmsLogPojo smsLogPojo) {
		return dao.updateSmsLog(smsLogPojo);
	}


	@Override
	public int delSmsLog(String token, Map map) {

		return dao.delSmsLog(map);
	}
}
