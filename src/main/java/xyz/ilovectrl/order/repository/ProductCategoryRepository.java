package xyz.ilovectrl.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ilovectrl.order.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by xiaomi on 2019/12/12.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
