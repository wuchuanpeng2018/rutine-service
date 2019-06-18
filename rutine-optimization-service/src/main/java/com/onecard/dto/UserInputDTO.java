package com.onecard.dto;

import com.onecard.model.User;
import com.onecard.service.DTOConvert;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/16 11:35
 */
@Data
public class UserInputDTO {

    private String username;
    private Integer age;


    //方式6
    public User convertToUser(){
        UserInputDTOConvert userInputDTOConvert = new UserInputDTOConvert();
        User convert = userInputDTOConvert.convert(this);
        return convert;
    }

    //方式6
    private static class UserInputDTOConvert implements DTOConvert<UserInputDTO,User> {
        @Override
        public User convert(UserInputDTO userInputDTO) {
            User user = new User();
            BeanUtils.copyProperties(userInputDTO,user);
            return user;
        }

        @Override
        public User convertToUser(UserInputDTO userInputDTO) {
            return null;
        }
    }

}
