package com.yangshu.elastic.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Data
public class Seller {
    @Id
    private Integer id;

    private String name;

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

    @Column(name = "remark_score")
    private BigDecimal remarkScore;

    @Column(name = "disabled_flag")
    private Integer disabledFlag;

}