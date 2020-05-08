package xyz.ilovectrl.order.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.ilovectrl.order.dataobject.OrderMaster;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by xiaomi on 2020/2/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID="123aabbcc";

    @Test
    public void saveTest() {
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("李四");
        orderMaster.setBuyerPhone("123412341234");
        orderMaster.setBuyerAddress("北京");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(100.0));

        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional(readOnly = true)  // 只读事务
    public void findByBuyerOpenid() throws Exception {
        Pageable request=PageRequest.of(0,1);

        Page<OrderMaster> result=repository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,result.getTotalElements());
        //        System.out.println(result.getTotalElements());

    }

}