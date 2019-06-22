package com.onecard.test2.handler;

import com.onecard.test2.annotation.HandlerType;
import com.onecard.test2.dto.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/22 17:50
 */
@HandlerType("GROUP")
@Component
public class GroupHandler extends AbstractHandler{
    @Override
    public String handle(OrderDTO orderDTO) {
        System.out.println("group 订单");
        return null;
    }
}
