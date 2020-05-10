package xyz.ilovectrl.order.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ilovectrl.order.dto.OrderDTO;
import xyz.ilovectrl.order.enums.ResultEnum;
import xyz.ilovectrl.order.exception.SellException;
import xyz.ilovectrl.order.service.OrderService;
import xyz.ilovectrl.order.service.BuyerService;

/**
 * Created by xiaomi on 2020/2/21.
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwner(openid, orderId);
        if (orderDTO==null){
            log.error("【取消订单】查不到该订单，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid,String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if (orderDTO==null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致.openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OENER_ERROR);
        }
        return orderDTO;
    }
}
