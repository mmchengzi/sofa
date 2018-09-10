package com.enjoyor.soa.traffic.server.smsPlatform.controller;

import com.enjoyor.soa.traffic.server.smsPlatform.manager.HighFreqServiceManageService;
import com.enjoyor.soa.traffic.server.smsPlatform.manager.InfoKkManageService;
import com.enjoyor.soa.traffic.server.smsPlatform.manager.KkinfoUManageService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping({"/InfoKkService"})
@Api("卡口控制器")
public class InfoKkController {
	@Autowired
	InfoKkManageService service;
	@Autowired
	KkinfoUManageService kkinfoUManageService;
	@ResponseBody
	@ApiOperation(value = "获取所有卡口", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/getOffsiteInfo"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo getOffsiteInfo() {
		return service.getOffsiteInfo();

	}

	@ResponseBody
	@ApiOperation(value = "获取所有卡口分页", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/getPageOffsiteInfo"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo getPageOffsiteInfo(
			@RequestParam String offsiteId,
			@RequestParam String offsiteName,
			@RequestParam Integer pageSize,
			@RequestParam Integer currentPage,
			HttpServletRequest request) {
		return kkinfoUManageService.pageKkInfoU( offsiteId, offsiteName, pageSize,  currentPage);
	}
	@ResponseBody
	@ApiOperation(value = "获取设备标号列表", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/listKkInfoU"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo listKkInfoU(
			@RequestParam String outSbbh,
			@RequestParam String kkmc,
			HttpServletRequest request) {
		return kkinfoUManageService.listKkInfoU(  outSbbh,  kkmc);
	}
}
