package com.aust.clanguagemanage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 教学资料(Materials)实体类
 *
 * @author makejava
 * @since 2020-05-28 22:52:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "materials")
public class Materials implements Serializable {
    private static final long serialVersionUID = -14978948480892689L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cou_id")
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
    @Column(name = "user_id")
    private Integer userId;
}