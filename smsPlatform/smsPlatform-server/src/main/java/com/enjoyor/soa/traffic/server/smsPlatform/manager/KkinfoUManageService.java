package com.enjoyor.soa.traffic.server.smsPlatform.manager;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.InfoKkDto;
import com.enjoyor.soa.traffic.api.dto.smsPlatform.KkInfoUDto;
import com.enjoyor.soa.traffic.api.dto.smsPlatform.SmsLogDto;
import com.enjoyor.soa.traffic.api.ubms.dto.OffsiteInfoDto;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.KkInfoUPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.server.KkInfoUService;
import com.enjoyor.soa.traffic.core.smsPlatform.server.SmsLogService;
import com.enjoyor.soa.traffic.util.helper.MapHelper;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KkinfoUManageService {

	@Autowired
	KkInfoUService service;

	/**
	 *
	 * @param outSbbh
	 * @param kkmc
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public ResultPojo pageKkInfoU( String outSbbh, String kkmc,Integer pageSize , Integer currentPage){
		try {
			Map map = new HashMap();
			map.put("outSbbh", outSbbh);
			map.put("kkmc", kkmc);
			Page page = new Page();
			page.setPageSize(pageSize);
			page.setCurrentPage(currentPage);
			page = service.queryKkInfoU(map, page);
			List<KkInfoUDto> kkInfoUDtos= MapHelper.lstToList(page.getResult(), KkInfoUPojo.class, KkInfoUDto.class);
			List<InfoKkDto> infoKkDto = new ArrayList<InfoKkDto>();
			if (kkInfoUDtos != null) {
				for (KkInfoUDto pojo : kkInfoUDtos) {
					InfoKkDto dto = new InfoKkDto();
					dto.setId(pojo.getOutSbbh());
					dto.setName(pojo.getKkmc());
					infoKkDto.add(dto);
				}
			}
			page.setResult( infoKkDto);
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
	 * @param outSbbh
	 * @param kkmc
	 * @return
	 */
	public ResultPojo listKkInfoU(String outSbbh, String kkmc){

		try {
			Map map = new HashMap();
			map.put("outSbbh", outSbbh);
			map.put("kkmc", kkmc);
			return ResultHelper.getResult(MapHelper.lstToList(service.queryKkInfoU(map), KkInfoUPojo.class, KkInfoUDto.class));
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}

}
