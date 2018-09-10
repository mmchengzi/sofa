package com.enjoyor.soa.traffic.server.smsPlatform.controller;

import com.enjoyor.soa.traffic.server.smsPlatform.manager.HighFreqServiceManageService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping({"/dubboHighFreqService"})
@Api("高频车控制器")
public class HighFreqController {
	@Autowired
	HighFreqServiceManageService highFreqServiceManageService;

	@ResponseBody
	@ApiOperation(value = "获取高频车list", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/getHighFreq"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo getHighFreq(
			@RequestParam String startDay,
			@RequestParam String endDay,
			@RequestParam List<String> pointIds,
			@RequestParam Integer minCounts,
			@RequestParam Integer limit,
			HttpServletRequest request) {
		return highFreqServiceManageService.getHighFreq(  startDay, endDay, pointIds, minCounts, limit);

	}



}
