CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL COMMENT '用户id',
  `account` varchar(32) DEFAULT NULL COMMENT '用户名',
  `realname` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `qq` varchar(15) DEFAULT NULL COMMENT 'QQ号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `website` varchar(64) DEFAULT NULL COMMENT '博客地址',
  `dream` varchar(256) DEFAULT NULL COMMENT '王的梦想',
  `points` int(11) DEFAULT NULL COMMENT '积分',
  `credit_points` int(11) DEFAULT NULL COMMENT '信誉平均分',
  `balance` bigint(20) DEFAULT NULL COMMENT '干粮余额',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表' ; 
