package com.onecard.controller;

import com.onecard.dto.UserInputDTO;
import com.onecard.dto.UserOutputDTO;
import com.onecard.model.User;
import com.onecard.service.UserInputDTOConvert;
import com.onecard.service.UserOutputDTOConvert;
import com.onecard.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 控制器
 * @author: wuchu
 * @date: Created in 2019/6/16 11:31
 */
@RequestMapping("/v1/api/user")
@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(UserInputDTO userDTO) {

//        //方式1
//        User user = new User();
//        user.setUsername(userDTO.getUsername());
//        user.setAge(userDTO.getAge());

//        //方式2 通过工具类实现
//        User user = new User();
//        BeanUtils.copyProperties(userDTO,user);

//        //方式3-方式2存在语义问题 提取出转义方法
//        User user = new User();
//        user = convertFor(userDTO);

        //方式4抽象接口定义-其他dto也会有这种转化
        User user = new UserInputDTOConvert().convert(userDTO);

        //方式5：API 中返回值是有些问题的，问题就在于不应该直接返回 User 实体，
        // 因为如果这样的话，就暴露了太多实体相关的信息，这样的返回值是不安全的，
        // 所以我们更应该返回一个 DTO 对象，我们可称它为 UserOutputDTO：
        //UserOutputDTO addOutUser

        return userService.addUser(user);
    }


    @PostMapping
    public UserOutputDTO addOutUser(UserInputDTO userDTO) {
//        //方式5：API 中返回值是有些问题的，问题就在于不应该直接返回 User 实体，
//        // 因为如果这样的话，就暴露了太多实体相关的信息，这样的返回值是不安全的，
//        // 所以我们更应该返回一个 DTO 对象，我们可称它为 UserOutputDTO：
//        User user = new UserInputDTOConvert().convert(userDTO);
//        user = userService.addUser(user);
//        UserOutputDTO userOutputDTO = new UserOutputDTOConvert().convertToUser(user);

        //方式6
        User user = userDTO.convertToUser();
        User saveUserResult = userService.addUser(user);
        UserOutputDTO userOutputDTO = new UserOutputDTOConvert().convertToUser(user);

        return userOutputDTO;
    }

    //方式3 对应方法
    private User convertFor(UserInputDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return user;
    }

}
