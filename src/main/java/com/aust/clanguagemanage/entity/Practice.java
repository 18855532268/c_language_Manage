package com.aust.clanguagemanage.entity;

import java.io.Serializable;

/**
 * 实践教学表(Practice)实体类
 *
 * @author makejava
 * @since 2020-05-30 14:39:10
 */
public class Practice implements Serializable {
    private static final long serialVersionUID = -22262479279401759L;
    
    private Integer id;
    /**
    * 实践名称
    */
    private String name;
    /**
    * 实践指导书
    */
    private String book;
    
    private String line;
    /**
    * 实验报告模板
    */
    private String model;


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

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}