package com.enjoyor.soa.traffic.core.smsPlatform.pojo;

import java.math.BigDecimal;

public class KkInfoUPojo {
    private String kkid;

    private String outSbbh;

    private String outFxbh;

    private String zoneCode;

    private String kkmc;

    private BigDecimal x;

    private BigDecimal y;

    private String cclj;

    private String sjly;

    private String cclj1;

    private String sblb;

    public String getKkid() {
        return kkid;
    }

    public void setKkid(String kkid) {
        this.kkid = kkid == null ? null : kkid.trim();
    }

    public String getOutSbbh() {
        return outSbbh;
    }

    public void setOutSbbh(String outSbbh) {
        this.outSbbh = outSbbh == null ? null : outSbbh.trim();
    }

    public String getOutFxbh() {
        return outFxbh;
    }

    public void setOutFxbh(String outFxbh) {
        this.outFxbh = outFxbh == null ? null : outFxbh.trim();
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode == null ? null : zoneCode.trim();
    }

    public String getKkmc() {
        return kkmc;
    }

    public void setKkmc(String kkmc) {
        this.kkmc = kkmc;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public String getCclj() {
        return cclj;
    }

    public void setCclj(String cclj) {
        this.cclj = cclj == null ? null : cclj.trim();
    }

    public String getSjly() {
        return sjly;
    }

    public void setSjly(String sjly) {
        this.sjly = sjly == null ? null : sjly.trim();
    }

    public String getCclj1() {
        return cclj1;
    }

    public void setCclj1(String cclj1) {
        this.cclj1 = cclj1 == null ? null : cclj1.trim();
    }

    public String getSblb() {
        return sblb;
    }

    public void setSblb(String sblb) {
        this.sblb = sblb == null ? null : sblb.trim();
    }
}