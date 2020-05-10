package xyz.ilovectrl.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ilovectrl.order.dataobject.SellerInfo;
import xyz.ilovectrl.order.repository.SellerInfoRepository;
import xyz.ilovectrl.order.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
