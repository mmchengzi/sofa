package com.enjoyor.soa.traffic.server.smsPlatform.invoke;

import com.enjoyor.bigdata.spark.DubboHighFreqService;
import com.enjoyor.soa.traffic.server.smsPlatform.commmon.SpringReader;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighFreqServiceInvoke {


	private DubboHighFreqService highFreqService() {
		return (DubboHighFreqService) SpringReader.context.getBean("dubboHighFreqService");
	}
/**
	 *
	 * @param licenseType
	 * @param licenseNum
	 * @param startDay
	 * @param endDay
	 * @param pointIds
	 * @param minCounts
	 * @param maxCounts
	 * @param limit
	 * retrun List<HighFreqDto>
	 */

	@SuppressWarnings("unchecked")
	public ResultPojo getHighFreq(String licenseType, String licenseNum, String startDay, String endDay, List<String> pointIds, Integer minCounts, Integer maxCounts, Integer limit) {
		try {
			return this.highFreqService().getHighFreq(licenseType, licenseNum, startDay, endDay, pointIds, minCounts, maxCounts, limit);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultHelper.getResult(e);
		}
	}

}
