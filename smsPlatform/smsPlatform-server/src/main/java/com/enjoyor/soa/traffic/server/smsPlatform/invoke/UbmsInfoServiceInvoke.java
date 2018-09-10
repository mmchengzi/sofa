package com.enjoyor.soa.traffic.server.smsPlatform.invoke;

import com.enjoyor.bigdata.spark.DubboHighFreqService;
import com.enjoyor.soa.traffic.server.smsPlatform.commmon.SpringReader;
import org.springframework.stereotype.Service;

import com.enjoyor.soa.traffic.api.ubms.dto.OffsiteInfoDto;
import com.enjoyor.soa.traffic.api.ubms.service.dubbo.DubboOffsiteInfoService;
import com.enjoyor.soa.traffic.api.ubms.service.CallbackListener;
import com.enjoyor.soa.traffic.api.ubms.service.CallbackService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;


@Service
public class UbmsInfoServiceInvoke {


	private DubboOffsiteInfoService dubboOffsiteInfoService() {
		return (DubboOffsiteInfoService) SpringReader.context.getBean("dubboOffsiteInfoService");
	}

	public ResultPojo  getOffsiteInfo(){
		return this.dubboOffsiteInfoService().getOffsiteInfo();
	}

	/**
	 * 返回指定编码的非现场点位分页信息
	 * @param offsiteId 非现场点位编码
	 * @param offsiteName 非现场点位名称
	 * @param orderSeq 排列方式
	 * @return ResultPojo 非现场点位信息
	 */
	public ResultPojo getPageOffsiteInfo(Page page, String offsiteId, String offsiteName, String orderSeq){
		return this.dubboOffsiteInfoService().getPageOffsiteInfo(page,offsiteId,offsiteName,orderSeq);
	}

}
