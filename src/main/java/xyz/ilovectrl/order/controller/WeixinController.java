package xyz.ilovectrl.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 使用手工方法或取sccess_token
 * Created by xiaomi on 2020/2/28.
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("尽心微信auth方法~~~");
        log.info("code={}",code);

        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxe51aee7325ffd19b&secret=694d35a593eb7cde2d886b1108b5ca3e&code="+code+"&grant_type=authorization_code";

        RestTemplate restTemplate=new RestTemplate();
        String response=restTemplate.getForObject(url,String.class);

        log.info(response);
    }
}
