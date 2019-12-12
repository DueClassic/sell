CREATE TABLE `product_info`(
  `product_id` VARCHAR(32) PRIMARY KEY not null,
  `product_name` VARCHAR(64) not NULL comment '商品名称',
  `procuct_price` decimal(8,2) not null comment '单价',
  `product_stock` int not null comment '库存',
  `product_description` VARCHAR(64) comment '描述',
  `product_icon` VARCHAR(512) comment '小图',
  `category_type` int not null comment '类目编号',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间'
)comment '商品表';