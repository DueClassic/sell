CREATE TABLE `product_category`(
  `category_id` INT PRIMARY KEY NOT NULL auto_increment,
  `category_name` VARCHAR(64) not NULL  comment '类目名字',
  `category_type` INT UNIQUE KEY NOT NULL comment '类目编号',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
  UNIQUE KEY `uqe_category_type` (`category_type`)
)comment '类目表';