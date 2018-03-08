-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 122.112.238.95    Database: imking
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED='';

--
-- Table structure for table `t_attachment`
--

DROP TABLE IF EXISTS `t_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_attachment` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `file_name` varchar(128) DEFAULT NULL COMMENT '附件名称',
  `path` varchar(64) DEFAULT NULL COMMENT '附件路径',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `file_type` varchar(32) DEFAULT NULL COMMENT '文件类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_attachment`
--

LOCK TABLES `t_attachment` WRITE;
/*!40000 ALTER TABLE `t_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog`
--

DROP TABLE IF EXISTS `t_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `classify` varchar(20) DEFAULT NULL COMMENT '分类',
  `content` longtext COMMENT '记录文本',
  `tag` varchar(200) DEFAULT NULL COMMENT '博客标签',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `like_num` int(11) DEFAULT NULL COMMENT '点赞总数',
  `favor_num` int(11) DEFAULT NULL COMMENT '收藏数',
  `user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `reviewer_id` bigint(20) DEFAULT NULL COMMENT '审核人',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客文章';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog`
--

LOCK TABLES `t_blog` WRITE;
/*!40000 ALTER TABLE `t_blog` DISABLE KEYS */;
INSERT INTO `t_blog` VALUES (1,'Java入门','1','/////////Java\r\n','1','2017-11-21 08:50:27',0,0,14,1,1);
/*!40000 ALTER TABLE `t_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_comment`
--

DROP TABLE IF EXISTS `t_blog_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_blog_comment` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `blog_id` bigint(20) DEFAULT NULL COMMENT '博客Id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `comment` varchar(512) DEFAULT NULL COMMENT '评论内容',
  `pid` bigint(20) DEFAULT NULL COMMENT '回复Pid',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_comment`
--

LOCK TABLES `t_blog_comment` WRITE;
/*!40000 ALTER TABLE `t_blog_comment` DISABLE KEYS */;
INSERT INTO `t_blog_comment` VALUES (1,1,1,'这些的啥玩意',0,'2017-11-22 03:53:13'),(2,1,1,'发着玩',1,'2017-11-22 03:53:27');
/*!40000 ALTER TABLE `t_blog_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_like`
--

DROP TABLE IF EXISTS `t_blog_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_blog_like` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户',
  `blog_id` bigint(20) DEFAULT NULL COMMENT '点赞博客',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客点赞';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_like`
--

LOCK TABLES `t_blog_like` WRITE;
/*!40000 ALTER TABLE `t_blog_like` DISABLE KEYS */;
INSERT INTO `t_blog_like` VALUES (1,1,1,'2017-11-22 03:53:37');
/*!40000 ALTER TABLE `t_blog_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_crowd_project`
--

DROP TABLE IF EXISTS `t_crowd_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_crowd_project` (
  `project_id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '发起人ID',
  `operator_id` bigint(20) DEFAULT NULL COMMENT '审核者Id 审核主要负责人 (如果需要团队审核则修改)',
  `task_type` tinyint(2) DEFAULT NULL COMMENT '任务类型 1众包 2开源',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `reward` bigint(20) DEFAULT NULL COMMENT '奖金',
  `attachment_id` bigint(20) DEFAULT NULL COMMENT '附件',
  `content` text COMMENT '任务内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_crowd_project`
--

LOCK TABLES `t_crowd_project` WRITE;
/*!40000 ALTER TABLE `t_crowd_project` DISABLE KEYS */;
INSERT INTO `t_crowd_project` VALUES (1,1,1,1,'Mycat如何设置字符集',10,0,'新学Mycat，不知道如何设置字符集，希望高手帮我能告知我代码','2017-11-21 06:57:06','2017-11-21 14:59:18',1),(2,1,1,2,'Mykingdom',10,0,'赏金任务\r\n任何人都可以发起赏金任务，赏金任务可自己给出酬劳（包括无酬劳），任务的主题，任务的截止期限，任务相关的附件。\r\n任何人可以“认领”还未完成的赏金任务，多人可以同时认领一个任务，如果认领后，对任务的完成没有任何贡献，则认领人的信用分可能减少1-N分，由任务发起人申请，社区审核，如果对任务完成有帮助，则信用度，奉献精神加分（赏金越少，奉献精神加分越多），考虑任务发起人最后针对赏金任务的完成情况，对参与者的技术分、创新力、奉献精神、合作能力、沟通力等几个方面打分，平台审核公平度。\r\n赏金任务的状态：待解决，完美解决，部分解决，以放弃\r\n赏金发起人可以继续增加赏金，以寻求问题的快速解决，参与者也可以“建议”发起人增加赏金到某个合适的值，其他人可以认可这个建议，比如 赏金任务上看到：“当前2人支持赏金提升到30元”,“3人希望赏金提升到50元”，即满足这种体面的讨价还价的心态。\r\n如果一个任务是多个人参与完成的，则任务发起方需要确定赏金的分配比例，同时给出建议的评分调整，平台核实公平性。\r\n成功解决的赏金任务，考虑付费方式查看答案，平台方来确定是否此问题有公共价值，查看答案的所需费用原则上是赏金的1/10，查看答案的人可以对此问题进行评价，补充完善，以及投诉，如果补充答案，则需要通知原先认领此任务的相关人员确定是否合适可以接纳，并且给出加分值（奉献精神，信用度，技能等），如果投诉问题，则平台需要汇集相关人（含社区专家）公平解决，解决问题的过程中，相关人员的各项评分公平调整。\r\n任何人发起赏金任务之前，可以先搜索关键字，查询是否已经有解决了的类似赏金问题可以参考，随后在发起赏金任务。因此赏金任务的标题是可以全文检索的，并且根据解答和点赞程度排序。\r\n赏金任务的问题答案可以来自某个付费完成的赏金答案以及免费的答案，推荐的答案需要付费查看，即从赏金中扣除，如果发起人认为此答案炉头不对马嘴，则可以申请投诉，此时平台来核实推荐答案的人是否是失误导致的错误推荐，并且可能扣除相关信用分，如果核实为此答案与赏金问题无挂，没有帮助，则同时退还查看赏金答案的钱。\r\n\r\n','2017-11-21 07:04:14',NULL,0);
/*!40000 ALTER TABLE `t_crowd_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_crowd_project_comment`
--

DROP TABLE IF EXISTS `t_crowd_project_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_crowd_project_comment` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `stars` tinyint(2) DEFAULT NULL COMMENT '评分',
  `content` varchar(200) DEFAULT NULL COMMENT '评论内容',
  `user_id` bigint(20) DEFAULT NULL COMMENT '评论人Id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `bid_user_id` bigint(20) DEFAULT NULL COMMENT '中标者用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目评价表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_crowd_project_comment`
--

LOCK TABLES `t_crowd_project_comment` WRITE;
/*!40000 ALTER TABLE `t_crowd_project_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crowd_project_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_crowd_task_attachment`
--

DROP TABLE IF EXISTS `t_crowd_task_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_crowd_task_attachment` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务Id',
  `attachment_id` bigint(20) DEFAULT NULL COMMENT '附件ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '上传人',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目任务附件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_crowd_task_attachment`
--

LOCK TABLES `t_crowd_task_attachment` WRITE;
/*!40000 ALTER TABLE `t_crowd_task_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crowd_task_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_dictionary`
--

DROP TABLE IF EXISTS `t_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_dictionary` (
  `id` bigint(20) NOT NULL COMMENT 'Id',
  `dict_item` varchar(50) DEFAULT '' COMMENT '字典项目',
  `dict_key` varchar(50) DEFAULT '' COMMENT '字典key',
  `dict_value` varchar(50) DEFAULT '' COMMENT '字典值',
  `remark` varchar(80) DEFAULT '' COMMENT '描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_dictionary`
--

LOCK TABLES `t_dictionary` WRITE;
/*!40000 ALTER TABLE `t_dictionary` DISABLE KEYS */;
INSERT INTO `t_dictionary` VALUES (2,'language','2','Java','','2017-11-22 09:28:43','2017-11-22 09:28:43'),(3,'language','3','Ruby','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(4,'language','4','JavaScript','','2017-11-22 09:28:47','2017-11-22 09:28:47'),(5,'language','5','CSS','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(6,'language','6','C','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(7,'language','7','Python','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(8,'language','8','PHP','','2017-11-22 09:28:47','2017-11-22 09:28:47'),(9,'language','9','CoffeeScript','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(10,'language','10','Objective-C','','2017-11-22 09:28:47','2017-11-22 09:28:47'),(11,'language','11','C#','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(12,'language','12','C++','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(13,'language','13','Perl','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(14,'language','14','AutoHotkey','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(15,'language','15','Shell','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(16,'language','16','Go','','2017-11-22 09:28:47','2017-11-22 09:28:47'),(17,'language','17','VimL','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(18,'language','18','Matlab','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(19,'language','19','ASP','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(20,'language','20','Rust','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(21,'language','21','Scala','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(22,'language','22','Lua','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(23,'language','23','ActionScript','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(24,'language','24','Assembly','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(25,'language','25','Erlang','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(26,'language','26','Arduino','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(27,'language','27','Clojure','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(28,'language','28','Common Lisp','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(29,'language','29','Scheme','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(30,'language','30','FORTRAN','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(31,'language','31','Verilog','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(32,'language','32','Puppet','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(33,'language','33','Smalltalk','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(34,'language','34','XSLT','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(35,'language','35','Groovy','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(36,'language','36','Delphi','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(37,'language','37','eC','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(38,'language','38','R','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(39,'language','39','D','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(40,'language','40','Haskell','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(41,'language','41','Visual Basic','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(42,'language','42','PowerShell','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(43,'language','43','Emacs Lisp','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(44,'language','44','Racket','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(45,'language','45','OCaml','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(46,'language','46','Vala','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(47,'language','47','Ada','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(48,'language','48','TypeScript','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(49,'language','49','Dart','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(50,'language','50','M','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(51,'language','51','ColdFusion','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(52,'language','52','Awk','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(53,'language','53','LiveScript','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(54,'language','54','Slash','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(55,'language','55','Julia','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(56,'language','56','Nemerle','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(57,'language','57','Elixir','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(58,'language','58','VHDL','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(60,'language','60','TeX/LaTeX','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(61,'language','61','Standard ML','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(62,'language','62','Haxe','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(63,'language','63','Swift','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(64,'language','64','Eiffel','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(65,'language','65','DOT','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(66,'language','66','Scilab','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(67,'language','67','Prolog','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(68,'language','68','HTML','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(69,'language','69','NodeJS','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(70,'language','70','Pascal','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(71,'language','71','Android','','2017-11-22 09:28:47','2017-11-22 09:28:47'),(72,'language','72','Coq','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(73,'language','73','Logos','','2017-11-22 09:28:50','2017-11-22 09:28:50'),(74,'language','74','QML','','2017-11-22 09:28:49','2017-11-22 09:28:49'),(75,'language','75','Docker','','2017-11-22 09:28:48','2017-11-22 09:28:48'),(76,'language','76','微信','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(77,'language','77','Crystal','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(78,'language','78','Kotlin','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(79,'language','79','SQL','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(104,'language','104','Lisp','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(105,'language','105','XML','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(106,'language','106','C/C++','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(107,'language','107','HTML/CSS','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(108,'language','108','汇编','','2017-11-22 09:28:51','2017-11-22 09:28:51'),(109,'language','109','其他','','2017-11-22 09:28:51','2017-11-22 09:28:51');
/*!40000 ALTER TABLE `t_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_medal`
--

DROP TABLE IF EXISTS `t_medal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_medal` (
  `id` bigint(20) NOT NULL COMMENT '主键Id',
  `medal_code` varchar(20) DEFAULT NULL COMMENT '徽章编号',
  `medal_name` varchar(80) DEFAULT NULL COMMENT '徽章名称',
  `attachment_id` bigint(20) DEFAULT NULL COMMENT '徽章图片',
  `remark` varchar(120) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `medalCod` (`medal_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='徽章';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_medal`
--

LOCK TABLES `t_medal` WRITE;
/*!40000 ALTER TABLE `t_medal` DISABLE KEYS */;
INSERT INTO `t_medal` VALUES (1,'1','中国',1,'1','2017-11-28 11:31:36');
/*!40000 ALTER TABLE `t_medal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_level`
--

DROP TABLE IF EXISTS `t_member_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_level` (
  `id` bigint(20) NOT NULL,
  `section_id` bigint(20) DEFAULT NULL COMMENT '所属段位id',
  `name` varchar(32) DEFAULT NULL COMMENT '等级名称',
  `image_path` varchar(80) DEFAULT NULL,
  `points` int(11) DEFAULT NULL COMMENT '达到等级所需的积分',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否生效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='等级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_level`
--

LOCK TABLES `t_member_level` WRITE;
/*!40000 ALTER TABLE `t_member_level` DISABLE KEYS */;
INSERT INTO `t_member_level` VALUES (1,1,'初学乍练','',0,'2017-11-21 07:27:42',1),(2,1,'登堂入室','',500,'2017-11-21 07:23:23',1),(3,1,'圆转纯熟','',1000,'2017-11-21 07:28:40',1),(4,2,'初窥堂奥\r\n','',2000,'2017-11-21 07:29:50',1),(5,2,'略有小成\r\n','',3000,'2017-11-21 07:29:58',1),(6,2,'渐入佳境','',4000,'2017-11-21 07:30:38',1),(7,3,'炉火纯青','',6000,'2017-11-21 07:31:22',1),(8,3,'自成一派',NULL,8000,'2017-11-21 07:31:44',1),(9,3,'已臻大成',NULL,10000,'2017-11-21 07:31:51',1);
/*!40000 ALTER TABLE `t_member_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_message`
--

DROP TABLE IF EXISTS `t_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_message` (
  `id` bigint(20) NOT NULL COMMENT 'Id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `message` varchar(500) DEFAULT NULL COMMENT '消息内容',
  `sender_id` bigint(20) DEFAULT NULL COMMENT '发送者id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '消息发送时间',
  `is_read` tinyint(2) DEFAULT '0' COMMENT '是否已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户消息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_message`
--

LOCK TABLES `t_message` WRITE;
/*!40000 ALTER TABLE `t_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_point_rule`
--

DROP TABLE IF EXISTS `t_point_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_point_rule` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `action` int(11) DEFAULT NULL COMMENT '用户行为：做了什么',
  `points` int(11) DEFAULT NULL COMMENT '获得积分，正负值',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分规则表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_point_rule`
--

LOCK TABLES `t_point_rule` WRITE;
/*!40000 ALTER TABLE `t_point_rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_point_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL COMMENT '主键Id',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `role_name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_path` varchar(80) DEFAULT NULL COMMENT '允许角色权限访问的url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'admin','超级管理员','/admin'),(2,'user','注册用户','/');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_section`
--

DROP TABLE IF EXISTS `t_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_section` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT '段位名称',
  `describe` varchar(64) DEFAULT NULL COMMENT '描述',
  `weight` tinyint(2) DEFAULT '100' COMMENT '积分权重',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='段位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_section`
--

LOCK TABLES `t_section` WRITE;
/*!40000 ALTER TABLE `t_section` DISABLE KEYS */;
INSERT INTO `t_section` VALUES (1,'一段','',NULL,'2017-11-21 07:22:38'),(2,'二段','',NULL,'2017-11-21 07:22:44'),(3,'三段',NULL,NULL,'2017-11-21 07:22:48');
/*!40000 ALTER TABLE `t_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_share_office`
--

DROP TABLE IF EXISTS `t_share_office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_share_office` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `title` varchar(120) DEFAULT NULL COMMENT '显示',
  `address` varchar(300) DEFAULT NULL COMMENT '地址',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_share_office`
--

LOCK TABLES `t_share_office` WRITE;
/*!40000 ALTER TABLE `t_share_office` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_share_office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_team`
--

DROP TABLE IF EXISTS `t_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_team` (
  `team_id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '团队负责人',
  `team_name` varchar(32) DEFAULT NULL COMMENT '团队名称（限定16个字）',
  `public` tinyint(2) DEFAULT NULL COMMENT '是否公开（公开后可团队主页）',
  `homepage_url` varchar(32) DEFAULT NULL COMMENT '主页',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队组织';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_team`
--

LOCK TABLES `t_team` WRITE;
/*!40000 ALTER TABLE `t_team` DISABLE KEYS */;
INSERT INTO `t_team` VALUES (1,1,'黄埔天地会',1,'sky','2017-11-22 11:44:42');
/*!40000 ALTER TABLE `t_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_team_member`
--

DROP TABLE IF EXISTS `t_team_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_team_member` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `team_project_id` bigint(20) DEFAULT NULL COMMENT '团队项目ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '成员ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 0邀请 1申请加入 2同意加入 3拒绝加入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队项目成员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_team_member`
--

LOCK TABLES `t_team_member` WRITE;
/*!40000 ALTER TABLE `t_team_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_team_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_team_project`
--

DROP TABLE IF EXISTS `t_team_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_team_project` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `team_id` bigint(20) DEFAULT NULL COMMENT '团队id',
  `crowd_project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '项目创建人',
  `project_name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `language` tinyint(2) DEFAULT NULL COMMENT '语言(字典表 t_dictionary language)',
  `git_url` varchar(64) DEFAULT '' COMMENT 'git地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_team_project`
--

LOCK TABLES `t_team_project` WRITE;
/*!40000 ALTER TABLE `t_team_project` DISABLE KEYS */;
INSERT INTO `t_team_project` VALUES (1,1,2,1,'Mykingdom',1,'https://github.com/MyCATApache/MyKingdom','2017-11-22 19:48:32');
/*!40000 ALTER TABLE `t_team_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_team_project_member`
--

DROP TABLE IF EXISTS `t_team_project_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_team_project_member` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `team_project_id` bigint(20) DEFAULT NULL COMMENT '团队项目ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '成员ID',
  `user_role` tinyint(2) DEFAULT NULL COMMENT '角色：0普通成员 1管理员',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队项目成员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_team_project_member`
--

LOCK TABLES `t_team_project_member` WRITE;
/*!40000 ALTER TABLE `t_team_project_member` DISABLE KEYS */;
INSERT INTO `t_team_project_member` VALUES (1,1,1,1,'2017-11-22 11:48:07',1);
/*!40000 ALTER TABLE `t_team_project_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_team_project_task`
--

DROP TABLE IF EXISTS `t_team_project_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_team_project_task` (
  `task_id` bigint(20) NOT NULL COMMENT 'ID',
  `team_project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '任务创建人',
  `duty_user_id` bigint(20) DEFAULT NULL COMMENT '责任人',
  `title` varchar(64) DEFAULT NULL COMMENT '任务标题',
  `content` text COMMENT '任务描述',
  `duration` float(4,2) DEFAULT NULL COMMENT '工期单位天',
  `priority` tinyint(2) DEFAULT NULL COMMENT '优先级别：1紧急 2主要 3次要 4不重要',
  `issue_type` tinyint(2) DEFAULT NULL COMMENT '问题类型：1功能 2bug',
  `start_time` datetime DEFAULT NULL COMMENT '开始日期',
  `end_time` datetime DEFAULT NULL COMMENT '结束日期',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 0待办的，1处理中，2关闭，3已验收',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目任务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_team_project_task`
--

LOCK TABLES `t_team_project_task` WRITE;
/*!40000 ALTER TABLE `t_team_project_task` DISABLE KEYS */;
INSERT INTO `t_team_project_task` VALUES (1,1,1,1,'项目架构搭建','mybatis+spring boot+spring security',2.00,4,1,'2017-11-21 18:01:51','2017-11-23 18:01:55',1,'2017-11-21 18:02:01'),(2,1,1,1,'UI设计','UI',3.00,3,1,'2017-11-22 20:31:01','2017-11-25 20:31:03',1,'2017-11-22 20:31:07');
/*!40000 ALTER TABLE `t_team_project_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_team_project_task_history`
--

DROP TABLE IF EXISTS `t_team_project_task_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_team_project_task_history` (
  `id` bigint(20) DEFAULT NULL COMMENT 'id',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务Id',
  `user_id` bigint(20) DEFAULT NULL,
  `action` tinyint(2) DEFAULT NULL COMMENT '行为 0、创建 1、更新 2、指派 3、认领',
  `content` varchar(128) DEFAULT NULL COMMENT '更新内容',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务修改操作历史记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_team_project_task_history`
--

LOCK TABLES `t_team_project_task_history` WRITE;
/*!40000 ALTER TABLE `t_team_project_task_history` DISABLE KEYS */;
INSERT INTO `t_team_project_task_history` VALUES (1,1,1,1,'指派给黄飞','2017-11-21 18:02:20'),(1,1,1,2,'认领了任务','2017-11-22 20:31:25');
/*!40000 ALTER TABLE `t_team_project_task_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL COMMENT '用户id',
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
  `points` int(11) DEFAULT NULL COMMENT '积分',
  `credit_points` int(11) DEFAULT NULL COMMENT '信誉平均分',
  `balance` bigint(20) DEFAULT NULL COMMENT '干粮余额',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'hpgary','hpgary','黄飞',NULL,'黄飞',NULL,'834865081','hpgary@qq.com','',NULL,'我梦想有一天能...',10,5,10,'2017-11-21 03:48:04'),(2,'1792653876','1792653876','陈超',NULL,'陈超',NULL,'1792653876','1792653876@qq.com','',NULL,'我梦想有一天能...',0,0,0,'2017-11-21 09:57:00'),(3,'xusihano','xusihano','许思涵',NULL,'思涵',NULL,'383688501','383688501@qq.com','',NULL,'我梦想有一天能...',0,0,0,'2017-11-21 09:58:03'),(4,'linxiaofang','linxiaofang','林晓芳',NULL,'小狐狸',NULL,'359570565','lynseylin@qq.com','',NULL,'我梦想有一天能...',0,0,0,'2017-11-23 03:08:16');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_account_detail`
--

DROP TABLE IF EXISTS `t_user_account_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_account_detail` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `amount` bigint(20) DEFAULT NULL COMMENT '交易金额，单位分',
  `balance` bigint(20) DEFAULT NULL COMMENT '当前余额',
  `pay_method` tinyint(2) DEFAULT NULL COMMENT '支付方式',
  `pay_justify` varchar(50) DEFAULT NULL COMMENT '支付证明',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `verify_time` datetime DEFAULT NULL COMMENT '审核日期',
  `remark` varchar(80) DEFAULT NULL COMMENT '备注说明',
  `manager_id` bigint(20) DEFAULT NULL COMMENT '经办人',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 0、未审核 1、审核状态 2、审核未通过',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员帐户记录明细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_account_detail`
--

LOCK TABLES `t_user_account_detail` WRITE;
/*!40000 ALTER TABLE `t_user_account_detail` DISABLE KEYS */;
INSERT INTO `t_user_account_detail` VALUES (1,1,10,10,1,'','2017-11-21 06:23:08','2017-11-21 14:22:52','系统奖励',1,1,NULL);
/*!40000 ALTER TABLE `t_user_account_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_dream_history`
--

DROP TABLE IF EXISTS `t_user_dream_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_dream_history` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `dream` varchar(256) DEFAULT NULL COMMENT '历史梦想',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '梦想日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='历史梦想表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_dream_history`
--

LOCK TABLES `t_user_dream_history` WRITE;
/*!40000 ALTER TABLE `t_user_dream_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_dream_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_favor`
--

DROP TABLE IF EXISTS `t_user_favor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_favor` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `favor_id` bigint(20) DEFAULT NULL COMMENT '收藏ID',
  `link` varchar(128) DEFAULT NULL COMMENT '收藏地址',
  `favor_type` tinyint(2) DEFAULT NULL COMMENT '收藏',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_favor`
--

LOCK TABLES `t_user_favor` WRITE;
/*!40000 ALTER TABLE `t_user_favor` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_favor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_medal`
--

DROP TABLE IF EXISTS `t_user_medal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_medal` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `medal_id` bigint(20) NOT NULL COMMENT '徽章ID',
  `remark` varchar(64) NOT NULL COMMENT '备注',
  `manager_id` bigint(20) NOT NULL COMMENT '管理员ID,操作人ID',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 1、可用 2、不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户徽章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_medal`
--

LOCK TABLES `t_user_medal` WRITE;
/*!40000 ALTER TABLE `t_user_medal` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_medal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_point_detail`
--

DROP TABLE IF EXISTS `t_user_point_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_point_detail` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户iD',
  `amount` int(11) DEFAULT NULL COMMENT '积分',
  `balance` bigint(20) DEFAULT NULL COMMENT '余额',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '获得积分时间',
  `remark` varchar(80) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员积分明细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_point_detail`
--

LOCK TABLES `t_user_point_detail` WRITE;
/*!40000 ALTER TABLE `t_user_point_detail` DISABLE KEYS */;
INSERT INTO `t_user_point_detail` VALUES (1,1,10,10,'2017-11-21 14:25:32','系统奖励');
/*!40000 ALTER TABLE `t_user_point_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_project`
--

DROP TABLE IF EXISTS `t_user_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_project` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '任务Id',
  `price` bigint(20) DEFAULT NULL COMMENT '报价',
  `duration` tinyint(2) DEFAULT NULL COMMENT '周期',
  `contact` varchar(32) DEFAULT NULL COMMENT 'QQ or email or 电话',
  `content` varchar(500) DEFAULT NULL COMMENT '投标说明',
  `attachment_id` bigint(20) DEFAULT NULL COMMENT '附件文件',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请日期',
  `verify_time` timestamp NULL DEFAULT NULL COMMENT '投标日期',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 0投标中 1中标 2未中标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户投递中标项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_project`
--

LOCK TABLES `t_user_project` WRITE;
/*!40000 ALTER TABLE `t_user_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES (1,1,1);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_technology`
--

DROP TABLE IF EXISTS `t_user_technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_technology` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `technology_name` varchar(50) DEFAULT NULL COMMENT '技术名称',
  `use_month` tinyint(3) DEFAULT NULL COMMENT '使用月份',
  `grade` tinyint(2) DEFAULT NULL COMMENT '技术等级（一般，良好，熟练，精通）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户技能';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_technology`
--

LOCK TABLES `t_user_technology` WRITE;
/*!40000 ALTER TABLE `t_user_technology` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_technology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tc_business`
--

DROP TABLE IF EXISTS `tc_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tc_business` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `business_name` varchar(80) NOT NULL DEFAULT '' COMMENT '业务名称',
  `state` tinyint(2) DEFAULT NULL COMMENT '状态（1可用，0不可用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=407589774988414977 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tc_business`
--

LOCK TABLES `tc_business` WRITE;
/*!40000 ALTER TABLE `tc_business` DISABLE KEYS */;
INSERT INTO `tc_business` VALUES (1,'公司注册',1,'2018-01-18 12:23:42'),(2,'共享工位',1,'2018-01-18 12:23:54'),(3,'总经理秘书',1,'2018-01-18 12:23:58'),(4,'财务管理',1,'2018-01-18 12:24:02'),(5,'商务合同',1,'2018-01-18 12:24:05'),(6,'人力资源服务',1,'2018-01-18 12:24:08'),(7,'软件人才培训',1,'2018-01-18 12:24:11'),(8,'互联网产品众包研发',1,'2018-01-18 12:24:17'),(9,'销售和市场推广服务',1,'2018-01-18 12:24:20');
/*!40000 ALTER TABLE `tc_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tc_cust_business`
--

DROP TABLE IF EXISTS `tc_cust_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tc_cust_business` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `cust_id` bigint(20) DEFAULT NULL COMMENT '客户Id',
  `biz_id` bigint(20) DEFAULT NULL COMMENT '办理业务ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tc_cust_business`
--

LOCK TABLES `tc_cust_business` WRITE;
/*!40000 ALTER TABLE `tc_cust_business` DISABLE KEYS */;
INSERT INTO `tc_cust_business` VALUES (404972994340065280,404972994327482368,1),(409000018033512448,409000017920266240,1),(418361725528838144,418361725503672320,3),(418361725537226752,418361725503672320,5),(420653483042279424,420653483029696512,10101),(420654238608396288,420654238600007680,10101),(420654267398098944,420654267389710336,10101);
/*!40000 ALTER TABLE `tc_cust_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tc_cust_info`
--

DROP TABLE IF EXISTS `tc_cust_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tc_cust_info` (
  `id` bigint(20) NOT NULL COMMENT '客户资料',
  `cust_name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `wechat` varchar(64) DEFAULT NULL COMMENT '微信账号',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ号',
  `cc_time` varchar(50) DEFAULT NULL COMMENT '沟通时间',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '客户电话',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '留时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tc_cust_info`
--

LOCK TABLES `tc_cust_info` WRITE;
/*!40000 ALTER TABLE `tc_cust_info` DISABLE KEYS */;
INSERT INTO `tc_cust_info` VALUES (404972994327482368,'何财琴',NULL,NULL,'上午,中午,下午,晚上18:00-20:00',NULL,'15871390901','2018-01-22 04:18:06'),(409000017920266240,'aaa',NULL,NULL,'上午,中午,下午,晚上18:00-20:00',NULL,'13312121212','2018-02-02 07:00:03'),(418361725503672320,'sdf',NULL,NULL,'中午',NULL,'sdf','2018-02-28 03:00:08'),(420653483029696512,'xxx',NULL,NULL,NULL,NULL,'1672342344','2018-03-06 10:46:46'),(420654238600007680,'xxx',NULL,NULL,NULL,NULL,'aass','2018-03-06 10:49:46'),(420654267389710336,'xxx',NULL,NULL,NULL,NULL,'aasssada','2018-03-06 10:49:53');
/*!40000 ALTER TABLE `tc_cust_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tc_cust_record`
--

DROP TABLE IF EXISTS `tc_cust_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tc_cust_record` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `cust_id` bigint(20) DEFAULT NULL COMMENT '客户跟进记录',
  `user_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `remarks` varchar(320) DEFAULT NULL COMMENT '客户跟进记录',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户跟进记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tc_cust_record`
--

LOCK TABLES `tc_cust_record` WRITE;
/*!40000 ALTER TABLE `tc_cust_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `tc_cust_record` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-08  9:45:22
