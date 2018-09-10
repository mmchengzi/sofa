package com.enjoyor.soa.traffic.core.smsPlatform.dao.impl;

import com.enjoyor.soa.traffic.core.smsPlatform.commmon.SqlSessionDaoSupport;
import com.enjoyor.soa.traffic.core.smsPlatform.dao.SmsModelDao;
import com.enjoyor.soa.traffic.core.smsPlatform.mapper.SmsModelMapper;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsModelPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
@Repository
public class SmsModelDaoImpl extends SqlSessionDaoSupport implements SmsModelDao {
	@Autowired
	 private  SmsModelMapper mapper;
	@Override
	public Page querySmsModel(Map<String, Object> map, Page page) {
		return this.queryPageInfo("com.enjoyor.soa.traffic.core.smsPlatform.mapper.SmsModelMapper.querySmsModel", map, page);
	}

	@Override
	public List<SmsModelPojo> querySmsModel(Map<String, Object> map) {
		return mapper.querySmsModel(map);
	}

	@Override
	public int insertSmsModel(SmsModelPojo smsModelPojo) {
		return mapper.insertSmsModel(smsModelPojo);
	}

	@Override
	public int updateSmsModel(SmsModelPojo smsModelPojo) {
		return mapper.updateSmsModel(smsModelPojo);
	}

	@Override
	public int delSmsModel(Map<String, Object> map) {
		return mapper.delSmsModel(map);
	}
}
