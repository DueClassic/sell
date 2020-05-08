package xyz.ilovectrl.order.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.ilovectrl.order.dataobject.ProductCategory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiaomi on 2019/12/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory=repository.findById(2).get();
        System.out.println(productCategory.toString());
    }

    @Test
//    @Transactional
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryId(6);
        productCategory.setCategoryName("热销");
        productCategory.setCategoryType(6);
        ProductCategory result = repository.save(productCategory);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list= Arrays.asList(8);
        List<ProductCategory> result=repository.findByCategoryTypeIn(list);
        System.out.println("结果:"+result);
        Assert.assertNotEquals(0,result.size());
    }

}