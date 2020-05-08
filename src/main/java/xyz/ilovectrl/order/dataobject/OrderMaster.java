package xyz.ilovectrl.order.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import xyz.ilovectrl.order.enums.OrderStatusEnum;
import xyz.ilovectrl.order.enums.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xiaomi on 2020/2/19.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /*订单id.*/
    @Id
    private String orderId;

    /*买家名字.*/
    private String buyerName;

    /*买家手机号.*/
    private String buyerPhone;

    /*买家地址*/
    private String buyerAddress;

    /*买家微信Openid*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态，默认为新下单*/
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    /*支付状态,默认0为未支付*/
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;
}
