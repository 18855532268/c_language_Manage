package com.aust.clanguagemanage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (Project)实体类
 *
 * @author makejava
 * @since 2020-05-30 14:39:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project implements Serializable {
    private static final long serialVersionUID = -37283538915478601L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    private String coverimg;
    
    private String details;
    
    private Integer teacherid;
    
    private Integer courseid;


}