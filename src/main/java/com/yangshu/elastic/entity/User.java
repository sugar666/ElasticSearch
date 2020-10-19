package com.yangshu.elastic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Data
public class User implements Serializable {


    private static final long serialVersionUID = -2011643773058251655L;

    @Id
    private Integer id;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    private String telphone;

    private String password;

    @Column(name = "nick_name")
    private String nickName;

    private String salt;

    private Integer gender;

}