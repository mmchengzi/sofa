package com.enjoyor.soa.traffic.core.smsPlatform.dao;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.KkInfoUPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;

import java.util.List;
import java.util.Map;

public interface KkInfoUDao {

	Page queryKkInfoU(Map<String, Object> map, Page page);

	List<KkInfoUPojo> queryKkInfoU(Map<String, Object> map);


}