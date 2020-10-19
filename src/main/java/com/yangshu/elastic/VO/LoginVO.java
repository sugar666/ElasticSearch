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
@ApiModel
public class LoginVO {

    @ApiModelProperty(value = "手机号", name = "telphone", example = "13020093535", required = true)
    @NotBlank(message = "手机号不能为空")
    private String telphone;

    @ApiModelProperty(value = "密码", name = "password", example = "abc")
    @NotBlank(message = "密码不能为空")
    private String password;
}
