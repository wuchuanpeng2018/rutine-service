package com.onecard.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;


/**
 * @description: lombak学习
 * @author: wuchu
 * @date: Created in 2019/6/16 14:51
 */
@Accessors(chain = true)
//@NoArgsConstructor()
//@RequiredArgsConstructor()
@Data
@Builder
public class UserLombak {
    private Long id;

    @NotNull
    private String username;
    private Integer age;

}
