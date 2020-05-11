package xyz.ilovectrl.order.service;

public interface SecKillService {

    /**
     * 查询特价商品的信息
     * @param productId
     * @return
     */
    String querySecKillProductInfo(String productId);

    /**
     * 模拟多用户秒杀同一商品的活动
     * @param productId
     */
    void orderProductMockDiffUser(String productId);
}
