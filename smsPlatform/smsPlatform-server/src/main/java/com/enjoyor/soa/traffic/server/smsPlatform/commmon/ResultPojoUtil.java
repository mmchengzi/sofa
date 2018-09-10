package com.enjoyor.soa.traffic.server.smsPlatform.commmon;

import com.enjoyor.soa.traffic.util.pojo.ResultPojo;

import java.util.List;

/**
 * @author 周宏伟
 * @date 2017年4月25日
 * @email zhouhongwei@enjoyor.net
 * @description ResultPojo帮助类
 */
public class ResultPojoUtil {
	/**
	 * 判断pojo是否有效且包含数据集合
	 * @param <T>
	 * @param pojo 结果对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isList(ResultPojo pojo) {
		if (pojo != null && pojo.getappCode() != null && pojo.getappCode().compareTo("0") == 0 && pojo.getResultList() != null && ((List<T>) pojo.getResultList()).size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
