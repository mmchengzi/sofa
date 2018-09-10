package com.enjoyor.soa.traffic.api.dto.smsPlatform;

import com.alibaba.fastjson.JSONObject;
import com.enjoyor.soa.traffic.util.enums.EnumAppCode;
import com.enjoyor.soa.traffic.util.exception.RepetException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * @author ZN
 * @version 创建时间：2015-1-27 下午2:07:06
 * @类说明
 */
@XmlRootElement
public class ResultPojo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String appCode = "0";
	private String dataBuffer = "成功";
	private Object resultList;

	@XmlElement
	public String getappCode() {
		return appCode;
	}

	public void setappCode(String appCode) {
		this.appCode = appCode;
	}

	@XmlElement
	public Object getResultList() {
		return resultList;
	}

	public void setResultList(Object resultList) {
		this.resultList = resultList;
	}

	@XmlElement
	public String getDataBuffer() {
		return dataBuffer;
	}

	public void setDataBuffer(String dataBuffer) {
		this.dataBuffer = dataBuffer;
	}

	public ResultPojo() {
		this.appCode = "0";
		this.dataBuffer = "成功";
		this.resultList = null;
	}

	public void setValue(Exception ex, EnumAppCode enumApp, Object list,
			String buffer) {
		if (ex != null) {
			// 处理数据库错误。
			// 搜索异常链（通过getCause方法）以确定是否数据库错误
			boolean isDBError = false;
			boolean isRepetEx =false;
			Throwable t = ex;
			for (int i = 0; t != null && i < 100; t = t.getCause(), i++) {
				if (t instanceof SQLException) {
					isDBError = true;
					SQLException sqlEx = (SQLException) t;
					int oraCode = sqlEx.getErrorCode();
					if (oraCode <= 0) {
						for (t = t.getCause(); t != null && oraCode <= 0
								&& i < 100; t = t.getCause(), i++) {
							if (t instanceof SQLException) {
								sqlEx = (SQLException) t;
								oraCode = sqlEx.getErrorCode();
							}
						}
					}
					this.appCode = String.valueOf(EnumAppCode
							.getDbErrorCode(oraCode));
					this.dataBuffer = EnumAppCode.getDbErrorMessage(oraCode);
					if (this.dataBuffer == null)
						this.dataBuffer = "数据库错误: "
								+ sqlEx.getMessage().replaceAll("[\\t\\n\\r]",
										"");

					break;
				} else if (t instanceof RepetException) {
					this.appCode = String.valueOf(EnumAppCode.DEVIALTE_UNIQUE);
					this.dataBuffer = t.getMessage();
					isRepetEx=true;
					break;
				}
				if (t.getCause() == t)
					break;// 与条件i<100一起,防止陷入无谓的循环
			}

			if (!isDBError&&!isRepetEx) {
				if (enumApp != null) {
					this.appCode = String.valueOf(enumApp.getCode());
					this.dataBuffer = enumApp.getMessage();
				} else {
					this.appCode = String.valueOf(EnumAppCode.UNKNOW.getCode());
					this.dataBuffer = EnumAppCode.UNKNOW.getMessage();
				}
			}
		} else {
			if (enumApp != null) {
				this.appCode = String.valueOf(enumApp.getCode());
				this.resultList = list;
				this.dataBuffer = enumApp.getMessage();
			} else {
				if (list != null) {
					this.appCode = String
							.valueOf(EnumAppCode.SUCCESS.getCode());
					this.resultList = list;
					this.dataBuffer = EnumAppCode.SUCCESS.getMessage();
				} else {
					this.resultList = list;
					this.dataBuffer = buffer;
				}
			}
		}
	}

	public JSONObject convertToJson() {
		JSONObject json = new JSONObject();
		json.put("appCode", this.appCode);
		json.put("dataBuffer", this.dataBuffer);
		json.put("resultList", this.resultList);
		return json;
	}

	public static ResultPojo instance(Exception ex, EnumAppCode enumApp,
									  Object obj, String buffer) {
		ResultPojo result = new ResultPojo();
		result.setValue(ex, enumApp, obj, buffer);
		return result;
	}

	public ResultPojo(Exception ex, EnumAppCode enumApp, Object obj,
					  String dataBuffer) {
		this.setValue(ex, enumApp, obj, dataBuffer);
	}

	public ResultPojo(EnumAppCode enumApp, Object obj, String dataBuffer) {
		this.appCode = String.valueOf(enumApp.getCode());
		this.resultList = obj;
		this.dataBuffer = dataBuffer;
	}

	public ResultPojo(EnumAppCode enumApp, Object obj) {
		this.appCode = String.valueOf(enumApp.getCode());
		this.resultList = obj;
		this.dataBuffer = String.valueOf(enumApp.getMessage());
	}

	public ResultPojo(EnumAppCode enumApp) {
		this.appCode = String.valueOf(enumApp.getCode());
		this.dataBuffer = String.valueOf(enumApp.getMessage());
	}

	public ResultPojo(Object obj) {
		this.appCode = String.valueOf(EnumAppCode.SUCCESS.getCode());
		this.resultList = obj;
		this.dataBuffer = String.valueOf(EnumAppCode.SUCCESS.getMessage());
	}
}