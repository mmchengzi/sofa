package com.enjoyor.soa.traffic.server.smsPlatform.controller;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsLogDto;
import com.enjoyor.soa.traffic.server.smsPlatform.manager.SmsLogManageService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping({"/smsLog"})
@Api("短信日志控制器")
public class SmsLogController {
	@Autowired
	SmsLogManageService smsLogManageService;

	@ResponseBody
	@ApiOperation(value = "获取短信日志分页", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/getPageSmsLog"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo getPageSmsLog(
			@RequestParam String msgLogid,
			@RequestParam String hphm,
			@RequestParam String cllx,
			@RequestParam String msgStatus,
			@RequestParam String msgSender,
			@RequestParam String msgPerson,
			@RequestParam String startTime,
			@RequestParam String endTime,
			@RequestParam Integer pageSize,
			@RequestParam Integer currentPage,
			HttpServletRequest request) {
		return smsLogManageService.getPageSmsLog( msgLogid, hphm, cllx, msgStatus, msgSender, msgPerson, startTime, endTime, pageSize,  currentPage);
	}

	@ResponseBody
	@ApiOperation(value = "获取短信日志列表", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/listSmsLog"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo listSmsLog(
			@RequestParam String msgLogid,
			@RequestParam String hphm,
			@RequestParam String cllx,
			@RequestParam String msgStatus,
			@RequestParam String msgSender,
			@RequestParam String msgPerson,
			@RequestParam String startTime,
			@RequestParam String endTime,
			HttpServletRequest request) {
		return smsLogManageService.listSmsLog( msgLogid, hphm, cllx, msgStatus, msgSender, msgPerson, startTime, endTime);
	}

	/**
	 * 新增
	 *
	 * @param applyZoneDto
	 * @param request
	 * @return
	 */
	@PostMapping(value = {"/insertSmsLog"}, consumes = {"application/json; charset=UTF-8"}, produces = {
			"application/json; charset=UTF-8"})
	@ResponseBody
	@ApiOperation("新增")
	public ResultPojo insertSmsLog( @ApiParam(value = "List<SmsLogDto>") @RequestBody List<SmsLogDto> smsLogDtos, HttpServletRequest request) {
		return smsLogManageService.insertSmsLog( smsLogDtos);
	}


	/**
	 * 修改
	 *
	 * @param applyZoneDto
	 * @param request
	 * @return
	 */
	@PostMapping(value = {"/updataSmsLog"}, consumes = {"application/json; charset=UTF-8"}, produces = {
			"application/json; charset=UTF-8"})
	@ResponseBody
	@ApiOperation("修改")
	public ResultPojo updataSmsLog( @ApiParam(value = "List<SmsLogDto>") @RequestBody List<SmsLogDto> smsLogDtos, HttpServletRequest request) {
		return smsLogManageService.updataSmsLog( smsLogDtos);
	}
	/**
	 * 删除
	 *
	 * @param applyZoneId
	 * @param request
	 * @return
	 */
	@DeleteMapping(value = {"/deleteSmsLog"}, produces = {"application/json; charset=UTF-8"})
	@ResponseBody
	@ApiOperation("删除数据")
		public ResultPojo deleteSmsLog(@RequestParam List<String> msgLogIds, HttpServletRequest request) {
		return smsLogManageService.deleteSmsLog( msgLogIds);
	}

}
