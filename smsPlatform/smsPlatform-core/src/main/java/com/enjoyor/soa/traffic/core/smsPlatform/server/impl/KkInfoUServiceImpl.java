package com.enjoyor.soa.traffic.core.smsPlatform.server.impl;

import com.enjoyor.soa.traffic.core.smsPlatform.dao.KkInfoUDao;
import com.enjoyor.soa.traffic.core.smsPlatform.server.KkInfoUService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@SuppressWarnings({"unchecked", "rawtypes"})
@Service
public class KkInfoUServiceImpl implements KkInfoUService {
	@Autowired
	private KkInfoUDao kkInfoUDao ;
	@Override
	public Page queryKkInfoU(Map map, Page page) {
		return kkInfoUDao.queryKkInfoU(map,page);
	}

	@Override
	public List queryKkInfoU(Map map) {
		return kkInfoUDao.queryKkInfoU(map);
	}
}
