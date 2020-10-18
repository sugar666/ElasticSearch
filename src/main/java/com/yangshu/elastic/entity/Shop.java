package com.yangshu.elastic.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Data
public class Shop {
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

    private String name;

    @Column(name = "remark_score")
    private BigDecimal remarkScore;

    @Column(name = "price_per_man")
    private Integer pricePerMan;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @Column(name = "category_id")
    private Integer categoryId;

    private String tags;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    private String address;

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "icon_url")
    private String iconUrl;

}