package com.enjoyor.soa.traffic.core.smsPlatform.dao.impl;

import com.enjoyor.soa.traffic.core.smsPlatform.commmon.SqlSessionDaoSupport;
import com.enjoyor.soa.traffic.core.smsPlatform.dao.KkInfoUDao;
import com.enjoyor.soa.traffic.core.smsPlatform.dao.SmsLogDao;
import com.enjoyor.soa.traffic.core.smsPlatform.mapper.KkInfoUMapper;
import com.enjoyor.soa.traffic.core.smsPlatform.mapper.SmsLogMapper;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.KkInfoUPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.util.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
@Repository
public class KkInfoUDaoImpl extends SqlSessionDaoSupport implements KkInfoUDao {
	@Autowired
	private KkInfoUMapper kkInfoUMapper;

	@Override
	public Page queryKkInfoU(Map<String, Object> map, Page page) {
		return this.queryPageInfo("queryKkInfoU", map, page);
	}

	@Override
	public List<KkInfoUPojo> queryKkInfoU(Map<String, Object> map) {
		return kkInfoUMapper.queryKkInfoU(map);
	}
}