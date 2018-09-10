package com.enjoyor.soa.traffic.api.service.dubbo.smsPlatform;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsLogDto;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;

import java.util.List;

public interface DubboSmsLogService {
	/**
	 * 获取日志分页
	 * @param msgLogId
	 * @param licenseNum
	 * @param licenseType
	 * @param msgStatus
	 * @param msgSender
	 * @param msgPerson
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public ResultPojo getPageSmsLog(String token,String msgLogId, String licenseNum, String licenseType,String msgStatus,String msgSender,String msgPerson,String startTime, String endTime, Page page);
	/**
	 * 获取日志列表
	 * @param msgLogId
	 * @param licenseNum
	 * @param licenseType
	 * @param msgStatus
	 * @param msgSender
	 * @param msgPerson
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public ResultPojo listSmsLog(String token,String msgLogId, String licenseNum, String licenseType,String msgStatus,String msgSender,String msgPerson,String startTime, String endTime);
	/**
	 *  添加修改
	 * @param token
	 * @param smsLogDtos
	 * @return
	 */
	public ResultPojo updataSmsLog(String token, List<SmsLogDto> smsLogDtos );

	/**
	 * 删除
	 * @param token
	 * @param msgLogIds
	 * @return
	 */
	public ResultPojo deleteSmsLog(String token, List<String> msgLogIds );
}
