package com.enjoyor.soa.traffic.server.smsPlatform.controller;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsModelDto;
import com.enjoyor.soa.traffic.server.smsPlatform.manager.SmsModelManageService;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@RequestMapping({"/smsModel"})
@Api("短信模版控制器")
public class SmsModelController {

	@Autowired
	SmsModelManageService manageService;

	@ResponseBody
	@ApiOperation(value = "获取短信模版分页", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/getPageSmsModel"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo getPageSmsModel(
			@RequestParam String modelCode,
			@RequestParam String modelName,
			@RequestParam String modelType,
			@RequestParam String modelXgr,
			@RequestParam Integer pageSize,
			@RequestParam Integer currentPage,
			HttpServletRequest request) {
		return manageService.getPageSmsModel( modelCode, modelName, modelType, modelXgr,pageSize,currentPage);
	}
	@ResponseBody
	@ApiOperation(value = "获取短信模版列表", notes = "查询数据库中符合条件的申请单数据")
	@GetMapping(value = {"/listSmsModel"}, produces = {"application/json; charset=UTF-8"})
	public ResultPojo listSmsModel(
			@RequestParam String modelCode,
			@RequestParam String modelName,
			@RequestParam String modelType,
			@RequestParam String modelXgr,
			HttpServletRequest request) {
		return manageService.listSmsModel( modelCode, modelName, modelType, modelXgr);
	}

	/**
	 * 新增
	 *
	 * @param
	 * @param request
	 * @return
	 */
	@PostMapping(value = {"/insertSmsModel"}, consumes = {"application/json; charset=UTF-8"}, produces = {
			"application/json; charset=UTF-8"})
	@ResponseBody
	@ApiOperation("新增")
	public ResultPojo insertSmsModel( @ApiParam(value = "List<SmsModelDto>") @RequestBody List<SmsModelDto> smsModelDtos, HttpServletRequest request) {
		return manageService.insertSmsModel( smsModelDtos);
	}
	/**
	 * 修改
	 *
	 * @param
	 * @param request
	 * @return
	 */
	@PostMapping(value = {"/updataSmsModel"}, consumes = {"application/json; charset=UTF-8"}, produces = {
			"application/json; charset=UTF-8"})
	@ResponseBody
	@ApiOperation("修改")
	public ResultPojo updataSmsModel( @ApiParam(value = "List<SmsModelDto>") @RequestBody List<SmsModelDto> smsModelDtos, HttpServletRequest request) {
		return manageService.updataSmsModel(smsModelDtos);
	}

	/**
	 * 删除
	 *
	 * @param
	 * @param request
	 * @return
	 */
	@DeleteMapping(value = {"/deleteSmsModel"}, produces = {"application/json; charset=UTF-8"})
	@ResponseBody
	@ApiOperation("删除数据")
	public ResultPojo deleteSmsModel( @RequestParam List<String> modelIds, HttpServletRequest request) {
		return manageService.deleteSmsModel( modelIds);
	}

}
