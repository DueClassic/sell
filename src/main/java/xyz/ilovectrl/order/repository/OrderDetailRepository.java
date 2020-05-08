package xyz.ilovectrl.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ilovectrl.order.dataobject.OrderDetail;

import java.util.List;

/**
 * Created by xiaomi on 2020/2/19.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{

    List<OrderDetail> findByOrderId(String orderId);
}
