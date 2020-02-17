package xyz.ilovectrl.order.VO;

import lombok.Data;

/**
 * http请求返回的最外层
 * Created by xiaomi on 2020/2/18.
 */
@Data
public class ResultVO<T> {

    /*错误码*/
    private Integer code;

    /*提示信息*/
    private String msg;

    /*具体内容*/
    private T data;
}
