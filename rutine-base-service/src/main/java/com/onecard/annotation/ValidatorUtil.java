package com.onecard.annotation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/17 16:03
 */
public class ValidatorUtil {
    private static Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    public static <T> Map<String,StringBuffer> validate(T obj){
        Map<String,StringBuffer> errorMap = null;
        Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
        if(set != null && set.size() >0 ){
            errorMap = new HashMap<String,StringBuffer>();
            String property = null;
            for(ConstraintViolation<T> cv : set){
                //这里循环获取错误信息，可以自定义格式
                property = cv.getPropertyPath().toString();
                if(errorMap.get(property) != null){
                    errorMap.get(property).append("," + cv.getMessage());
                }else{
                    StringBuffer sb = new StringBuffer();
                    sb.append(cv.getMessage());
                    errorMap.put(property, sb);
                }
            }
        }
        return errorMap;
    }

    /**
     * 判断是否为浮点数或者整数
     * @param str
     * @return true Or false
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    /**
     * 判断是否为正确的邮件格式
     * @param str
     * @return boolean
     */
    public static boolean isEmail(String str){
        if(isEmpty(str))
            return false;
        return str.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
    }

    /**
     * 判断字符串是否为合法手机号 11位 13 14 15 18开头
     * @param str
     * @return boolean
     */
    public static boolean isMobile(String str){
        if(isEmpty(str))
            return false;
        return str.matches("^(13|14|15|18)\\d{9}$");
    }

    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception ex){
            return false;
        }
    }


    /**
     * 判断字符串是否为非空(包含null与"")
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if(str == null || "".equals(str))
            return false;
        return true;
    }

    /**
     * 判断字符串是否为非空(包含null与"","    ")
     * @param str
     * @return
     */
    public static boolean isNotEmptyIgnoreBlank(String str){
        if(str == null || "".equals(str) || "".equals(str.trim()))
            return false;
        return true;
    }

    /**
     * 判断字符串是否为空(包含null与"")
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str))
            return true;
        return false;
    }

    /**
     * 判断字符串是否为空(包含null与"","    ")
     * @param str
     * @return
     */
    public static boolean isEmptyIgnoreBlank(String str){
        if(str == null || "".equals(str) || "".equals(str.trim()))
            return true;
        return false;
    }


    //禁止实例化
    private ValidatorUtil(){}
}
