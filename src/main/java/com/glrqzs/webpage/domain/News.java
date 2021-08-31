package com.glrqzs.webpage.domain;

import java.io.Serializable;
import java.sql.Date;

public class News implements Serializable {
    private Integer newId;
    private String newTitle;
    private String newAbstract;
    private Date newDate;
    private String newDesc;
    private String newImagePath;

    public News() {
    }

    public News(Integer newId, String newTitle, String newAbstract, Date newDate, String newDesc, String newImagePath) {
        this.newId = newId;
        this.newTitle = newTitle;
        this.newAbstract = newAbstract;
        this.newDate = newDate;
        this.newDesc = newDesc;
        this.newImagePath = newImagePath;
    }

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewAbstract() {
        return newAbstract;
    }

    public void setNewAbstract(String newAbstract) {
        this.newAbstract = newAbstract;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public String getNewDesc() {
        return newDesc;
    }

    public void setNewDesc(String newDesc) {
        this.newDesc = newDesc;
    }

    public String getNewImagePath() {
        return newImagePath;
    }

    public void setNewImagePath(String newImagePath) {
        this.newImagePath = newImagePath;
    }
}
