package com.enjoyor.soa.traffic.server.smsPlatform.commmon;

import com.alibaba.fastjson.JSONObject;
import com.enjoyor.soa.traffic.util.helper.XmlHelper;
import com.enjoyor.soa.traffic.util.pojo.Page;
import com.enjoyor.soa.traffic.util.pojo.PageEasyUI;
import org.dom4j.Element;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author : fzj
 * @date : 2016-5-1 下午2:46:24
 **/
public class CommonUtil {
	/**
	 *
	 * @param data
	 * @return
	 */
    public static String dataToStr (Date data) {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String str=sdf.format(data);
    	return str;
    }
	/**
	 * 返回精确到微秒级的时间，作ID用
	 * @return
	 */
	public static String creatShortID(){
		Date date = new Date();
		return _creatID_df_s.format(date)+String.format("%03d", (System.nanoTime()/1000%1000));
	}
	private static SimpleDateFormat _creatID_df_s=new SimpleDateFormat("HHmmssSSS");

	/**
	 * 返回精确到微秒级的时间，作ID用
	 * @return
	 */
	public static String creatID(){
		Date date = new Date();
		return _creatID_df.format(date)+String.format("%03d", (System.nanoTime()/1000%1000));
	}
	private static SimpleDateFormat _creatID_df=new SimpleDateFormat("yyyyMMddHHmmssSSS");

	private static SimpleDateFormat sdf_date=new SimpleDateFormat("yyyy-MM-dd");

	public static String dateToString(){
		Date date = new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}
	/**
	 * 获取实时的时间
	 * @return 字符串
	 */
	public static String getRealTimeStr(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	public static String getTimeStr(Date date, String formatStr){
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(date);
	}
	public static String dateToStringAll(){
		Date date = new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSS");
		return df.format(date);
	}
	public static String getParameter(HttpServletRequest request, String paramName){
		String str = request.getParameter(paramName) == null ? "" : request.getParameter(paramName);
		return str;
	}

	//String时间转换为long型
	private static SimpleDateFormat date_s2l=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static long dateStrToLong(String time){
		long date_l = 0l;
		try {
			date_l = date_s2l.parse(time).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date_l;
	}


	//获取当前时间0点
	public static String zeroToday(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return format.format(new Date());
	}

	//根据时间字符串获取带当前日期的字符串
	public static String getDateTime(String time){
		Date date = new Date();
		return sdf_date.format(date)+" "+time;
	}

	@SuppressWarnings("rawtypes")
	public static Page getPageInfo(String data) {
		Page page = new Page();
		JSONObject jsonpara = JSONObject.parseObject(data);
		String currentPage = jsonpara.getString("currentPage") != null ? jsonpara.getString("currentPage") : "";
		String pageSize = jsonpara.getString("pageSize") != null ? jsonpara.getString("pageSize") : "";
		String sortExp = jsonpara.getString("sortExp") != null ? jsonpara.getString("sortExp") : "";
		String sortDir = jsonpara.getString("sortDir") != null ? jsonpara.getString("sortDir") : "";
		if (currentPage.compareTo("") == 0) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		if (pageSize.compareTo("") == 0) {
			page.setDefaultPageSize();
		} else {
			page.setPageSize(Integer.valueOf(pageSize));
		}
		if (sortDir.compareTo("") == 0) {
			page.setSortDir(sortDir);
		}
		if (sortExp.compareTo("") == 0) {
			page.setSortExp(sortExp);
		}
		return page;
	}

	@SuppressWarnings("rawtypes")
	public static PageEasyUI getPage(String data) {
		PageEasyUI page = new PageEasyUI();
		JSONObject jsonpara = JSONObject.parseObject(data);
		String currentPage = jsonpara.getString("currentPage") != null ? jsonpara.getString("currentPage") : "";
		String pageSize = jsonpara.getString("pageSize") != null ? jsonpara.getString("pageSize") : "";
		String sortExp = jsonpara.getString("sortExp") != null ? jsonpara.getString("sortExp") : "";
		if (currentPage.compareTo("") == 0) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		if (pageSize.compareTo("") == 0) {
			page.setDefaultPageSize();
		} else {
			page.setPageSize(Integer.valueOf(pageSize));
		}
		if (sortExp.compareTo("") == 0) {
			page.setSortExp(sortExp);
		}
		return page;
	}

	/**
	 * 两个不同类型相同属性的Object拷贝。通过getter、setter方法拷贝属性<br />
	 * 调用所有相对应的source的getter和target的setter：<br />
	 * &nbsp;&nbsp;&nbsp;1.名称相对应(getXXX、setXXX)<br />
	 * &nbsp;&nbsp;&nbsp;2.类型对应(setter只有一个参数，getter无参数，getter返回类型为setter参数类型或其子类)
	 * @param source
	 * @param target
	 * @param copyNull 默认false,source的getter返回值为null,则不调用target对应的setter
	 * @return target
	 */
	public static <T> T copyBean(Object source, T target){
		return copyBean(source,target,false);
	}
	public static <T> T copyBean(Object source, T target,boolean copyNull){
		if(source==null||target==null)return target;
		Class<?> tarCl = target.getClass();
		Class<?> souCl = source.getClass();
		Method[] tarMethod = tarCl.getMethods();
		Method[] souMethod = souCl.getMethods();
		String gs = "get(\\w+)";
        Pattern getM = Pattern.compile(gs);
        String ss = "set(\\w+)";
        Pattern setM = Pattern.compile(ss);
        String rapl = "$1";

		for(Method tarmet:tarMethod){
			if(!tarmet.getDeclaringClass().equals(Object.class) && Pattern.matches(ss, tarmet.getName())){
				String tarparam = setM.matcher(tarmet.getName()).replaceAll(rapl);
				for(Method soumet:souMethod){
					try {
						if(!soumet.getDeclaringClass().equals(Object.class) && Pattern.matches(gs, soumet.getName())){
							String souparam = getM.matcher(soumet.getName()).replaceAll(rapl);
							Class<?>[] par = tarmet.getParameterTypes();
							if( souparam!=null && souparam.equals(tarparam) &&
								soumet.getParameterTypes().length==0 &&
								tarmet.getParameterTypes().length==1 &&
								par[0].isAssignableFrom(soumet.getReturnType())){
								Object sour = soumet.invoke(source);
								if(copyNull || sour!=null) tarmet.invoke(target, sour);
								break;
							}
						}
					} catch (Throwable e) { }
				}
			}
		}
		return target;
	}

	/**
	 * 两个不同类型，相互比较，通过getter方法比较属性。<br/>比较a,b所有相同的getter（getter名称相同、无参数、返回类型相同）的返回值。
	 */
	public static boolean isequal(Object a,Object b){
		if(a==null && b==null) return true;
		if(a!=null && b!=null){
			Class<?> aCl = a.getClass();
			Class<?> bCl = b.getClass();
			Method[] aMethod = aCl.getMethods();
			Method[] bMethod = bCl.getMethods();
			String gs = "get(\\w+)";
	        Pattern getM = Pattern.compile(gs);

			for(Method amet:aMethod){
				if(!amet.getDeclaringClass().equals(Object.class) && Pattern.matches(gs, amet.getName())){
					for(Method bmet:bMethod){
						try{
							if(!bmet.getDeclaringClass().equals(Object.class) && Pattern.matches(gs, bmet.getName())){
								if( amet.getName().equals(bmet.getName())&&
									amet.getReturnType() !=null &&
									amet.getReturnType().equals(bmet.getReturnType())&&
									amet.getParameterTypes().length==0 &&
									bmet.getParameterTypes().length==0){
									Object aret = amet.invoke(a);
									Object bret = bmet.invoke(b);
									if( (aret==null && bret!=null)||
										(aret!=null && !aret.equals(bret))){
										return false;
									}
									break;
								}
							}
						}catch(Throwable e){}
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * 将bean转换为map
	 * @param bean
	 * @return
	 */
	public static Map<String,Object> bean2Map(Object bean){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Class<?> beanType = bean.getClass();
			for(Field field : beanType.getDeclaredFields()){
				String fieldName = field.getName();
				for(Method met:beanType.getMethods()){
					try{
						if(Pattern.matches("get(\\w+)", met.getName()) && met.getParameterTypes().length==0 && met.getDeclaringClass()!=Object.class){
							String param = Pattern.compile("get(\\w+)").matcher(met.getName()).replaceAll("$1");
							if(fieldName.equalsIgnoreCase(param)){
								Object ret = met.invoke(bean);
								if(ret!=null){
									map.put(fieldName, ret);
								}
								break;
							}
						}
					}catch(Throwable ex){}
				}
			}
		}catch(Throwable e){}
		return map;
	}

	private static boolean isSimpleType(Class<?> beanType){
		return beanType.equals(String.class)
			|| beanType.equals(Integer.class)||beanType.equals(int.class)
			|| beanType.equals(Long.class)||beanType.equals(long.class)
			|| beanType.equals(Short.class)||beanType.equals(short.class)
			|| beanType.equals(Byte.class)||beanType.equals(byte.class)
			|| beanType.equals(Double.class)||beanType.equals(double.class)
			|| beanType.equals(Float.class)||beanType.equals(float.class)
			|| beanType.equals(Boolean.class)||beanType.equals(boolean.class)
			|| beanType.equals(Date.class);
	}

	/**
	 * 将map转换为bean
	 * @param map
	 * @param beanType
	 * @return
	 */
	public static <T> T map2Bean(Map<String,Object> map,Class<T> beanType){
		T bean = null;
		try{
			bean = beanType.newInstance();
			for(Field field : beanType.getDeclaredFields()){
				try{
					String fieldName = field.getName();
					if(map.get(fieldName)!=null){
						field.setAccessible(true);
		        		field.set(bean, map.get(fieldName));
					}
				}catch(Throwable ex){}
			}
		}catch(Throwable e){ }
		return bean;
	}

	public static String getRequestIP(HttpServletRequest request) {
		  String ip = request.getHeader("x-forwarded-for");
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		        ip = request.getHeader("PRoxy-Client-IP");
		    }
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		        ip = request.getHeader("WL-Proxy-Client-IP");
		    }
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		        ip = request.getRemoteAddr();
		    }
		    return ip;
	}

	/**
	 * @param xml
	 * @param root
	 * @return
	 */
	public static List<Map<String, String>> getMapListFromXml(String xml,String root) {
		Element root_e = XmlHelper.getRootElement(xml);
		List<Element> list = XmlHelper.getSpecificElement(root_e, root);
		List<Map<String,String>> maplist =  new ArrayList<Map<String, String>>();

			Map<String,String> map = null;
	            for(int i=0;i<list.size();i++){
	            	map = new HashMap<String, String>();

	            	  Iterator<Element> it = list.get(i).elementIterator();

	            	  while(it.hasNext()){
	            		  Element e = it.next();
	            		  map.put(e.getName(),e.getStringValue());
	            	  }
	   	           maplist.add(map);
	            }
	            map = null;

	        return maplist;
	}
	/**
	 * 获取当前时间前/后几天的时间
	 *
	 * @param x
	 * @return
	 */
	public String getdate(int x) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, x);
		date = calendar.getTime();
		// System.out.println(sdf.format(date));
		return sdf.format(date);

	}
	/**
	 * 获取当前时间前/后几天的时间
	 *
	 * @param x
	 * @return
	 */
	public String getdateday(int x) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, x);
		date = calendar.getTime();
		// System.out.println(sdf.format(date));
		return sdf.format(date);

	}

    /**
     * 经度校验
     *
     * @param value
     * @return
     */
    public boolean isLONG(String value) {
        String regExpress = "^(([1-9]\\d?)|(1[0-7]\\d))(\\.\\d{1,6})|180|0(\\.\\d{1,6})?$";
        return Pattern.matches(regExpress, value);
    }

    /**
     * 维度校验
     *
     * @param value
     * @return
     */
    public boolean isLA(String value) {
        String regExpress = "^(([1-8]\\d?)|([1-8]\\d))(\\.\\d{1,6})|90|0(\\.\\d{1,6})?$";
        return Pattern.matches(regExpress, value);
    }
}
