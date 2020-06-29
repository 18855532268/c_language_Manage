package com.aust.clanguagemanage.entity;

import java.io.Serializable;

/**
 * 成果表，展示研究成果(Profit)实体类
 *
 * @author makejava
 * @since 2020-05-31 01:03:25
 */
public class Profit implements Serializable {
    private static final long serialVersionUID = 503582204521789929L;
    
    private Integer id;
    /**
    * 参与成员ID
    */
    private Integer userId;
    
    private String name;
    
    private String detail;
    /**
    * 成果封面
    */
    private String img;
    /**
    * 课程ID
    */
    private Integer couId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

}