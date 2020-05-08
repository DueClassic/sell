package xyz.ilovectrl.order.converter;

import org.springframework.beans.BeanUtils;
import xyz.ilovectrl.order.dataobject.OrderMaster;
import xyz.ilovectrl.order.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiaomi on 2020/2/20.
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList
                .stream()
                .map(e->convert(e))
                .collect(Collectors.toList());
    }
}
