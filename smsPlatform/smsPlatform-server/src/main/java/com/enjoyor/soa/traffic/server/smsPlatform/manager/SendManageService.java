package com.enjoyor.soa.traffic.server.smsPlatform.manager;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsLogDto;
import com.enjoyor.soa.traffic.server.smsPlatform.commmon.MsgSendUtil;
import com.enjoyor.soa.traffic.server.smsPlatform.commmon.XMLUtil;
import com.enjoyor.soa.traffic.util.enums.EnumAppCode;
import com.enjoyor.soa.traffic.util.helper.LoggerHelper;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SendManageService {
	@Autowired
	SmsLogManageService smsLogManageService;

	@Value("${InitConfig.ID}")
	private String ID;
	@Value("${InitConfig.PWD}")
	private String PWD;
	@Value("${InitConfig.SERVICEID}")
	private String SERVICEID;
	@Value("${InitConfig.HTTPURL}")
	private String HTTPURL;

	public ResultPojo sendMsg(String phoneNum, String msgText) {

		LoggerHelper.LOG.info("***********调用短信接口成功****************");
		if (phoneNum != null && !"".equals(phoneNum) && msgText != null
				&& !"".equals(msgText)) {
			String reqXML = MsgSendUtil.buildRequestXMLString(ID, PWD, SERVICEID,
					phoneNum, msgText, "1");
			LoggerHelper.LOG.error("短信内容：" + reqXML);
			String result = "";
			try {
				result = MsgSendUtil.postXMLSendSMSRequest(HTTPURL, reqXML);
				if (result != null && !"".equals(result)) {
					Map<String, String> resultMap = new HashMap<String, String>();
					resultMap = XMLUtil.parseXML2IllegalInfo(result);
					if("00".equals(resultMap.get("retcode"))) {
						return ResultHelper.getResult("1");
					}
				}
			} catch (Exception e) {
				return ResultHelper.getResult(e);
			}
		}
		return ResultHelper.getResult(EnumAppCode.PARAM_ERR);
	}

	public ResultPojo sendMsgList(List<String> licenseNumsAndTel, String msgText) {
		int succeedNum = 0;
		int failNum = 0;
		List< SmsLogDto > smsLogDtos=new ArrayList<>();
		for (String phoneAndNum : licenseNumsAndTel) {
			if(phoneAndNum.indexOf("_")==-1){
				continue;
			}
			String[] arr = phoneAndNum.split("_");
			ResultPojo pojo = sendMsg(arr[0], msgText);
			Short status=0;
			if ("1".equals(pojo.getResultList())) {
				status=1;
				succeedNum++;

			} else {
				status=2;
				failNum++;
			}
			long id=System.currentTimeMillis();
			SmsLogDto dto=new SmsLogDto();
			dto.setHphm(arr[1]);
			dto.setMsgContent(msgText);
			dto.setMsgLogid(String.valueOf(id));
			dto.setMsgPerson(arr[0]);
			dto.setMsgStatus(status);
			dto.setMsgSjhm("0");
			dto.setCllx("0");
			dto.setMsgSender("0");
			dto.setMemo("0");
			smsLogDtos.add(dto);
		}
		smsLogManageService.insertSmsLog( smsLogDtos);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("succeedNum", succeedNum);
		map.put("failNum", failNum);
		JSONObject mapObject= JSONObject.fromObject(map);
		return ResultHelper.getResult(mapObject);
	}

}
