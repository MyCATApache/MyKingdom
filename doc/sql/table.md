
# 数据库设计文档

## 1 用户表文档

### 1.1 t_user：用户表
- [x] points字段 积分明细对应表：t_user_point_detail
- [x] balance字段，余额明细对应表：t_user_account_detail
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|用户id|bigint|20|N|
account|用户名|varchar|32|Y|NULL|
realname|真实姓名|varchar|32|Y|NULL|
nickname|昵称|varchar|32|Y|NULL|
qq|QQ号|varchar|15|Y|NULL|
email|邮箱|varchar|32|Y|NULL|
website|博客地址|varchar|64|Y|NULL|
dream|王的梦想|varchar|256|Y|NULL|
points|积分|int|11|Y|NULL|
credit_points|信誉平均分|int|11|Y|NULL|
balance|干粮余额|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

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
id|等级id|bigint|20|N|
section_id|所属段位id|bigint|20|Y|NULL|
name|等级名称|varchar|32|Y|NULL|
image_path|图片|varchar|32|Y|NULL|
points|达到等级所需的积分|varchar|64|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
status|是否生效|tinyint|1|Y|NULL|

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
- [x]任何人都可以投递标书,不管是否有创建团队
- [x]多个投标中，只能一个投标中中标，中标后其他的自动设置为未中标状态,并给所有投标中都发送站内信，提醒投标结果。
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
project_id|项目ID|bigint|20|Y|NULL|
price|报价|bigint|20|Y|NULL|
duration|周期|tinyint|4|Y|NULL|
contact|QQ or email or 电话|varchar|32|Y|NULL|
content|投标说明|varchar|500|Y|NULL|
attachment_id|附件文件|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
verify_time|创建日期|timestamp||Y|NULL|
status|状态 0投标中 1中标 2未中标|TINYINT|2|Y|NULL|

### 1.7 t_user_technology：用户技能表
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
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
- [x]可以搜藏博客，赏金任务，众包/开源项目等 如果是记录起标题内容到title字段
- [x]希望可以做到可以收藏一个地址,用户自己输入网址标题和网址url
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
favor_id|收藏对象Id|bigint|20|Y|NULL|
title|标题|varchar|64|N|
link|收藏地址|varchar|128|Y|NULL|
favor_type|收藏|TINYINT|2|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 1.10 t_user_dream_history：历史梦想表
- [x] 用户设置梦想的时候，修改 t_user表的dream字段,并在此表中保存一条历史记录。包括设置梦想为空白字符。
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
dream|历史梦想|varchar|200|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 1.11 t_user_account_detail：会员帐户记录明细表
- [x]用户任何交易都在此表中保存一条帐户明细记录，包括当前余额
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
amount|交易金额|bigint|20|Y|NULL|
balance|当前余额|bigint|20|Y|NULL|
pay_method|支付方式|TINYINT|2|Y|NULL|
pay_justify|支付证明|varchar|128|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
verify_time|创建日期|timestamp||Y|NULL|
remark|描述|varchar|80|Y|NULL|
manager_id|经办人|bigint|20|Y|NULL|
status|状态：0未审核 1审核状态 2审核未通过|tinyint|2|Y|NULL|
task_id|任务id|BIGINT|20|Y|NULL|


### 1.12 t_user_point_detail：会员积分明细表
- [x]用户积分变动都需要在此表中保存一条明细记录
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
amount|积分|bigint|11|Y|NULL|
balance|余额|bigint|20|Y|NULL|
remark|描述|varchar|80|Y|NULL|
create_time|获得积分时间|timestamp||N|CURRENT_TIMESTAMP|

### 1.13 t_message：用户消息表
- [x]站内信，也可以是系统消息
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|技能id|bigint|20|N|
user_id|用户id|bigint|20|Y|NULL|
message|消息内容|varchar|500|Y|NULL|
sender_id|发送者id|bigint|20|Y|NULL|
is_read|是否已读|TINYINT|2|N|0|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 1.14 t_user_medal：用户徽章表
- [x]徽章是管理员，或者是平台任何的用户给他授予的，需要写明 授予原因，不能为空
- [x]授予徽章后，发送站内信,发送人是发徽章者.
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------|
id|ID|bigint|20|N|
user_id|用户ID|bigint|20|N|
medal_id|徽章ID|bigint|20|N|
remark|备注|varchar|64|N|
state|状态|varchar|64|N|
manager_id|管理员ID,操作人ID|bigint|20|N|

## 2 众包表文档
### 2.1 t_crowd_project：众包项目表
- [x]任何人都可以发起一个众包，或者开源项目.
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
project_id|项目id|bigint|20|N|
user_id|发起人id|bigint|20|Y|NULL|
operator_id|审核者Id 审核主要负责人 (如果需要团队审核则修改)|bigint|20|Y|NULL|
task_type|任务类型：2众包 3开源|tinyint|2|Y|NULL|
title|标题|varchar|200|Y|NULL|
reward|奖金|bigint|20|Y|NULL|
attachment_id|附件|bigint|20|Y|NULL|
content|任务内容|text||Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
update_time|更新日期|timestamp||Y||
status|状态 1、发布 2、平台任何发布|tinyint|2|Y|NULL|


### 2.2 t_crowd_task_attachment：项目任务附件
- [x]项目要求或者一些原型可作为附件上传。一个项目最多上传5个附件。每个不能超过5M
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|项目id|bigint|20|N|
task_id|任务id|bigint|20|Y|NULL|
attachment_id|附件id|bigint|20|Y|NULL|
user_id|评论人Id|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 2.3 t_crowd_project_comment：项目评价表
- [x] 项目结束后的凭借
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|项目id|bigint|20|N|
project_id|项目id|bigint|20|Y|NULL
stars|评分|tinyint|2|Y|NULL|
content|评论内容|varchar|200|Y|NULL|
bid_user_id|中标者用户ID|bigint|20|Y|NULL|
user_id|评论人Id|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

## 3 团队表文档
### 3.1 t_team：团队表
- [x]一个人只能创建一个团队
- [ ]团队分，由成员个人所得分和团队得分得出一个分
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
team_id|团队id|bigint|20|N|
user_id|团队负责人|bigint|20|Y|NULL|
team_name|团队名称（限定16个字）|varchar|32|Y|NULL|
public|是否公开（公开后可团队主页）|tinyint|2|Y|NULL
homepage_url|主页|varchar|32|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 3.2 t_team_project：团队项目表
- [x] 团队项目，可以是团队内任何一个人承接的项目。包括不是Mykingdom承接的项目 
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|团队项目id|bigint|20|N|
team_id|团队id|bigint|20|Y|NULL|
crowd_project_id|项目id|bigint|20|Y|NULL|
user_id|项目创建人|bigint|20|Y|NULL|
project_name|项目名称|varchar|32|Y|NULL|
language|语言(字典表 t_dictionary language)|tinyint|4|Y|NULL|
git_url|git地址|varchar|64|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 3.3 t_team_project_member：团队项目成员表
- [x] 新增成员，输入用户code或者账号，直接查询该用户信息，提供加入项目组
- [x]可设置成员为该项目管理员
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|团队项目id|bigint|20|N|
team_project_id|项目id|bigint|20|Y|NULL|
user_id|成员id|bigint|20|Y|NULL|
user_role|角色，0普通成员 1管理员|tinyint|2|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
status|状态|tinyint|2|Y|NULL|

### 3.4 t_team_project_task ：项目任务表
- [x] 对团队项目的任务分解，数字越小优先级越高。
- [x] 可有管理员指派任务，也可以团队内成员主动领取任务
- [x] 主动领取任务，管理员指派等一切任务操作日志都需要记录在t_team_project_task_history表众
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
task_id|任务id|bigint|20|N|
team_project_id|项目id|bigint|20|Y|NULL|
user_id|任务创建人|bigint|20|Y|NULL|
duty_user_id|责任人|bigint|20|Y|NULL|
title|任务标题|varchar|200|Y|NULL|
content|任务描述|text||Y|NULL|
duration|工期单位天|float(4,2)||Y|NULL|
priority|优先级别：1紧急 2主要 3次要 4不重要 |tinyint|2|Y|NULL|
issue_type|问题类型：1功能 2bug|tinyint|2|Y|NULL|
start_time|开始日期|datetime||Y|NULL|
end_time|结束日期|datetime||Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
status|状态 0待办的，1处理中，2关闭，3已验收|tinyint|2|Y|NULL|

### 3.4 t_team_project_task_history：任务修改操作历史记录
- [x] 记录所有项目任务的操作日志
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|id|bigint|20|N|
task_id|任务id|bigint|20|Y|NULL|
user_id|操作人|bigint|20|Y|NULL|
action|行为：0创建 1更新 2指派 3认领|tinyint|2|Y|NULL|
content|任务标题|varchar|128|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

## 4 博客表文档

### 4.1 t_blog：博客文章表
- [x]用户收藏博客后，在t_user_favor表中插入一条记录 favor_type值为1, favor_num的值加上1
- [x]用户点赞后，在t_blog_like表中插入一条数据,like_num数自动加上1
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|id|bigint|20|N|
title|标题|varchar|50|Y|NULL|
classify|分类|varchar|20|Y|NULL|
content|记录文本|longtext||Y|NULL|
tag|博客标签|varchar|200|Y|NULL|
like_num|点赞总数|int|11|Y|NULL|
favor_num|收藏数|int|11|Y|NULL|
user_id|创建人|bigint|20|Y|NULL|
reviewer_id|审核人|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
status|状态|tinyint|2|Y|NULL|

### 4.2 t_blog_comment：博客评论表
- [x] 其他人员评论博客后，博主可以回复评论者
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|id|bigint|20|N|
blog_id|博客Id|bigint|20|Y|NULL|
user_id|创建人|bigint|20|Y|NULL|
comment|评论内容|varchar|512|Y|NULL|
pid|审核人|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 4.3 t_blog_like：博客点赞表

字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|id|bigint|20|N|
blog_id|博客Id|bigint|20|Y|NULL|
user_id|用户Id|bigint|20|Y|NULL|
pid|审核人|bigint|20|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

## 5 其他表文档

### 5.1 t_attachment：附件表
- [x]所有的附近上传都保存到这个表中，其他需要上传附近的，引用附件id,具体字段名为：attachment_id
字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|id|bigint|20|N|
file_name|附件名称|varchar|128|Y|NULL|
path|附件路径|varchar|128|Y|NULL|
size|文件大小|bigint|20|Y|NULL|
file_type|文件类型|varchar|32|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|

### 5.2 t_dictionary：系统字典

字段名 | 字段描述 | 字段类型 | 长度 | 允许空 | 缺省值 | 备注
------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
id|id|bigint|20|N|
dict_item|字典项目|varchar|50|N|''|
dict_key|附件路径|varchar|50|N|''|
dict_value|字典值|varchar|50|N|''|
remark|描述|varchar|80|Y|NULL|
create_time|创建日期|timestamp||N|CURRENT_TIMESTAMP|
update_time|更新日期|timestamp||Y||