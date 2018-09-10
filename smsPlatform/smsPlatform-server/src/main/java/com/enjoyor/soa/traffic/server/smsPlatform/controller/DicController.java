package com.enjoyor.soa.traffic.server.smsPlatform.controller;

import com.enjoyor.soa.traffic.server.smsPlatform.manager.DicManageService;
import com.enjoyor.soa.traffic.server.smsPlatform.manager.InfoKkManageService;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping({"/dicService"})
@Api("字典控制器")
public class DicController {
	@Autowired
	DicManageService service;

	@ResponseBody
	@ApiOperation(value = "返回指定字典编码的所有下级字典", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/getPublicDicByParentCode"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo getPublicDicByParentCode(@RequestParam String parentCode,
											   HttpServletRequest request) {
		return service.getPublicDicByParentCode(parentCode);

	}

}
