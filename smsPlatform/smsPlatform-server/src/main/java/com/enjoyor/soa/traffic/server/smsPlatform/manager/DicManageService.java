package com.enjoyor.soa.traffic.server.smsPlatform.manager;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.InfoKkDto;
import com.enjoyor.soa.traffic.api.ubms.dto.DeviceDicDto;
import com.enjoyor.soa.traffic.api.ubms.dto.OffsiteInfoDto;
import com.enjoyor.soa.traffic.server.smsPlatform.invoke.UbmsInfoServiceInvoke;
import com.enjoyor.soa.traffic.server.smsPlatform.invoke.UbmsdicServiceInvoke;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DicManageService {
	@Autowired
	UbmsdicServiceInvoke ubmsdicServiceInvoke;


	public ResultPojo getPublicDicByParentCode(String parentCode) {
		try {
			return ubmsdicServiceInvoke.getPublicDicByParentCode(parentCode);

		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
}
