package com.aust.clanguagemanage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 成果表，展示研究成果(Profit)实体类
 *
 * @author makejava
 * @since 2020-05-28 22:52:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profit")
public class Profit implements Serializable {
    private static final long serialVersionUID = -15990622307223544L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
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
    @Column(name = "cou_id")
    private Integer couId;



}