package com.onecard.service;

import com.onecard.dto.UserInputDTO;
import com.onecard.dto.UserOutputDTO;
import com.onecard.model.User;
import org.springframework.beans.BeanUtils;

/**
 * @description: 视图返回转化
 * @author: wuchu
 * @date: Created in 2019/6/16 12:34
 */
public class UserOutputDTOConvert implements DTOConvert<User, UserOutputDTO> {

    //方式5
    @Override
    public UserOutputDTO convert(User user) {
        UserOutputDTO userOutputDTO = new UserOutputDTO();
        BeanUtils.copyProperties(user, userOutputDTO);
        return userOutputDTO;
    }

    @Override
    public UserOutputDTO convertToUser(User user) {
        return null;
    }

}