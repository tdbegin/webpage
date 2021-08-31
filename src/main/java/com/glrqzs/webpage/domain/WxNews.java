package com.glrqzs.webpage.domain;

import java.sql.Date;

public class WxNews {
    private Integer wxnewId;
    private String wxnewTitle;
    private String wxnewAbstract;
    private Date wxnewDate;
    private String wxnewImagePath;

    public WxNews() {
    }

    public WxNews(Integer wxnewId, String wxnewTitle, String wxnewAbstract, Date wxnewDate, String wxnewImagePath) {
        this.wxnewId = wxnewId;
        this.wxnewTitle = wxnewTitle;
        this.wxnewAbstract = wxnewAbstract;
        this.wxnewDate = wxnewDate;
        this.wxnewImagePath = wxnewImagePath;
    }

    public Integer getWxnewId() {
        return wxnewId;
    }

    public void setWxnewId(Integer wxnewId) {
        this.wxnewId = wxnewId;
    }

    public String getWxnewTitle() {
        return wxnewTitle;
    }

    public void setWxnewTitle(String wxnewTitle) {
        this.wxnewTitle = wxnewTitle;
    }

    public String getWxnewAbstract() {
        return wxnewAbstract;
    }

    public void setWxnewAbstract(String wxnewAbstract) {
        this.wxnewAbstract = wxnewAbstract;
    }

    public Date getWxnewDate() {
        return wxnewDate;
    }

    public void setWxnewDate(Date wxnewDate) {
        this.wxnewDate = wxnewDate;
    }

    public String getWxnewImagePath() {
        return wxnewImagePath;
    }

    public void setWxnewImagePath(String wxnewImagePath) {
        this.wxnewImagePath = wxnewImagePath;
    }
}
