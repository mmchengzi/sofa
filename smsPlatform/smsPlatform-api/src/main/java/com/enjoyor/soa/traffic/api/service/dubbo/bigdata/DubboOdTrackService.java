package com.enjoyor.soa.traffic.api.service.dubbo.bigdata;

import com.enjoyor.soa.traffic.util.pojo.ResultPojo;

public interface DubboOdTrackService {
	/**
	 * 查询时间范围内所有线路的信息
	 * @param beginTime 开始时间(包含),格式为:yyyy-MM-dd
	 * @param endTime 结束时间(包含),格式为:yyyy-MM-dd
	 * @param timeType 时间类型:9全部0周末1工作日
	 * @return List<OdTrackDto>
	 */
	  ResultPojo getOdTrack(String token, String beginTime, String endTime, char timeType);

	/**
	 * 查询时间范围内top20线路的信息
	 * @param beginTime 开始时间(包含),格式为:yyyy-MM-dd
	 * @param endTime 结束时间(包含),格式为:yyyy-MM-dd
	 * @param timeType 时间类型:9全部0周末1工作日
	 * @return List<OdTrackDto>
	 */
	  ResultPojo getOdTrackTop20(String token, String beginTime, String endTime, char timeType);
}
