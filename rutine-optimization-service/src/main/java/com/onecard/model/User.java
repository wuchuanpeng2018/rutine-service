package com.onecard.model;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/16 11:37
 */
@Accessors(chain=true)
@Data
public class User {

    private Long id;
    private String username;
    private Integer age;

}
