package com.enjoyor.soa.traffic.core.smsPlatform.server.impl;

import com.enjoyor.soa.traffic.core.smsPlatform.dao.MvJdcInfoDao;
import com.enjoyor.soa.traffic.core.smsPlatform.dao.SmsLogDao;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.server.MvJdcInfoService;
import com.enjoyor.soa.traffic.core.smsPlatform.server.SmsLogService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"unchecked", "rawtypes"})
@Service
public class MvJdcInfoServiceImpl implements MvJdcInfoService {
	@Autowired
	private MvJdcInfoDao dao;


	@Override
	public List queryMvJdcInfo( Map map) {
		return dao.queryMvJdcInfo(map);
	}
}
