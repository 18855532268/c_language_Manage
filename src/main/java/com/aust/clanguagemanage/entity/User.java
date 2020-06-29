package com.aust.clanguagemanage.entity;

import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2020-05-31 00:40:48
 */
public class User implements Serializable {
    private static final long serialVersionUID = 430584249846756422L;
    
    private Integer id;
    /**
    * 用户真实姓名
    */
    private String name;
    /**
    * 英文名
    */
    private String englishName;
    
    private String img;
    /**
    * 性别
    */
    private String gander;
    /**
    * 联系方式
    */
    private String tel;
    
    private String email;
    /**
    * 注册时填写的账号
    */
    private String account;
    
    private String password;
    /**
    * 角色1-普通学生，2-老师，3-管理员，4-实验员，5-负责人，默认为1
    */
    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}