package com.bfh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description
 */
public class Content implements Serializable {

    private int cid;
    private int uid;
    private int mid;
    private String content;
    private Date contentTime;


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getContentTime() {
        return contentTime;
    }

    public void setContentTime(Date contentTime) {
        this.contentTime = contentTime;
    }
}
