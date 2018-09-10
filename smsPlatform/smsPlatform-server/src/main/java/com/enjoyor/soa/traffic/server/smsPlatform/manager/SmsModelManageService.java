package com.enjoyor.soa.traffic.server.smsPlatform.manager;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsModelDto;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsModelPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.server.SmsModelService;
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
public class SmsModelManageService {
	@Autowired
	SmsModelService service;
	/**
	 * @param token
	 * @param modelCode
	 * @param modelName
	 * @param modelType
	 * @param modelXgr
	 * @return
	 */
	public ResultPojo listSmsModel( String modelCode, String modelName, String modelType, String modelXgr) {
		try {
			Map map = new HashMap();
			map.put("modelCode", modelCode);
			map.put("modelName", modelName);
			map.put("modelType", modelType);
			map.put("modelXgr", modelXgr);
			return ResultHelper.getResult(MapHelper.lstToList(service.querySmsModel(null, map), SmsModelPojo.class, SmsModelDto.class));
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}

	/**
	 * @param token
	 * @param modelCode
	 * @param modelName
	 * @param modelType
	 * @param modelXgr
	 * @param
	 * @return
	 */
	public ResultPojo getPageSmsModel( String modelCode, String modelName, String modelType, String modelXgr, Integer pageSize,Integer currentPage ) {
		try {
			Map map = new HashMap();
			map.put("modelCode", modelCode);
			map.put("modelName", modelName);
			map.put("modelType", modelType);
			map.put("modelXgr", modelXgr);
			Page page = new Page();
			page.setPageSize(pageSize);
			page.setCurrentPage(currentPage);
			page = service.querySmsModel(map, page);
			page.setResult(MapHelper.lstToList(page.getResult(), SmsModelPojo.class, SmsModelDto.class));
			return ResultHelper.getResult(page);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
	/**
	 * 添加
	 *
	 * @param token
	 * @param smsModelDtos
	 * @return
	 */
	public ResultPojo insertSmsModel( List<SmsModelDto> smsModelDtos) {
		try {
			int ret = 0;
			if (smsModelDtos != null && smsModelDtos.size() > 0) {
				for (SmsModelDto dto : smsModelDtos) {
					SmsModelPojo pojo = new SmsModelPojo();
					BeanUtils.copyProperties(dto, pojo);
					pojo.setModelCode(String.valueOf(System.currentTimeMillis()));
					int r = service.insertSmsModel(null, pojo);
					if (r >= 0) ret += r;
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
	 * 添加修改
	 *
	 * @param token
	 * @param smsModelDtos
	 * @return
	 */
	public ResultPojo updataSmsModel( List<SmsModelDto> smsModelDtos) {
		try {
			int ret = 0;
			if (smsModelDtos != null && smsModelDtos.size() > 0) {
				for (SmsModelDto dto : smsModelDtos) {
					SmsModelPojo pojo = new SmsModelPojo();
					BeanUtils.copyProperties(dto, pojo);
					int r = service.updataSmsModel(null, pojo);
					if (r >= 0) ret += r;
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
	 *
	 * @param token
	 * @param
	 * @return
	 */
	public ResultPojo deleteSmsModel( List<String> modelIds) {
		try {
			Map map = new HashMap();
			map.put("modelIds", modelIds);
			int ret = service.delSmsModel(null, map);
			return ResultHelper.getResult(ret);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}
}
