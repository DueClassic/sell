package xyz.ilovectrl.order.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import xyz.ilovectrl.order.VO.ResultVO;
import xyz.ilovectrl.order.config.ProjectUrlConfig;
import xyz.ilovectrl.order.exception.ResponseBankException;
import xyz.ilovectrl.order.exception.SellAuthorizeException;
import xyz.ilovectrl.order.exception.SellException;
import xyz.ilovectrl.order.utils.ResultVOUtil;

@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize()
                        .concat("/sell/wechat/qrAuthorize")
                        .concat("?returnUrl=")
                        .concat(projectUrlConfig.getSell())
                        .concat("/sell/seller/login")));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException(){}
}
