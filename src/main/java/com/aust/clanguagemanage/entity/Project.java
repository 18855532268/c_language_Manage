package com.aust.clanguagemanage.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Project)实体类
 *
 * @author makejava
 * @since 2020-05-30 14:39:10
 */
@Data
public class Project implements Serializable {
    private static final long serialVersionUID = -37283538915478601L;
    
    private Integer id;
    
    private String name;
    
    private String coverimg;
    
    private String details;
    
    private Integer teacherid;
    
    private Integer courseid;


}