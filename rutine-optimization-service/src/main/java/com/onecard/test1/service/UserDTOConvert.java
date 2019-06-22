package com.onecard.test1.service;

import com.onecard.test1.dto.UserDTO;
import com.onecard.test1.model.User;
import org.springframework.beans.BeanUtils;

/**
 * @description: 正向转化和逆向转化
 * 方式6
 * @author: wuchu
 * @date: Created in 2019/6/16 14:01
 */
public class UserDTOConvert extends Converter<UserDTO, User> {
    @Override
    public User doForward(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return user;
    }

//    @Override
//    protected UserDTO doBackward(User user) {
//        UserDTO userInputDTO = new UserDTO();
//        BeanUtils.copyProperties(user,userInputDTO);
//        return userInputDTO;
//    }

    @Override
    public UserDTO doBackward(User user) {
        throw new AssertionError("不支持逆向转化方法!");
    }

    @Override
    public User apply(UserDTO userDTO) {
        return null;
    }
}