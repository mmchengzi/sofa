package com.enjoyor.soa.traffic.core.smsPlatform.commmon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @ClassName: MyBatisSql
 * @Description: TODO
 * @author wuhao
 * @email
 * @date 2016�?3�?14�? 上午9:47:18
 */
public class MyBatisSql {

	/**
	 * 杩愯鏈?sql
	 */
    private String sql;

    /**
     * 鍙傛�? 鏁扮�?
     */
    private Object[] parameters;

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        if(parameters == null || sql == null){
            return "";
        }
        List<Object> parametersArray = Arrays.asList(parameters);
        List<Object> list = new ArrayList<Object>(parametersArray);
        while(sql.indexOf("?") != -1 && list.size() > 0 && parameters.length > 0){
        	if(list.get(0) instanceof String){
        		sql = sql.replaceFirst("\\?", "'" + list.get(0) + "'");
        	} else if(list.get(0) instanceof java.util.Date){

        		sql = sql.replaceFirst("\\?", list.get(0).toString());
        	} else {
        		sql = sql.replaceFirst("\\?", list.get(0).toString());
        	}

            list.remove(0);
        }
        return sql.replaceAll("(\r?\n(\\s*\r?\n)+)", "\r\n");
    }

}
