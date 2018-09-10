package com.enjoyor.soa.traffic.server.smsPlatform.manager;

import com.enjoyor.bigdata.spark.HighFreqDto;
import com.enjoyor.soa.traffic.api.dto.smsPlatform.InfoKkDto;
import com.enjoyor.soa.traffic.api.dto.smsPlatform.MvJdcInfoDto;
import com.enjoyor.soa.traffic.api.ubms.dto.OffsiteInfoDto;
import com.enjoyor.soa.traffic.server.smsPlatform.invoke.HighFreqServiceInvoke;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HighFreqServiceManageService {
	@Autowired
	HighFreqServiceInvoke highFreqServiceInvoke;
	@Autowired
	MvJdcInfoManageService mvJdcInfoManageService;

	public ResultPojo getHighFreq(String startDay, String endDay, List<String> pointIds, Integer minCounts, Integer limit) {
		try {
			startDay = startDay.replaceAll("\\-", "");
			endDay = endDay.replaceAll("\\-", "");
			ResultPojo resultPojo = highFreqServiceInvoke.getHighFreq(null, null, startDay, endDay, pointIds, minCounts, null, limit);
			List<HighFreqDto> dtos = (List<HighFreqDto>) resultPojo.getResultList();
			List<HighFreqDto> resultDtos = new ArrayList<>();
			if (dtos != null) {
				for (int i = 0; i < dtos.size(); i++) {
					if ("无号牌".equals(dtos.get(i).getLicenseNum())) {
						continue;
					}
					String hpzl = dtos.get(i).getLicenseType();
					String carNum = dtos.get(i).getLicenseNum();
					String fzjg = carNum.substring(0, 2);
					if (!"赣A".equals(fzjg) && !"赣M".equals(fzjg)) {
						continue;
					}
					String hphm = carNum.substring(1);
					ResultPojo ret = mvJdcInfoManageService.queryMvJdcInfo(null, hpzl, hphm, "赣A");
					if ("0".equals(ret.getappCode())) {
						List<MvJdcInfoDto> mvJdcInfoDtos = (List<MvJdcInfoDto>) ret.getResultList();
						if (mvJdcInfoDtos != null && mvJdcInfoDtos.size() > 0) {
							dtos.get(i).setCarColor(mvJdcInfoDtos.get(0).getCsysName());
							dtos.get(i).setCarUserTel(mvJdcInfoDtos.get(0).getLxfs());
							dtos.get(i).setCarUserName(mvJdcInfoDtos.get(0).getSyr());
						}
					}
					resultDtos.add(dtos.get(i));
				}

			}
			return ResultHelper.getResult(resultDtos);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
}
