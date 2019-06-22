package com.onecard.test2.service.impl;

import com.onecard.test2.dto.OrderDTO;
import com.onecard.test2.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @description: 方式1 接口实现
 *  方式2 策略模式
 * @author: wuchu
 * @date: Created in 2019/6/22 17:37
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Override
    public String handle(OrderDTO orderDTO) {
        if (orderDTO.getType().equals("1")) {

        } else if (orderDTO.getType().equals("2")) {

        } else if (orderDTO.getType().equals("3")) {

        } else {

        }

        return null;
    }
}
