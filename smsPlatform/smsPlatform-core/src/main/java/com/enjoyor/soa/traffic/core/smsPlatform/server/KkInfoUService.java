package com.enjoyor.soa.traffic.core.smsPlatform.server;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;

import java.util.List;
import java.util.Map;

public interface KkInfoUService {
	Page queryKkInfoU(Map map, Page page);

	List  queryKkInfoU( Map map);


}
