package com.enjoyor.soa.traffic.server.smsPlatform.commmon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ch.qos.logback.core.joran.spi.XMLUtil;
import com.enjoyor.soa.traffic.util.enums.EnumAppCode;
import com.enjoyor.soa.traffic.util.helper.LoggerHelper;
import com.enjoyor.soa.traffic.util.helper.ResultHelper;
import com.enjoyor.soa.traffic.util.pojo.ResultPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.enjoyor.soa.traffic.util.helper.TimeHelper;

/**
 *
 * 类名：MsgSendUtil
 * 类描述：
 * 创建人：Administrator
 * 修改人：Administrator
 * 修改时间：2014-8-14 下午04:52:08
 * 修改备注：
 * @version 1.0.0
 *
 */
public class MsgSendUtil
{
	static Log log = LogFactory.getLog(MsgSendUtil.class);
	public static String buildRequestXMLString(String id, String pwd, String serviceid, String phone, String content,String jobType)
	{
        /*String phoneNum = getPhone(jobType);
        if("".equals(phoneNum))
        {
            phoneNum = phone;
        }*/
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
				.append("<svc_init ver=\"2.0.0\">")
				.append("<sms ver=\"2.0.0\">")
				.append("<client>")
				.append("<id>").append(id).append("</id>")
				.append("<pwd>").append(pwd).append("</pwd>")
				.append("<serviceid>").append(serviceid).append("</serviceid>")
				.append("</client>")
				.append("<sms_info>")
				.append("<phone>").append(phone).append("</phone>")
				.append("<content>").append(content).append("</content>")
				.append("</sms_info>")
				.append("</sms>")
				.append(" </svc_init>");
		return sb.toString();
	}


	public static String postXMLSendSMSRequest(String servletUrl , String content) throws Exception
	{
		String result = null;
		BufferedReader br = null;
		OutputStreamWriter out = null;
		HttpURLConnection con = null;
		try
		{
			log.info("短信发送时间："+TimeHelper.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			URL url= new URL(servletUrl);
			con=(HttpURLConnection)url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			out=new OutputStreamWriter(con.getOutputStream(),"UTF-8");
			out.write(content);
			out.flush();
			br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine())!=null)
			{
				sb.append(line);
			}
			result = sb.toString();
			log.info(result);
		}
		catch(IOException e)
		{
			log.info("接口调用失败："+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally
		{
			if(br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if(out != null)
			{
				try
				{
					out.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				con.disconnect();
				con = null;
			}
		}
		return result;
	}

}
