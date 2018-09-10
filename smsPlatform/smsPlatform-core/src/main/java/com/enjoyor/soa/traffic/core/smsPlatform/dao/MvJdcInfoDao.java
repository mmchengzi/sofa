package com.enjoyor.soa.traffic.core.smsPlatform.dao;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.MvJdcInfoPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;

import java.util.List;
import java.util.Map;

public interface MvJdcInfoDao {
	List<MvJdcInfoPojo> queryMvJdcInfo(Map<String, Object> map);
}
