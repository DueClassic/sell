package xyz.ilovectrl.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ilovectrl.order.dataobject.SellerInfo;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}
