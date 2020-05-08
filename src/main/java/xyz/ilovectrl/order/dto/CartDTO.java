package xyz.ilovectrl.order.dto;

import lombok.Data;

/**
 * Created by xiaomi on 2020/2/20.
 */
@Data
public class CartDTO {
    /*商品id*/
    private String productId;
    /*商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
