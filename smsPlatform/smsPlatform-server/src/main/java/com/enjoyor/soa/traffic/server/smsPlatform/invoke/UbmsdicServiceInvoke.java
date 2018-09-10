package com.enjoyor.soa.traffic.server.smsPlatform.invoke;

import com.enjoyor.soa.traffic.api.ubms.service.dubbo.DubboDeviceDicService;
import com.enjoyor.soa.traffic.api.ubms.service.dubbo.DubboOffsiteInfoService;
import com.enjoyor.soa.traffic.api.ubms.service.dubbo.DubboPublicDicService;
import com.enjoyor.soa.traffic.server.smsPlatform.commmon.SpringReader;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.stereotype.Service;

@Service
public class UbmsdicServiceInvoke {
	private DubboPublicDicService dubbodicService() {
		return (DubboPublicDicService) SpringReader.context.getBean("dubboPublicDicService");
	}
	/**
	 * 返回指定字典编码的所有下级设备字典
	 * @return ResultPojo 所有下级设备字典
	 */
	public ResultPojo  getPublicDicByParentCode(String parentCode){
		return this.dubbodicService().getPublicDicByParentCode(parentCode);
	}
}
