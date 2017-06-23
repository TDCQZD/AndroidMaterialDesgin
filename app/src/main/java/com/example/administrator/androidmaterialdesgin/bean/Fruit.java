package com.example.administrator.androidmaterialdesgin.bean;

/**
 * Created by Administrator on 2017/3/31.
 * 水果实体类
 */

public class Fruit {
    private String name;

    private int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
