package com.enjoyor.soa.traffic.core.smsPlatform.pojo;

import java.util.Date;

public class SmsLogPojo {

    private String msgLogid;

    private String hphm;

    private String cllx;

    private String wfxwCode;

    private String wfxw;

    private Date wfTime;

    private Short msgStatus;

    private Date msgTime;

    private String msgSjhm;

    private String msgPerson;

    private String addr;

    private String msgContent;

    private String memo;

    private Short msgType;

    private String msgSender;


    public String getMsgLogid() {
        return msgLogid;
    }

    public void setMsgLogid(String msgLogid) {
        this.msgLogid = msgLogid == null ? null : msgLogid.trim();
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm == null ? null : hphm.trim();
    }

    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx == null ? null : cllx.trim();
    }

    public String getWfxwCode() {
        return wfxwCode;
    }

    public void setWfxwCode(String wfxwCode) {
        this.wfxwCode = wfxwCode == null ? null : wfxwCode.trim();
    }

    public String getWfxw() {
        return wfxw;
    }

    public void setWfxw(String wfxw) {
        this.wfxw = wfxw == null ? null : wfxw.trim();
    }

    public Date getWfTime() {
        return wfTime;
    }

    public void setWfTime(Date wfTime) {
        this.wfTime = wfTime;
    }

    public Short getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Short msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public String getMsgSjhm() {
        return msgSjhm;
    }

    public void setMsgSjhm(String msgSjhm) {
        this.msgSjhm = msgSjhm == null ? null : msgSjhm.trim();
    }

    public String getMsgPerson() {
        return msgPerson;
    }

    public void setMsgPerson(String msgPerson) {
        this.msgPerson = msgPerson == null ? null : msgPerson.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Short getMsgType() {
        return msgType;
    }

    public void setMsgType(Short msgType) {
        this.msgType = msgType;
    }

    public String getMsgSender() {
        return msgSender;
    }

    public void setMsgSender(String msgSender) {
        this.msgSender = msgSender == null ? null : msgSender.trim();
    }

}