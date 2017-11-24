
# 数据库设计文档

## 1 用户表文档

### 1.1 t_user：用户表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|用户id|bigint|20|N|
account|用户名|varchar|32|Y|NULL|
real_name|真实姓名|varchar|32|Y|NULL|
nickname|昵称|varchar|32|Y|NULL|
qq|QQ号|varchar|15|Y|NULL|
email|邮箱|varchar|32|Y|NULL|
website|博客地址|varchar|64|Y|NULL|
dream|王的梦想|varchar|256|Y|NULL|
points|积分|int|11|Y|NULL|
credit_points|信誉平均分|int|11|Y|NULL|
balance|干粮余额|bigint|20|Y|NULL|
createTime|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 1.2 t_section：段位表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|段位id|bigint|20|N|
name|段位名称|varchar|20|Y|NULL|
describe|描述|varchar|64|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|


### 1.3 t_member_level: 等级表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|等级id|bigint|20|N
section_id|所属段位id|int|11|N|
name|等级名称|varchar|32|Y|NULL|
image_path|图片|varchar|32|Y|NULL|
points|达到等级所需的积分|varchar|64|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
status|是否生效|tinyint|1|Y|NULL

### 1.4 t_role：角色表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|角色id|bigint|20|N|
role_code|角色代码|varchar|20|Y|NULL|
role_name|角色名称|varchar|32|N|''|
role_path|允许角色访问的url|varchar|80|Y|NULL|

### 1.5 t_user_role：用户角色表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|角色id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
role_id|角色id|bigint|32|Y|NULL|

### 1.6 t_user_project：用户投递中标项目表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
task_id|用户id|bigint|20|Y|NULL|
price|报价|bigint|20|Y|NULL|
duration|周期|tinyint|4|Y|NULL|
contact|QQ or email or 电话|varchar|32|Y|NULL|
content|投标说明|varchar|500|Y|NULL|
attachment|附件文件|varchar|200|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
verify_time|创建日期|timestamp||Y|NULL|
status|状态 0投标中 1中标 2未中标|TINYINT|2|Y|NULL|

### 1.7 t_user_technology：用户技能表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|varchar|20|Y|NULL|
technology_name|技术名称|varchar|50|Y|NULL|
use_year|使用年限|TINYINT|3|Y|NULL|
grade|技术等级（0：一般，1：良好，2：熟练，3：精通）|TINYINT|2|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 1.8 t_medal：徽章表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
medal_code|徽章编号|varchar|20|Y|NULL|
medal_name|徽章名称|varchar|80|Y|NULL|
attachment_id|徽章图片|bigint|20|Y|NULL|
remark|描述|varchar|120|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|


### 1.9 t_user_favor：用户收藏表
### 1.10 t_user_dream_history：历史梦想表

### 1.11 t_user_account：会员帐户记录明细表
### 1.12 t_user_points：会员积分明细表

## 2 众包表文档
### 2.1 t_crowd_project：众包项目表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
project_id|项目id|bigint|20|N|
user_id|发起人id|bigint|20|Y|NULL|
operator_id|审核者Id 审核主要负责人 (如果需要团队审核则修改)|bigint|20|Y|NULL|
task_type|任务类型：1赏金任务 2众包 3开源|tinyint|2|Y|NULL|
title|标题|varchar|200|Y|NULL|
reward|奖金|bigint|20|Y|NULL|
attachment_id|附件|bigint|20|Y|NULL|
content|任务内容|text||Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
update_time|创建日期|timestamp||Y||
status|状态|tinyint|4|Y|NULL|

### 2.2 t_crowd_project_comment：项目评价表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|项目id|bigint|20|N|
project_id|项目id|bigint|20|Y|NULL
stars|评分|tinyint|2|Y|NULL|
content|评论内容|varchar|200|Y|NULL|
user_id|评论人Id|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 2.2 t_crowd_task_attachment：项目任务附件
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|项目id|bigint|20|N|
task_id|任务id|bigint|20|Y|NULL
attachment_id|附件id|bigint|20|Y|NULL
user_id|评论人Id|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

## 3 团队表文档

## 4 博客表文档
