package com.enjoyor.soa.traffic.server.smsPlatform.controller;

import com.enjoyor.soa.traffic.server.smsPlatform.manager.HighFreqServiceManageService;
import com.enjoyor.soa.traffic.server.smsPlatform.manager.MvJdcInfoManageService;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping({"/MvJdcInfoService"})
@Api("车架管控制器")
public class MvJdcInfoController {
	@Autowired
	MvJdcInfoManageService manageService;

	@ResponseBody
	@ApiOperation(value = "车架管list", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/getMvJdcInfo"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo queryMvJdcInfo(
			@ApiParam(value = "编号") @RequestParam String xh,
			@ApiParam(value = "号牌种类") 	@RequestParam String hpzl,
			@ApiParam(value = "号牌号码") @RequestParam String hphm,
			@ApiParam(value = "赣A") @RequestParam String fzjg,
			HttpServletRequest request) {
		return manageService.queryMvJdcInfo(xh, hpzl, hphm, fzjg);

	}

}
