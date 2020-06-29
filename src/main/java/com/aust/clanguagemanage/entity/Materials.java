package com.aust.clanguagemanage.entity;

import java.io.Serializable;

/**
 * 教学资料(Materials)实体类
 *
 * @author makejava
 * @since 2020-05-31 15:47:50
 */
public class Materials implements Serializable {
    private static final long serialVersionUID = -62092685574884050L;
    
    private Integer id;
    
    private Integer couId;
    /**
    * 教学大纲文件地址
    */
    private String point;
    /**
    * 授课计划文件地址
    */
    private String plan;
    /**
    * 课程教案文件地址
    */
    private String lesson;
    /**
    * 上传用户ID
    */
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}