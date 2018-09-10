package com.enjoyor.soa.traffic.api.service.dubbo.smsPlatform;

import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;

import java.util.List;

public interface DubboHighFreqService {
	/**
	 * 对过车记录进行查询并获取高频车结果
	 * @param licenseType号牌类型  String 可为null，如:02
	 * @param licenseNum 号牌号码  String 可为null，支持模糊查询,如:赣A
	 * @param startDay   分析起始日期   String 不可为null，若null则为当日,格式为20180501
	 * @param endDay分析截止日期   String 不可为null，若null则为当日,格式为20180501
	 * @param pointIds   卡口编号  List<String> 可为null，若null则为全部点位
	 * @param minCounts  次数范围下限   Integer 可为null，若null则为0
	 * @param maxCounts  次数范围上限   Integer 可为null，若null则无上限
	 * @param limit 返回条数  Integer 可为null，若null则无上限
	 * @return 包含高频车实体的集合 : List<HighFreqDto>
	 */
	public ResultPojo listHighFreq(String token,String licenseType, String licenseNum, String startDay, String endDay, List<String> pointIds, Integer minCounts, Integer maxCounts, Integer limit);
	/**
	 * 对过车记录进行查询并获取高频车结果
	 * @param licenseType号牌类型  String 可为null，如:02
	 * @param licenseNum 号牌号码  String 可为null，支持模糊查询,如:赣A
	 * @param startDay   分析起始日期   String 不可为null，若null则为当日,格式为20180501
	 * @param endDay分析截止日期   String 不可为null，若null则为当日,格式为20180501
	 * @param pointIds   卡口编号  List<String> 可为null，若null则为全部点位
	 * @param minCounts  次数范围下限   Integer 可为null，若null则为0
	 * @param maxCounts  次数范围上限   Integer 可为null，若null则无上限
	 * @param limit 返回条数  Integer 可为null，若null则无上限
	 * @return 包含高频车实体的集合 : List<HighFreqDto>
	 */
	public ResultPojo getPageHighFreq(String token,String licenseType, String licenseNum, String startDay, String endDay, List<String> pointIds, Integer minCounts, Integer maxCounts, Integer limit, Page page);

}
