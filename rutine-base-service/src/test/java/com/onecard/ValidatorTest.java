package com.onecard;

import com.onecard.annotation.StudentInfo;
import com.onecard.annotation.ValidatorUtil;

import java.util.Map;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/17 16:05
 */
public class ValidatorTest {

    public static void main(String[] args) {
        StudentInfo s = new StudentInfo();
        long startTime = System.currentTimeMillis();
        print(ValidatorUtil.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));

        s.setUserName("小明");
        s.setAge("a10");
        s.setBirthday("2016-9-1");
        startTime = System.currentTimeMillis();
        print(ValidatorUtil.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));



    }

    private static void print(Map<String,StringBuffer> errorMap){
        if(errorMap != null){
            for(Map.Entry<String, StringBuffer> m : errorMap.entrySet()){
                System.out.println(m.getKey() + ":" + m.getValue().toString());
            }
        }
    }

}
