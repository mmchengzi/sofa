package com.enjoyor.soa.traffic.core.smsPlatform.dao.impl;

import com.enjoyor.soa.traffic.core.smsPlatform.commmon.SqlSessionDaoSupport;
import com.enjoyor.soa.traffic.core.smsPlatform.dao.MvJdcInfoDao;
import com.enjoyor.soa.traffic.core.smsPlatform.dao.SmsLogDao;
import com.enjoyor.soa.traffic.core.smsPlatform.mapper.MvJdcInfoMapper;
import com.enjoyor.soa.traffic.core.smsPlatform.mapper.SmsLogMapper;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.MvJdcInfoPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
@Repository
public class MvJdcInfoDaoImpl extends SqlSessionDaoSupport implements MvJdcInfoDao {
	@Autowired
	private MvJdcInfoMapper mvJdcInfoMapper;


	@Override
	public List<MvJdcInfoPojo> queryMvJdcInfo(Map<String, Object> map) {
		return mvJdcInfoMapper.queryMvJdcInfo(map);
	}
}
