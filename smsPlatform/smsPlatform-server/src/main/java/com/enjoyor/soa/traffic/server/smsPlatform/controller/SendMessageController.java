package com.enjoyor.soa.traffic.server.smsPlatform.controller;

import com.enjoyor.soa.traffic.server.smsPlatform.manager.HighFreqServiceManageService;
import com.enjoyor.soa.traffic.server.smsPlatform.manager.SendManageService;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping({"/SendMessageService"})
@Api("发送短信控制器")
public class SendMessageController {
	@Autowired
	SendManageService service;

	@ResponseBody
	@ApiOperation(value = "发送短信", notes = "查询数据库中符合条件的申请单数据")
	@RequestMapping(method = RequestMethod.POST, value = "/sendMsg")
	public ResultPojo sendMsg(
			@ApiParam(value = "短信内容") @RequestParam String msgText,
			@ApiParam(value = "手机号_车牌 list") @RequestParam List<String> licenseNumsAndTel,
			HttpServletRequest request) {
		return service.sendMsgList(licenseNumsAndTel,msgText);

	}



}
