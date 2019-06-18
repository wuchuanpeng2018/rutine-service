package com.onecard.annotation;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/17 15:44
 */
public class LoginVo {

    @NotNull
    @IsMobile //自定义的注解
    private String mobile;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄是整数")
    private String age;


    @NotNull
    @Length(min=32)
    private String password;

    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    private String birthday;


    //省略 get set 方法
}
