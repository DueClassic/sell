package xyz.ilovectrl.order.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ilovectrl.order.dataobject.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiaomi on 2019/12/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfos=repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("炸鸡");
        productInfo.setProductPrice(new BigDecimal(7.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("味足量大");
        productInfo.setProductIcon("http://zhaji.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(4);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }


}