package xyz.ilovectrl.order.utils;

import xyz.ilovectrl.order.dto.OrderDTO;

/**
 * 买家
 * Created by xiaomi on 2020/2/21.
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
