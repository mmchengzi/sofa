package com.enjoyor.soa.traffic.server.smsPlatform.manager;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.MvJdcInfoDto;
import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsLogDto;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.MvJdcInfoPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.server.MvJdcInfoService;
import com.enjoyor.soa.traffic.server.smsPlatform.invoke.UbmsdicServiceInvoke;
import com.enjoyor.soa.traffic.util.helper.MapHelper;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MvJdcInfoManageService {
	@Autowired
	MvJdcInfoService service;


	public ResultPojo queryMvJdcInfo(String xh,String hpzl,String hphm,String fzjg) {
		try {
			Map map = new HashMap();
			map.put("xh", xh);
			map.put("hpzl", hpzl);
			map.put("hphm", hphm);
			map.put("fzjg", fzjg);
			return ResultHelper.getResult(MapHelper.lstToList(service.queryMvJdcInfo(map), MvJdcInfoPojo.class, MvJdcInfoDto.class));
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
}
