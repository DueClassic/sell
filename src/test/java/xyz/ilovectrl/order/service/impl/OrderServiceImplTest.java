package xyz.ilovectrl.order.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ilovectrl.order.dataobject.OrderDetail;
import xyz.ilovectrl.order.dto.OrderDTO;
import xyz.ilovectrl.order.enums.OrderStatusEnum;
import xyz.ilovectrl.order.enums.PayStatusEnum;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaomi on 2020/2/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID="12341234";

    private final String ORDER_ID="123456";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerAddress("武汉");
        orderDTO.setBuyerPhone("123123123");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList=new ArrayList<>();

        OrderDetail o2=new OrderDetail();
        o2.setProductId("123458");
        o2.setProductQuantity(1);

        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result= orderService.create(orderDTO);

        log.info("【创建订单】result={"+result+"}");
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result=orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result="+result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request=PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void list() {
        PageRequest request=PageRequest.of(4,2);
        Page<OrderDTO> orderDTOS=orderService.findList(request);
//        Assert.assertNotEquals(0,orderDTOS.getTotalElements());
        Assert.assertTrue("查询所有的订单列表",!orderDTOS.isEmpty());
    }

}