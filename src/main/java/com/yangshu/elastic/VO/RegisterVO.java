package com.yangshu.elastic.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yangshu on 2020/10/19 11:24
 * Description：
 */

@Data
@ApiModel
public class RegisterVO {

    @ApiModelProperty(value = "手机号", name = "telphone", example = "13020093535", required = true)
    @NotBlank(message = "手机号不能为空")
    private String telphone;

    @ApiModelProperty(value = "密码", name = "password", example = "abc")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "密码", name = "nickName", example = "yang")
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @ApiModelProperty(value = "密码", name = "gender", example = "0")
    @NotNull(message = "性别不能为空")
    private Integer gender;

}
