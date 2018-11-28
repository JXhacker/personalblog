package com.wanzhiwen.blog.entity;

import java.util.Date;

/**
 * @author wanzhiwen
 * @time 2018/11/28
 */
public class Timeline {
    private int id;
    private Date time;
    private String event;

    public Timeline() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
