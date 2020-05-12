package xyz.ilovectrl.order.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * Created by xiaomi on 2020/2/18.
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 7132460633407522612L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
