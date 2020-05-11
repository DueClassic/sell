package xyz.ilovectrl.order.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ilovectrl.order.dto.OrderDTO;
import xyz.ilovectrl.order.service.OrderService;
import xyz.ilovectrl.order.service.PushMessageService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO=orderService.findOne("1582224275840162393");
        pushMessageService.orderStatus(orderDTO);
    }
}