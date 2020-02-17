package xyz.ilovectrl.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ilovectrl.order.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by xiaomi on 2019/12/13.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
