package com.enjoyor.soa.traffic.core.smsPlatform.server.impl;

import com.enjoyor.soa.traffic.core.smsPlatform.dao.SmsModelDao;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsModelPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.server.SmsModelService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"unchecked", "rawtypes"})
@Service
public class SmsModelServiceImpl implements SmsModelService {
	@Autowired
	private SmsModelDao dao;

	@Override
	public Page querySmsModel(Map map, Page page) {
		return dao.querySmsModel(map, page);
	}

	@Override
	public List querySmsModel(String token, Map map) {
		return dao.querySmsModel(map);
	}

	@Override
	public int updataSmsModel(String token, SmsModelPojo smsModelPojo) {
		return dao.updateSmsModel(smsModelPojo);
	}
	@Override
	public int insertSmsModel(String token, SmsModelPojo smsModelPojo) {
		return dao.insertSmsModel(smsModelPojo);
	}

	@Override
	public int delSmsModel(String token, Map map) {
		return dao.delSmsModel(map);
	}
}
