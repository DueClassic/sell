package xyz.ilovectrl.order.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by xiaomi on 2019/12/13.
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer Code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.Code = code;
        this.message = message;
    }

}
