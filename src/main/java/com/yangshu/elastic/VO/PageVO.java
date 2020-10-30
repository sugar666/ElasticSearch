package com.yangshu.elastic.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yangshu on 2020/10/19 15:19
 * Description：
 */
@Data
public class PageVO {

    private Integer page = 1;

    private Integer size = 20;
}
