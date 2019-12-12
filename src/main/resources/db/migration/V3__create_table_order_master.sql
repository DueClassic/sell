create table `order_master`(
  `order_id` varchar(32) PRIMARY KEY not null,
  `buyer_name` varchar(32) not null comment '买家名字',
  `buyer_phone` varchar(32) not null comment '买家电话',
  `buyer_address` varchar(128) not null comment '买家地址',
  `buyer_openid` varchar(64) not null comment '买家微信openId',
  `order_amount` decimal(8,2) not null comment '订单总金额',
  `order_status` tinyint(3) not null DEFAULT 0 comment '订单状态，默认0新下单',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
  KEY `idx_buyer_openid` (`buyer_openid`)
)comment '订单表';