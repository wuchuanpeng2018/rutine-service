package com.onecard.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/17 15:45
 */
/**IsMobile：自定义的注解
String：注解参数类型*/
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    /**默认值_false，用于接收注解上自定义的 required*/
    private boolean required = false;

    /**1、初始化方法：通过该方法我们可以拿到我们的注解*/
    @Override
    public void initialize(IsMobile constraintAnnotation) {

        //constraintAnnotation.required() 接收我们自定义的属性，是否为空
        required = constraintAnnotation.required();
    }

    /**2、逻辑处理*/
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        //2.1、如果允许为空的话，直接返回结果
        if(required) {
            return ValidatorUtil.isMobile(value);
        }else {
            //2.2、不允许为空
            //2.2.1、验证是否为空
            if(StringUtils.isEmpty(value)) {
                return true;
            }else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }

}
