package xyz.ilovectrl.order.enums;

import lombok.Getter;

/**
 * Created by xiaomi on 2020/2/19.
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}