
# 数据库设计文档

//### 1.1 用户表设计文档

### t_users：用户表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
userCode|用户Id|bigint|14||N|
account|用户名|varchar|32|Y|NULL|
qq|QQ号|varchar|15|Y|NULL|
email|邮箱|varchar|32|Y|NULL|
website|博客地址|varchar|64|Y|NULL|
dream|王的梦想|varchar|256|Y|NULL|
point|积分|int|11|Y|NULL|
creditPoint|信誉平均分|int|11|Y|NULL|
balance|干粮余额|bigint|12|Y|NULL|
createTime|创建日期|timestamp||Y|NULL|
```

CREATE TABLE `t_users` (
  `userCode` bigint(14) NOT NULL COMMENT 'userCode',
  `account` varchar(32) DEFAULT NULL COMMENT '用户名',
  `qq` varchar(15) DEFAULT NULL COMMENT 'QQ号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `website` varchar(64) DEFAULT NULL COMMENT '博客地址',
  `dream` varchar(256) DEFAULT NULL COMMENT '王的梦想',
  `point` int(11) DEFAULT NULL COMMENT '积分',
  `creditPoint` int(11) DEFAULT NULL COMMENT '信誉平均分',
  `balance` bigint(12) DEFAULT NULL COMMENT '干粮余额',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期' ,
  PRIMARY KEY (`userCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表' ;

```
### 1.2 等级表
```sql
CREATE TABLE `t_grade` (
  `id` int(20) NOT NULL COMMENT 'id',
  `usageType` varchar(20) DEFAULT NULL COMMENT '等级形象',
  `imagepath` varchar(80) DEFAULT NULL COMMENT '图片路径',
  `describe` varchar(64) DEFAULT NULL COMMENT '描述',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='等级层级表';


CREATE TABLE `t_member_level` (
  `id` int(11) DEFAULT NULL,
  `gradeId` int(11) DEFAULT NULL COMMENT '等级',
  `levelName` varchar(32) DEFAULT NULL COMMENT '等级名称',
  `imagePath` varchar(80) DEFAULT NULL,
  `point` int(11) DEFAULT NULL COMMENT '达到等级的积分',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `state` tinyint(1) DEFAULT NULL COMMENT '是否生效'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二级等级表';

```
