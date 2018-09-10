package com.enjoyor.soa.traffic.core.smsPlatform.dao.impl;

import com.enjoyor.soa.traffic.core.smsPlatform.commmon.SqlSessionDaoSupport;
import com.enjoyor.soa.traffic.core.smsPlatform.dao.SmsLogDao;
import com.enjoyor.soa.traffic.core.smsPlatform.mapper.SmsLogMapper;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@SuppressWarnings("rawtypes")
@Repository
public class SmsLogDaoImpl extends SqlSessionDaoSupport implements SmsLogDao{
	@Autowired
	private SmsLogMapper smsLogMapper;

	@Override
	public Page querySmsLog(Map<String, Object> map, Page page) {
		return this.queryPageInfo("querySmsLog", map, page);
	}

	@Override
	public List<SmsLogPojo> querySmsLog(Map<String, Object> map) {
		return smsLogMapper.querySmsLog(map);
	}

	@Override
	public int insertSmsLog(SmsLogPojo smsLogPojo) {
		return smsLogMapper.insertSmsLog(smsLogPojo);
	}

	@Override
	public int updateSmsLog(SmsLogPojo smsLogPojo) {
		return smsLogMapper.updateSmsLog(smsLogPojo);
	}

	@Override
	public int delSmsLog(Map<String, Object> map) {
		return smsLogMapper.delSmsLog(map);
	}
}
