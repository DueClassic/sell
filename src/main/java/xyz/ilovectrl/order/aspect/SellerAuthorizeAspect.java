package xyz.ilovectrl.order.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.ilovectrl.order.constant.CookieConstant;
import xyz.ilovectrl.order.constant.RedisConstant;
import xyz.ilovectrl.order.exception.SellAuthorizeException;
import xyz.ilovectrl.order.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("execution(public * xyz.ilovectrl.order.controller.Seller*.*(..))"+
            "&&!execution(public * xyz.ilovectrl.order.controller.SellerUserController.*(..))")
    public void verify(){
    }

//    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //查询cookie
        Cookie cookie= CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie==null){
            log.warn("【登录校验】Cookie中查询不到token");
            throw new SellAuthorizeException();
        }
        //去redis里查询
        String tokenValue= (String) redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)){
            log.warn("【登录校验】Redis中查询不到token");
            throw new SellAuthorizeException();
        }
    }
}
