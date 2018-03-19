# MyKingdom

My Kingdom是Leader us领导的IT人的王国，打造百万IT人专属的知识付费人脉圈，开启自由职业者路线，通过参加原创技术贴、红包悬赏，赏金猎人，创业众包，在线课程，公益分享等活动，积累提升自己的王者口碑值，达到10000积分，并且收获100个推荐后，分封为王。
这是一个全新理念的平台，根据中国国情应运而生，王国里是否能够落下你的脚印呢，就看你的选择了。
报名的同学请准备两三页ppt，写上个人简介，专业技能，可以担任的角色和时间安排，并保证项目启动后不失联，积极配合组织行动，直到项目上线，志愿者可以发邮件申请参与(1005766359@qq.com)

My Kingdom最终会诞生第一批创始之王。。。一起参与的人投票，贡献最大的N个人。。。在My Kingdom的创世纪里 永久登记，并且不会后面降级。。。

## 章程
* [准备工作](#准备工作)
* [快速入门](#快速入门)
* [项目文档](#项目文档)
* [项目规范](#项目规范)
* [涉及知识点](#涉及知识点)
* [技术分享](#技术分享)


## 准备工作
###	1、学习Git使用
Windows用户必须熟悉TortoiseGit的基本用法，包括[如何安装](http://blog.csdn.net/renfufei/article/details/41647937)，[常用基本操作](http://blog.csdn.net/qx1995318/article/details/52006561)，至少对相关的概念有所认知。我们针对本项目制定了简要的操作指南，具体流程参见[Github操作规范文档](/doc/develop-guide/github-develop-guide.md)

###	2、学习前端基础知识(html/css/javascript)
熟悉html标签的使用、熟悉css语法和javascript语法、了解常见web布局、熟悉客户端 服务端相互通信

### 3、学习java开发
我们使用的是java spring-boot技术开发，如不熟悉，可自行百度。我们也提供了相关的课程，有需要的可以联系QQ：1005766359

###	4、了解docker，K8S相关知识
这个属于中级要求，初学者可不必具有该能力，对技术提升有追求可自行学习，当然，官方这方面也是有对应的技能培训，开发者可自愿选择，不作要求。


## 快速入门
###	1、github上获取项目
具体流程参见[Github操作规范文档](/doc/develop-guide/github-develop-guide.md)

###	2、编译生成镜像
mvn clean install docker:build

### 3、配置代码生成: mybatis-generator-lombok-plugin
下载插件代码
```bash
git clone https://github.com/softwareloop/mybatis-generator-lombok-plugin.git
```

编译
```bash
cd mybatis-generator-lombok-plugin
mvn clean install
```

本地安装jar包到maven仓库
```bash
mvn install:install-file -DgroupId=com.softwareloop -DartifactId=mybatis-generator-lombok-plugin -Dversion=1.0-SNAPSHOT -Dpackaging=jar -Dfile=/Users/xqy/projects/mybatis-generator-lombok-plugin/target/mybatis-generator-lombok-plugin-1.0-SNAPSHOT.jar
```

### 4、配置scss自动编译
终端窗口 cd 进入项目文件夹(cd imking-web)，执行下面命令
```bash
mvn com.github.warmuuh:libsass-maven-plugin:0.2.8-libsass_3.4.4:watch
```


## 项目文档
开始前参考[`doc`](/doc/README.md)目录下文档

## 会议纪要
 1. [0318红包需求讲解](/doc/meeting/0318.md)

## 项目规范
###	1、文档规范
 * 所有文档需放到/doc目录下；
   + develop-guide -- 开发指引
   + meeting -- 会议记录
   + prototype -- 原型
   + reference -- 历史文件
   + sql --
   + stories -- 功能列表
 * 文档使用markdown格式维护，避免使用word/excel；
 * 每个专题文档需独立文件夹；
 * 文档的图片等媒体文件，需放在名为“images”的目录下；
 * 文档的编码格式为UTF-8

###	2、格式化
 * 使用eclipse ide开发的童鞋，请使用 doc/templates 目录下提供的格式化文件，详情参见[说明文档](/doc/templates/README.md)
 * 文件统一使用utf-8编码
 * 代码缩进统一1个tab(即4个空格长度)

### 3、开发规范
查看[开发规范](/doc/norm.md)

## 涉及知识点
 * springboot
 * mysql
 * mybatis
 * lombok
 * redis
 * docker
 * kubernetes
 * www.imking.io (jquery + bootstrap + scss)
 * admin.imking.io(angularjs & typescript + bootstrap + scss)


## 技术分享
有不定期的高端技术分享，分享者都是来自各大名企的CTO、架构师、技术经理等。
