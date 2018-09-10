package com.enjoyor.soa;


import com.enjoyor.bigdata.spark.DubboHighFreqService;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class Test1 {
	static ClassPathXmlApplicationContext context;
	static DubboHighFreqService service;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@BeforeClass
	public static void beforeClass() {
		context = new ClassPathXmlApplicationContext("classpath*:/dubbo.xml");
		context.start();
		service = context.getBean(DubboHighFreqService.class);
	}
	/**
	 * 根据起止点位获得推荐路线
	 *
	 * @param startPoint
	 *            起点
	 * @param endPoint
	 *            终点
	 * @return OdPathOptimalDto
	 */
	@Test
	 public  void getHighFreq(){
		List points = new ArrayList();
		points.add("DJYJBLS01");
		points.add("BDFHZSN01");
		points.add("BDFHNPN01");
		String licenseType = "02"; //02
		String licenseNum = "赣A";  //赣A
		String start_day = "20180501";   //20180501
		String end_day = "20180530";     //20180530
		String minCounts = "30";   //30
		String maxCounts = "999999";   //999999
		String limit = "100000";       //100000
		ResultPojo pojo = service.getHighFreq(null, null, start_day, end_day, points, Integer.valueOf(minCounts),
				Integer.valueOf(maxCounts), Integer.valueOf(limit));
		System.out.println("getOdPathOptimal:"+pojo.convertToJson());
	 }


}