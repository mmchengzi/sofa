package com.enjoyor.soa.traffic.api.dto.smsPlatform;

import java.io.Serializable;
import java.util.Date;

public class MvJdcInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String xh;

    private String hpzl;

    private String hphm;

    private String syr;

    private String fzjg;
    private String csysName;
    private String lxfs;

    private Date gxrq;


    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    public String getSyr() {
        return syr;
    }

    public void setSyr(String syr) {
        this.syr = syr;
    }

    public String getFzjg() {
        return fzjg;
    }

    public void setFzjg(String fzjg) {
        this.fzjg = fzjg;
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }

    public Date getGxrq() {
        return gxrq;
    }

    public void setGxrq(Date gxrq) {
        this.gxrq = gxrq;
    }

    public String getCsysName() {
        return csysName;
    }

    public void setCsysName(String csysName) {
        this.csysName = csysName;
    }
}