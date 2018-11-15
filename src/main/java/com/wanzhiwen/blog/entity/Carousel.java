package com.wanzhiwen.blog.entity;

/**
 * @author wanzhiwen
 * @time 2018/11/15
 */
public class Carousel {
    private int id;
    private int placeId;
    private String location;

    public Carousel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
