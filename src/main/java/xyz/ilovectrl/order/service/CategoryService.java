package xyz.ilovectrl.order.service;

import xyz.ilovectrl.order.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by xiaomi on 2019/12/13.
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
