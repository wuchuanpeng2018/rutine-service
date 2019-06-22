package com.onecard.test2.service.impl;

import com.onecard.test2.context.HandlerContext;
import com.onecard.test2.dto.OrderDTO;
import com.onecard.test2.handler.AbstractHandler;
import com.onecard.test2.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/22 17:40
 */
@Service
public class OrderServiceV2Impl implements IOrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDTO orderDTO) {
        AbstractHandler context = handlerContext.getInstance(orderDTO.getType());
        return context.handle(orderDTO);
    }
}
