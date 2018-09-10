package com.enjoyor.soa.traffic.server.smsPlatform.manager;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsLogDto;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.server.SmsLogService;
import com.enjoyor.soa.traffic.util.helper.MapHelper;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmsLogManageService {

	@Autowired
	SmsLogService service;
	/**
	 *
	 * @param
	 * @param msgLogid
	 * @param hphm
	 * @param cllx
	 * @param msgStatus
	 * @param msgSender
	 * @param msgPerson
	 * @param startTime
	 * @param endTime
	 * @param
	 * @return
	 */
	public ResultPojo getPageSmsLog( String msgLogid, String hphm, String cllx, String msgStatus, String msgSender, String msgPerson, String startTime, String endTime, Integer pageSize , Integer currentPage){
		try {
			Map map = new HashMap();
			map.put("msgLogid", msgLogid);
			map.put("hphm", hphm);
			map.put("cllx", cllx);
			map.put("msgStatus", msgStatus);
			map.put("msgSender", msgSender);
			map.put("msgPerson", msgPerson);
			map.put("startTime", startTime);
			map.put("endTime", endTime);
			Page page = new Page();
			page.setPageSize(pageSize);
			page.setCurrentPage(currentPage);
			page = service.querySmsLog(map, page);
			page.setResult( MapHelper.lstToList(page.getResult(), SmsLogPojo.class, SmsLogDto.class) );
			return ResultHelper.getResult(page);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}

	/**
	 *
	 * @param
	 * @param msgLogid
	 * @param hphm
	 * @param cllx
	 * @param msgStatus
	 * @param msgSender
	 * @param msgPerson
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public ResultPojo listSmsLog(String msgLogid, String hphm, String cllx,String msgStatus,String msgSender,String msgPerson,String startTime, String endTime){

		try {
			Map map = new HashMap();
			map.put("msgLogid", msgLogid);
			map.put("hphm", hphm);
			map.put("cllx", cllx);
			map.put("msgStatus", msgStatus);
			map.put("msgSender", msgSender);
			map.put("msgPerson", msgPerson);
			map.put("startTime", startTime);
			map.put("endTime", endTime);
			return ResultHelper.getResult(MapHelper.lstToList(service.querySmsLog(null,map), SmsLogPojo.class, SmsLogDto.class));
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
	/**
	 *  修改
	 * @param
	 * @param smsLogDtos
	 * @return
	 */
	public ResultPojo updataSmsLog( List<SmsLogDto> smsLogDtos ){
		try {
			int ret = 0;
			if(smsLogDtos!=null&&smsLogDtos.size()>0){
				for(SmsLogDto dto:smsLogDtos){
					SmsLogPojo pojo = new SmsLogPojo();
					BeanUtils.copyProperties(dto, pojo);
					int r = service.updataSmsLog(null,pojo);
					if(r>=0)ret += r;
				}
			}
			return ResultHelper.getResult(ret);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
	/**
	 *  增加
	 * @param token
	 * @param smsLogDtos
	 * @return
	 */
	public ResultPojo insertSmsLog( List<SmsLogDto> smsLogDtos ){
		try {
			int ret = 0;
			if(smsLogDtos!=null&&smsLogDtos.size()>0){
				for(SmsLogDto dto:smsLogDtos){
					SmsLogPojo pojo = new SmsLogPojo();
					BeanUtils.copyProperties(dto, pojo);
					pojo.setMsgLogid(String.valueOf(System.currentTimeMillis()));
					int r = service.insertSmsLog(null,pojo);
					if(r>=0)ret += r;
				}
			}
			return ResultHelper.getResult(ret);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
	/**
	 * 删除
	 * @param token
	 * @param msgLogIds
	 * @return
	 */
	public ResultPojo deleteSmsLog( List<String> msgLogIds ){
		try {
			Map map = new HashMap();
			map.put("msgLogIds", msgLogIds);
			int ret = service.delSmsLog(null,map);
			return ResultHelper.getResult(ret);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
}
