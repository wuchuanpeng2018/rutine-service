package com.onecard.test1;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.onecard.test1.model.User;
import com.onecard.test1.model.UserLombak;

import java.util.List;
import java.util.Map;


/**
 * @description: 测试类
 * @author: wuchu
 * @date: Created in 2019/6/16 14:11
 */
public class Test {

    public static void main(String[] args) {
//        //异常
//        UserDTOConvert userDTOConvert = new UserDTOConvert();
//        userDTOConvert.doBackward(null);

        //lombak-链式代码
//        UserLombak userLombak = UserLombak.of()
//                .setAge(11)
//                .setUsername("wuchuanpeng");

//        UserLombak user1 = new UserLombak()
//                .setAge(11);

        UserLombak user2 = UserLombak.builder().username("wcp").build();

        List lists = Lists.newArrayList();
        Map<String,String> maps = Maps.newHashMap();
        System.out.println(user2);


    }


}
