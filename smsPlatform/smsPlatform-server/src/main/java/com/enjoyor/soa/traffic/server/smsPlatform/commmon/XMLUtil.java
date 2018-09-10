/**
 * Copyright  版权所有 2010-2013
 * 产品名：
 * 包名：com.enjoyor.util
 * 文件名：StringUtil.java
 * 版本信息：
 * 创建日期：2013-12-31-上午11:18:40
 *
 */
package com.enjoyor.soa.traffic.server.smsPlatform.commmon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.enjoyor.soa.traffic.util.helper.LoggerHelper;

/**
 *
 * 类名：StringUtil 类描述： 创建人：liuweiling 修改人：liuweiling 修改时间：2013-12-31 上午11:18:40
 * 修改备注：
 *
 * @version 1.0.0
 *
 */
public class XMLUtil {

	public static Map<String, String> parseXML2IllegalInfo(String xml) {
		Map<String, String> respInfoMap = new HashMap<String, String>();
		Document doc = null;
		try {
			// 将字符串转为XML
			doc = DocumentHelper.parseText(xml);
			// 获取根节点
			Element rootElt = doc.getRootElement();
			// 获取head标签
			Iterator iterRespInfo = rootElt.elementIterator("response_info");
			while (iterRespInfo.hasNext()) {
				Element respInfoEle = (Element) iterRespInfo.next();
				String gwid = respInfoEle.elementTextTrim("gwid");
				String retcode = respInfoEle.elementTextTrim("retcode");
				String retmesg = respInfoEle.elementTextTrim("retmesg");
				if (gwid != null && !"".equals(gwid)) {
					respInfoMap.put("gwid", gwid);
				}
				if (retcode != null && !"".equals(retcode)) {
					LoggerHelper.LOG.error(retcode);
					respInfoMap.put("retcode", retcode);
				}
				if (retmesg != null && !"".equals(retmesg)) {
					respInfoMap.put("retmesg", retmesg);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respInfoMap;
	}
}