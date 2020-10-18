package com.yangshu.elastic.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;


@Data
public class User {
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

    private Integer gender;

}