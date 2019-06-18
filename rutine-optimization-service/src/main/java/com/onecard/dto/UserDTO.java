package com.onecard.dto;

import com.onecard.model.User;
import com.onecard.service.Converter;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @description: UserInputDTO 和 UserOutputDTO 都转成 UserDTO
 * 方式6
 * @author: wuchu
 * @date: Created in 2019/6/16 14:05
 */
@Data
public class UserDTO {

    private String username;
    private int age;

    public User convertToUser(){
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        User convert = userDTOConvert.doForward(this);
        return convert;
    }

    public UserDTO convertFor(User user){
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        UserDTO convert = userDTOConvert.doBackward(user);
        return convert;
    }

    private static class UserDTOConvert extends Converter<UserDTO, User> {
        @Override
        public User doForward(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            return user;
        }

        @Override
        public UserDTO doBackward(User user) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            return userDTO;
        }

        @Override
        public User apply(UserDTO userDTO) {
            return null;
        }
    }

}
