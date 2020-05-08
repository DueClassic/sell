package xyz.ilovectrl.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import xyz.ilovectrl.order.dataobject.OrderDetail;
import xyz.ilovectrl.order.dto.OrderDTO;
import xyz.ilovectrl.order.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * 将前端表单的json数据转换为OrderDTO对象
 * Created by xiaomi on 2020/2/20.
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();

        OrderDTO orderDTO=new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            orderDetailList=gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，String={}",orderForm.getItems());
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
