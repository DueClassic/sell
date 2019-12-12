CREATE TABLE `order_detail`(
  `detail_id` varchar(32) PRIMARY KEY not NULL ,
  `order_id` varchar(32) NOT NULL ,
  `product_id` VARCHAR(32) NOT NULL ,
  `product_name` VARCHAR(64) NOT NULL comment '商品名称',
  `product_price` DECIMAL(8,2) not null comment '商品价格',
  `product_quantity` INT NOT NULL comment '商品数量',
  `prodcut_icon` VARCHAR(512) comment '商品小图',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
  KEY `idx_order_id` (`order_id`)
)comment '订单详情表';