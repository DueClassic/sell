package xyz.ilovectrl.order.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.ilovectrl.order.dataobject.ProductInfo;
import xyz.ilovectrl.order.dto.CartDTO;

import java.util.List;

/**
 * Created by xiaomi on 2019/12/13.
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
