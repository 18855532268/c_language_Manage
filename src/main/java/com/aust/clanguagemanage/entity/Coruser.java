package com.aust.clanguagemanage.entity;

import java.io.Serializable;

/**
 * (Coruser)实体类
 *
 * @author makejava
 * @since 2020-05-30 15:06:16
 */
public class Coruser implements Serializable {
    private static final long serialVersionUID = 563731983803666479L;
    
    private Integer id;
    
    private Integer couId;
    
    private Integer userId;
    
    private Integer userRole;
    
    private Integer status;


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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}