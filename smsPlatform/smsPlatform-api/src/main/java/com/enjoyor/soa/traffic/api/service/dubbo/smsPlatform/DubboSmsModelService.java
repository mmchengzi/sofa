package com.enjoyor.soa.traffic.api.service.dubbo.smsPlatform;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsModelDto;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;

import java.util.List;

public interface DubboSmsModelService {
	/**
	 *
	 * @param modelId
	 * @param modelName
	 * @param modelType
	 * @param createUser
	 * @return
	 */
	public ResultPojo listSmsModel(String token,String modelId, String modelName, String modelType,  String createUser);

	/**
	 *
	 * @param modelId
	 * @param modelName
	 * @param modelType
	 * @param createUser
	 * @param page
	 * @return
	 */
	public ResultPojo getPageSmsModel(String token,String modelId, String modelName, String modelType,  String createUser,Page page);
	/**
	 *  添加修改
	 * @param token
	 * @param smsModelDtos
	 * @return
	 */
	public ResultPojo updataSmsModel(String token, List<SmsModelDto> smsModelDtos );

	/**
	 * 删除
	 * @param token
	 * @param modelIdList
	 * @return
	 */
	public ResultPojo deleteSmsModel(String token, List<String> modelIds );
}
