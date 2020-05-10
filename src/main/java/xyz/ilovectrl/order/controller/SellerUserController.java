package xyz.ilovectrl.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 卖家用户
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @GetMapping("/login")
    public void login(@RequestParam("openid")String openid){
        //1.openid去和数据库里的数据匹配

        //2.设置token至redis

        //3.设置token至cookie
    }

    @GetMapping("/logout")
    public void logout(){

    }
}
