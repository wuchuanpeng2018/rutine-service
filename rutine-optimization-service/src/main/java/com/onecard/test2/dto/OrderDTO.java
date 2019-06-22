package com.onecard.test2.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/22 17:35
 */
@Data
public class OrderDTO {

    private String code;

    private BigDecimal price;

    private String type;

}
