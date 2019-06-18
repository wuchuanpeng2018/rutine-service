package com.onecard.service;

import com.onecard.dto.UserInputDTO;
import com.onecard.model.User;
import org.springframework.beans.BeanUtils;

/**
 * @description: user转化服务
 * 方式4
 * @author: wuchu
 * @date: Created in 2019/6/16 11:58
 */
public class UserInputDTOConvert implements DTOConvert<UserInputDTO, User>{

    //方式4
    @Override
    public User convert(UserInputDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return user;
    }

    @Override
    public User convertToUser(UserInputDTO userInputDTO) {
        return null;
    }
}
