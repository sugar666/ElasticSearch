package com.yangshu.elastic.VO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yangshu on 2020/10/21 14:27
 * Description：
 */
@Data
public class SellerCreateVO {

    @NotBlank(message = "商户名不能为空")
    private String name;
}
