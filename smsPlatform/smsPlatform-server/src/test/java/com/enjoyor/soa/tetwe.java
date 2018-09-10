package com.enjoyor.soa;

import com.enjoyor.bigdata.spark.DubboHighFreqService;
import com.enjoyor.bigdata.spark.HighFreqDto;
import com.enjoyor.soa.traffic.util.helper.LoggerHelper;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class tetwe {

	public static void main(String[] args) {
		try {
			//ConsumerHelper2.getMessage(true);
			long start = System.currentTimeMillis();
			System.out.println("***************** start **************");
			LoggerHelper.LOG.info("********************* Spark SQL Server Start ****************");
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[]{"classpath:dubbo-client.xml"});
			context.start();
			LoggerHelper.LOG.info("***** DubboHighFreqService Start Success ********************************");
			DubboHighFreqService service = (DubboHighFreqService) context.getBean("dubboHighFreqService");
			//DubboHighFreqService service = (DubboHighFreqService) SpringContextUtil.getBean("dubboHighFreqService");
			List points = new ArrayList();
			points.add("DJYJBLS01");
			points.add("BDFHZSN01");
			points.add("BDFHNPN01");
			String licenseType = args[0]; //02
			String licenseNum = args[1];  //赣A
			String start_day = args[2];   //20180501
			String end_day = args[3];     //20180530
			String minCounts = args[4];   //30
			String maxCounts = args[5];   //999999
			String limit = args[6];       //100000
			ResultPojo pojo = service.getHighFreq(null, null, start_day, end_day, points, Integer.valueOf(minCounts),
					Integer.valueOf(maxCounts), Integer.valueOf(limit));
			List<HighFreqDto> list = (List<HighFreqDto>) pojo.getResultList();
			long end1 = System.currentTimeMillis();
			System.out.println("****************** end ********************size: " + list.size());
			System.out.println("program execution cache time is:  (sec) --------------" + (end1 - start) / 1000.0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}