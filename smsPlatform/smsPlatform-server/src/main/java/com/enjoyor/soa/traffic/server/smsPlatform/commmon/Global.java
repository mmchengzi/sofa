package com.enjoyor.soa.traffic.server.smsPlatform.commmon;

import com.enjoyor.soa.traffic.util.pojo.ResultPojo;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

/**
 * @author 周宏伟
 * @email zhouhongwei@enjoyor.net
 * @description GlobalVar
 */
public class Global {
	// 时间格式化
	public static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm:ss");

	// 日期格式化
	public static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");

	// 全部格式化
	public static final SimpleDateFormat SDF_FULL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// 时、分
	public static final SimpleDateFormat SDF_HM = new SimpleDateFormat("HH:mm");

	// 随机变量
	public static final Random RANDOM = new Random();
	/**
	 * 判断pojo是否有效且包含数据集合
	 * @param pojo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Boolean PojoIsArray(ResultPojo pojo) {
		if (pojo != null && pojo.getappCode() != null && pojo.getappCode().compareTo("0") == 0 && pojo.getResultList() != null && ((List<T>) pojo.getResultList()).size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
