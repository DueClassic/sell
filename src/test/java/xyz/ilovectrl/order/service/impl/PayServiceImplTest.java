package xyz.ilovectrl.order.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ilovectrl.order.dto.OrderDTO;
import xyz.ilovectrl.order.service.OrderService;
import xyz.ilovectrl.order.service.PayService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

//    @Test
    public void create(){
        OrderDTO orderDTO=orderService.findOne("1582137330168256608");
        payService.create(orderDTO);
    }


}