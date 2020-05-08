package xyz.ilovectrl.order.exception;

import xyz.ilovectrl.order.enums.ResultEnum;

/**
 * Created by xiaomi on 2020/2/20.
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code=code;
    }
}
