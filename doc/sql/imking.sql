/*
Navicat MySQL Data Transfer

Source Server         : imking
Source Server Version : 50720
Source Host           : 122.112.238.95:3389
Source Database       : imking

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-06 22:37:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attach
-- ----------------------------
DROP TABLE IF EXISTS `attach`;
CREATE TABLE `attach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attach_group` varchar(32) DEFAULT NULL COMMENT '附件组',
  `file_name` varchar(50) DEFAULT NULL COMMENT '附件名',
  `file_type` tinyint(4) DEFAULT NULL COMMENT '附件类型',
  `save_name` varchar(50) DEFAULT NULL COMMENT '保存的附件名称',
  `save_path` varchar(100) DEFAULT NULL COMMENT '保存的附件路径',
  `file_desc` varchar(200) DEFAULT NULL COMMENT '附件说明',
  `size` int(11) DEFAULT NULL COMMENT '附件大小',
  `extension` varchar(10) DEFAULT NULL COMMENT '附件扩展名',
  `create_by` int(11) DEFAULT NULL COMMENT '新增者',
  `create_time` datetime DEFAULT NULL COMMENT '新增时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件表';

-- ----------------------------
-- Table structure for crowdfunding_info
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_info`;
CREATE TABLE `crowdfunding_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '任务表id',
  `amount` mediumint(9) DEFAULT '0' COMMENT '众筹金额',
  `create_by` int(11) DEFAULT NULL COMMENT '加入的用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='众筹情况表';

-- ----------------------------
-- Table structure for imk_role
-- ----------------------------
DROP TABLE IF EXISTS `imk_role`;
CREATE TABLE `imk_role` (
  `id` bigint(20) NOT NULL COMMENT '主键Id',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `role_name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_path` varchar(80) DEFAULT NULL COMMENT '允许角色权限访问的url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for imk_user
-- ----------------------------
DROP TABLE IF EXISTS `imk_user`;
CREATE TABLE `imk_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(128) DEFAULT NULL COMMENT '密码',
  `realname` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `pinyin` varchar(20) DEFAULT NULL COMMENT '姓名拼音',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `qq` varchar(15) DEFAULT NULL COMMENT 'QQ号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `website` varchar(64) DEFAULT NULL COMMENT '博客地址',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像路径',
  `dream` varchar(200) DEFAULT NULL COMMENT '王的梦想',
  `level` tinyint(2) DEFAULT NULL,
  `points` int(11) DEFAULT NULL COMMENT '积分',
  `credit_points` int(11) DEFAULT NULL COMMENT '信誉平均分',
  `balance` int(11) DEFAULT '0' COMMENT '干粮余额',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for imk_user_account_detail
-- ----------------------------
DROP TABLE IF EXISTS `imk_user_account_detail`;
CREATE TABLE `imk_user_account_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `amount` int(11) DEFAULT '0' COMMENT '交易金额，单位分',
  `balance` int(11) DEFAULT '0' COMMENT '当前余额',
  `pay_method` tinyint(2) DEFAULT NULL COMMENT '支付方式',
  `pay_justify` varchar(50) DEFAULT NULL COMMENT '支付证明',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `verify_time` datetime DEFAULT NULL COMMENT '审核日期',
  `remark` varchar(80) DEFAULT NULL COMMENT '备注说明',
  `manager_id` int(11) DEFAULT NULL COMMENT '经办人',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 0、未审核 1、审核状态 2、审核未通过',
  `task_id` int(11) DEFAULT NULL COMMENT '任务ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员帐户记录明细表';

-- ----------------------------
-- Table structure for imk_user_point_detail
-- ----------------------------
DROP TABLE IF EXISTS `imk_user_point_detail`;
CREATE TABLE `imk_user_point_detail` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(20) DEFAULT NULL COMMENT '用户iD',
  `amount` int(11) DEFAULT '0' COMMENT '积分',
  `balance` int(11) DEFAULT '0' COMMENT '余额',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '获得积分时间',
  `remark` varchar(80) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员积分明细表';

-- ----------------------------
-- Table structure for imk_user_role
-- ----------------------------
DROP TABLE IF EXISTS `imk_user_role`;
CREATE TABLE `imk_user_role` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Table structure for op_msg
-- ----------------------------
DROP TABLE IF EXISTS `op_msg`;
CREATE TABLE `op_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) DEFAULT NULL COMMENT '消息类型',
  `from_user_id` int(11) DEFAULT NULL COMMENT '发消息的用户id',
  `to_user_id` int(11) DEFAULT NULL COMMENT '接收消息的用户id',
  `content` varchar(1000) DEFAULT NULL COMMENT '消息内容',
  `is_read` bit(1) DEFAULT NULL COMMENT '阅读标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息表';

-- ----------------------------
-- Table structure for rw_answer
-- ----------------------------
DROP TABLE IF EXISTS `rw_answer`;
CREATE TABLE `rw_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '任务表id',
  `rw_ask_index` tinyint(4) DEFAULT NULL COMMENT '任务接龙序号',
  `content` varchar(1000) DEFAULT NULL COMMENT '回答内容',
  `attach_group` varchar(32) DEFAULT NULL COMMENT '附件组',
  `create_by` int(11) DEFAULT NULL COMMENT '回答者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务答案表';

-- ----------------------------
-- Table structure for rw_apply_detail
-- ----------------------------
DROP TABLE IF EXISTS `rw_apply_detail`;
CREATE TABLE `rw_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '任务id',
  `rw_ask_index` tinyint(4) DEFAULT NULL COMMENT '任务接龙序号',
  `content` varchar(1000) DEFAULT NULL COMMENT '申请内容',
  `create_by` int(11) DEFAULT NULL COMMENT '申请人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='任务招标明细表';

-- ----------------------------
-- Table structure for rw_ask
-- ----------------------------
DROP TABLE IF EXISTS `rw_ask`;
CREATE TABLE `rw_ask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_index` tinyint(4) DEFAULT NULL COMMENT '任务接龙序号',
  `current_answer_user_id` int(11) DEFAULT NULL COMMENT '当前抢到红包者',
  `type` tinyint(4) DEFAULT NULL COMMENT '红包类型',
  `title` varchar(50) DEFAULT NULL COMMENT '红包任务标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '红包任务内容',
  `attach_group` varchar(32) DEFAULT NULL COMMENT '附件组',
  `is_top` bit(1) DEFAULT NULL COMMENT '是否置顶',
  `top_amount` mediumint(9) DEFAULT '0' COMMENT '置顶收费金额',
  `top_expiration_date` datetime DEFAULT NULL COMMENT '置顶截止时间',
  `task_amount` mediumint(9) DEFAULT '0' COMMENT '任务金额',
  `crowdfunding_amount` mediumint(9) DEFAULT '0' COMMENT '当前众筹金额',
  `status` tinyint(4) DEFAULT NULL COMMENT '红包状态',
  `status_change_time` datetime DEFAULT NULL COMMENT '状态变更时间',
  `create_by` int(11) DEFAULT NULL COMMENT '发红包者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8mb4 COMMENT='红包任务表';

-- ----------------------------
-- Table structure for rw_ask_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `rw_ask_evaluate`;
CREATE TABLE `rw_ask_evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '红包任务表id',
  `rw_ask_index` tinyint(4) DEFAULT NULL COMMENT '红包任务表接龙序号',
  `evaluate_user_id` int(11) DEFAULT NULL COMMENT '被评价人id',
  `user_evaluate_dimension_id` int(11) DEFAULT NULL COMMENT '评价维度id',
  `score` tinyint(4) DEFAULT NULL COMMENT '分数',
  `create_by` int(11) DEFAULT NULL COMMENT '评价人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='红包任务用户评价表';

-- ----------------------------
-- Table structure for rw_ask_progress
-- ----------------------------
DROP TABLE IF EXISTS `rw_ask_progress`;
CREATE TABLE `rw_ask_progress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '红包任务id',
  `rw_ask_index` int(11) DEFAULT NULL COMMENT '任务接龙序号',
  `status` tinyint(4) DEFAULT NULL COMMENT '红包状态',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `deadline_time` datetime DEFAULT NULL COMMENT '截止时间',
  `actual_end_time` datetime DEFAULT NULL COMMENT '实际结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='红包任务进度表';

-- ----------------------------
-- Table structure for rw_ask_question
-- ----------------------------
DROP TABLE IF EXISTS `rw_ask_question`;
CREATE TABLE `rw_ask_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '红包任务id',
  `question_content` varchar(1000) DEFAULT NULL COMMENT '问题内容',
  `create_by` int(11) DEFAULT NULL COMMENT '提问者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb4 COMMENT='红包任务问题';

-- ----------------------------
-- Table structure for rw_ask_question_reply
-- ----------------------------
DROP TABLE IF EXISTS `rw_ask_question_reply`;
CREATE TABLE `rw_ask_question_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_question_id` int(11) DEFAULT NULL COMMENT '任务问题id',
  `reply_content` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `create_by` int(11) DEFAULT NULL COMMENT '回复者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='红包任务问题回复';

-- ----------------------------
-- Table structure for rw_ask_tag_relationship
-- ----------------------------
DROP TABLE IF EXISTS `rw_ask_tag_relationship`;
CREATE TABLE `rw_ask_tag_relationship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '红包任务表id',
  `tag_id` int(11) DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='红包标签关系表';

-- ----------------------------
-- Table structure for rw_ask_tags
-- ----------------------------
DROP TABLE IF EXISTS `rw_ask_tags`;
CREATE TABLE `rw_ask_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL COMMENT '标签类型',
  `tag_name` varchar(20) DEFAULT NULL COMMENT '标签名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='红包标签';

-- ----------------------------
-- Table structure for rw_comment
-- ----------------------------
DROP TABLE IF EXISTS `rw_comment`;
CREATE TABLE `rw_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '任务id',
  `rw_ask_index` tinyint(4) DEFAULT NULL COMMENT '任务接龙序号',
  `rw_answer_id` int(11) DEFAULT NULL COMMENT '回答id',
  `type` tinyint(4) DEFAULT NULL COMMENT '评论类型(0:回答评论;1:提问评论;2:普通评论)',
  `content` varchar(200) DEFAULT NULL COMMENT '评论内容',
  `like_num` int(11) DEFAULT NULL COMMENT '点赞数',
  `create_by` int(11) DEFAULT NULL COMMENT '评论者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务评论表';

-- ----------------------------
-- Table structure for rw_pro_act
-- ----------------------------
DROP TABLE IF EXISTS `rw_pro_act`;
CREATE TABLE `rw_pro_act` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '红包任务id',
  `rw_ask_index` int(11) DEFAULT NULL COMMENT '任务接龙序号',
  `type` tinyint(4) DEFAULT NULL COMMENT '行为类型(0:置顶;1:追加红包金额;2:申请延时)',
  `amount` mediumint(9) DEFAULT '0' COMMENT '金额',
  `apply_delay_days` tinyint(4) DEFAULT NULL COMMENT '申请延时天数',
  `create_by` int(11) DEFAULT NULL COMMENT '操作者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务推进行为表';

-- ----------------------------
-- Table structure for rw_reward_confirm_detail
-- ----------------------------
DROP TABLE IF EXISTS `rw_reward_confirm_detail`;
CREATE TABLE `rw_reward_confirm_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '红包任务id',
  `rw_ask_index` int(11) DEFAULT NULL COMMENT '任务接龙序号',
  `from_user_id` int(11) DEFAULT NULL COMMENT '发送的用户id',
  `to_user_id` int(11) DEFAULT NULL COMMENT '接收的用户id',
  `amount` mediumint(9) DEFAULT NULL COMMENT '打赏金额',
  `reason` varchar(200) DEFAULT NULL COMMENT '原因',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务打赏金额确认明细';

-- ----------------------------
-- Table structure for rw_reward_detail
-- ----------------------------
DROP TABLE IF EXISTS `rw_reward_detail`;
CREATE TABLE `rw_reward_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rw_ask_id` int(11) DEFAULT NULL COMMENT '红包任务id',
  `rw_ask_index` int(11) DEFAULT NULL COMMENT '任务接龙序号',
  `reward_user_id` int(11) DEFAULT NULL COMMENT '获得打赏的用户id',
  `amount` mediumint(9) DEFAULT '0' COMMENT '打赏的金额',
  `is_all` bit(1) DEFAULT NULL COMMENT '是否全部打赏',
  `comment` varchar(200) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务打赏明细表';

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for user_evaluate_dimension
-- ----------------------------
DROP TABLE IF EXISTS `user_evaluate_dimension`;
CREATE TABLE `user_evaluate_dimension` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL COMMENT '维度类型',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户评价维度表';
