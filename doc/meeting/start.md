
# imking 项目启动大会

## 启动大会章程
  * 确定参与人&任务认领
  * 确定分工与合作
  * 约定规范
  * 确定技术选型
  * 确定项目时间节点

## 子系统划分：
* imking主站(www.imking.io)
* imking后管(admin.imking.io)

## 功能模块划分
* imking主站
  + 主站
  + 悬赏任务
  + 黄埔课堂
  + `众包项目[这期不做！]`
  + 我的中心
  + `会员[只考虑个人账号]`
  + 消息中心
  + 开源项目
  + `商务合作[这期不做！]`

* imking后管
  + `统计分析[可以晚点实现]`
  + 用户管理
  + 课程管理
  + 班级管理
  + 消息管理

更多请查阅[imking功能列表](/doc/stories/stage1.md)

## UI原型
[UI原型](/doc/prototype/imking/index.html)

## 开发规范
参考[开发规范](/doc/norm.md)

## 技术选型
后端统一使用：springboot+MyBatis+redis...

前端组件库：
  * imking主站
    + [jquery3](https://jquery.com/)
    + [bootstrap4](http://getbootstrap.com/)
    + [jquery-validation(表单校验)](https://github.com/jquery-validation/jquery-validation)
    + [Summernote(富文本编辑器)](https://github.com/summernote/summernote)
    + [ion.rangeSlider(范围)](https://github.com/IonDen/ion.rangeSlider)
    + [bootstrap-datepicker(日历)](https://github.com/uxsolutions/bootstrap-datepicker)
    + [cropper(图像剪辑&上传)](https://github.com/fengyuanchen/cropper)
    + [switchery(开关)](https://github.com/abpetkov/switchery)
    + [jasny-bootstrap(input mask)](https://github.com/jasny/bootstrap/)

  * imking后管
    + [Angular2](https://angular.io/) + [Typescript](https://www.typescriptlang.org)
    + [bootstrap4](http://getbootstrap.com/)
    + [Summernote](https://github.com/summernote/summernote)
    + [datatable](https://datatables.net/)
    + [ion.rangeSlider](https://github.com/IonDen/ion.rangeSlider)
    + [bootstrap-datepicker](https://github.com/uxsolutions/bootstrap-datepicker)
    + [cropper](https://github.com/fengyuanchen/cropper)
    + [switchery](https://github.com/abpetkov/switchery)
    + [jasny-bootstrap](https://github.com/jasny/bootstrap/)




