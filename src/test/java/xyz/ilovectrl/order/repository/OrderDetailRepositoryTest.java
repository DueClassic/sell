package xyz.ilovectrl.order.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ilovectrl.order.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiaomi on 2020/2/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1234");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://奶茶.jpg");
        orderDetail.setProductId("333");
        orderDetail.setProductName("奶茶");
        orderDetail.setProductPrice(new BigDecimal(10.0));
        orderDetail.setProductQuantity(1);

        OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList=repository.findByOrderId("111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

}