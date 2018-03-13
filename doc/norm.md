# 开发规范

## 格式
 * 文件统一使用utf-8编码
 * 代码缩紧1个tab(即4个空格长度)

## 目录结构&模块划分
  * 项目划分为两个子系统(module)
    + imking-web
    + imking-admin
  * 前端按目录划分功能，如courses为黄埔课堂io.imking.courses.xxx
### 目录结构
  * io.imking.xxx.controller 接口控制层
  * io.imking.xxx.service　业务逻辑层
  * io.imking.xxx.domain 模型层
  * io.imking.xxx.repository 持久层，操作数据库．可以是mysql，mongodb等
  

## 数据库
 * 表名和字段使用罗马式，如 t_user,t_user_role
 * domain使用mybatis-generator配合lombok插件自动生成
 * mapper使用annotation方式，手工维护
 * sql避免join语句，含有join的sql需要Leader审批
 *

## 接口约定
  1. 响应体格式：{resCode:Int,resMsg:String,body:Array||Object}
  2. 接口响应与http协议约定一致；resCode复用三种http状态码，如正常200，未登录401，未授权403，其它系统或业务反馈码从700开始
  3. 系统或业务反馈码从700开始；维护一个反馈码列表
