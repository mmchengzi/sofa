package com.enjoyor.bigdata.spark;


import com.enjoyor.soa.traffic.util.pojo.ResultPojo;

import java.util.List;

/**
 * @author Administrator
 */
public interface DubboHighFreqService {

	ResultPojo getHighFreq(String var1, String var2, String var3, String var4, List<String> var5, Integer var6, Integer var7, Integer var8);
}

