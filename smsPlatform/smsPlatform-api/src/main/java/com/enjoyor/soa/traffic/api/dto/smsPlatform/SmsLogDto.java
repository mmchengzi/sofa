package com.enjoyor.soa.traffic.api.dto.smsPlatform;

import java.io.Serializable;
import java.util.Date;

public class SmsLogDto implements Serializable {
	private static final long serialVersionUID = 1L;
	//日志编码
	private String msgLogid;
	//号牌号码
	private String hphm;
	//车辆类型
	private String cllx;
	//短信状态：0未发送1：发送成功2：发送失败
	private Short msgStatus;
	//短信发送者
	private String msgSender;
	//发送短信时间
	private Date msgTime;
	//手机号码
	private String msgSjhm;
	//接收人
	private String msgPerson;
	//短信内容
	private String msgContent;
	//备注信息
	private String memo;

	public String getMsgLogid() {
		return msgLogid;
	}

	public void setMsgLogid(String msgLogid) {
		this.msgLogid = msgLogid;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getCllx() {
		return cllx;
	}

	public void setCllx(String cllx) {
		this.cllx = cllx;
	}

	public Short getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(Short msgStatus) {
		this.msgStatus = msgStatus;
	}

	public String getMsgSender() {
		return msgSender;
	}

	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}

	public String getMsgSjhm() {
		return msgSjhm;
	}

	public void setMsgSjhm(String msgSjhm) {
		this.msgSjhm = msgSjhm;
	}

	public String getMsgPerson() {
		return msgPerson;
	}

	public void setMsgPerson(String msgPerson) {
		this.msgPerson = msgPerson;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}
}
