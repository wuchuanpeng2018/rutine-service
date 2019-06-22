package com.onecard.test2.handler;

import com.onecard.test2.dto.OrderDTO;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/22 17:47
 */
public abstract class AbstractHandler {

    abstract public String handle(OrderDTO orderDTO);

}
