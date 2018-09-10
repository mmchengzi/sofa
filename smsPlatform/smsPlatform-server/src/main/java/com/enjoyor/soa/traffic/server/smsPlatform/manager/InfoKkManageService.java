package com.enjoyor.soa.traffic.server.smsPlatform.manager;

import com.enjoyor.soa.traffic.api.dto.smsPlatform.InfoKkDto;
import com.enjoyor.soa.traffic.api.ubms.dto.OffsiteInfoDto;
import com.enjoyor.soa.traffic.server.smsPlatform.invoke.UbmsInfoServiceInvoke;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoKkManageService {
	@Autowired
	UbmsInfoServiceInvoke ubmsInfoServiceInvoke;


	public ResultPojo getOffsiteInfo() {
		try {
			ResultPojo rst = ubmsInfoServiceInvoke.getOffsiteInfo();
			List<InfoKkDto> infoKkDto = new ArrayList<InfoKkDto>();
			if ("0".equals(rst.getappCode())) {
				List<OffsiteInfoDto> lstDto = (List<OffsiteInfoDto>) rst.getResultList();
				if (lstDto != null) {
					for (OffsiteInfoDto pojo : lstDto) {
						InfoKkDto dto = new InfoKkDto();
						dto.setId(pojo.getOffsiteId());
						dto.setName(pojo.getOffsiteName());
						infoKkDto.add(dto);
					}
				}
			}
			return ResultHelper.getResult(infoKkDto);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}
	}

	/**
	 * 返回指定编码的非现场点位分页信息
	 *
	 * @param offsiteId   非现场点位编码
	 * @param offsiteName 非现场点位名称
	 * @return ResultPojo 非现场点位信息
	 */
	public ResultPojo getPageOffsiteInfo(String offsiteId, String offsiteName, Integer pageSize, Integer currentPage) {
		try {
			Page page = new Page();
			page.setPageSize(pageSize);
			page.setCurrentPage(currentPage);
			ResultPojo rst = ubmsInfoServiceInvoke.getPageOffsiteInfo(page, offsiteId, offsiteName, null);
			List<InfoKkDto> infoKkDto = new ArrayList<InfoKkDto>();
			Page pageResult = (Page) rst.getResultList();
			if ("0".equals(rst.getappCode())) {
				List<OffsiteInfoDto> lstDto = pageResult.getResult();
				if (lstDto != null) {
					for (OffsiteInfoDto pojo : lstDto) {
						InfoKkDto dto = new InfoKkDto();
						dto.setId(pojo.getOffsiteId());
						dto.setName(pojo.getOffsiteName());
						infoKkDto.add(dto);
					}
				}
			}
			pageResult.setResult(infoKkDto);
			return ResultHelper.getResult(pageResult);
		} catch (Exception e) {
			e.printStackTrace();
			ResultPojo ret = ResultHelper.getResult(e);
			ret.setResultList(e.getMessage());
			return ret;
		}

	}
}
