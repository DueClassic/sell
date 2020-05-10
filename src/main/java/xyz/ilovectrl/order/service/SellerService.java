package xyz.ilovectrl.order.service;

import xyz.ilovectrl.order.dataobject.SellerInfo;

public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
