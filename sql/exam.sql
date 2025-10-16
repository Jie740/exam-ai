/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.127.128
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 192.168.127.128:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 17/10/2025 00:10:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser`  (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电子邮箱',
  `pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `card_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证号',
  `role` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色(0管理员，1教师，2学生)',
  PRIMARY KEY (`admin_id`) USING BTREE,
  INDEX `sex`(`sex` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '管理员信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES (9527, '超级管理员', '男', '13658377857', '1253838283@qq.com', '123456', '3132', '0');

-- ----------------------------
-- Table structure for exam_manage
-- ----------------------------
DROP TABLE IF EXISTS `exam_manage`;
CREATE TABLE `exam_manage`  (
  `exam_code` int NOT NULL AUTO_INCREMENT COMMENT '考试编号',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '该次考试介绍',
  `source` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程名称',
  `paper_id` int NULL DEFAULT NULL COMMENT '试卷编号',
  `exam_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试日期',
  `total_time` int NULL DEFAULT NULL COMMENT '持续时长',
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '年级',
  `term` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学期',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '专业',
  `institute` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院',
  `total_score` int NULL DEFAULT NULL COMMENT '总分',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试类型',
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考生须知',
  PRIMARY KEY (`exam_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20190021 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '考试管理表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of exam_manage
-- ----------------------------
INSERT INTO `exam_manage` VALUES (20190001, '2019年上期期末考试', '计算机网络', 1001, '2019-03-21', 120, '2018', '1', '计算机科学与技术', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190002, '2019年上期期末考试', '数据库理论', 1002, '2019-03-07', 90, '2018', '2', '网络工程', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190003, '2018年下期期末考试', '数据结构', 1003, '2019-02-27', 90, '2017', '1', '软件工程', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190005, '2018年上期期末考试', '计算机导论', 1004, '2019-03-14', 90, '2018', '1', '计算机科学与技术', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190006, '2017年上期期末考试', '软件工程', 1005, '2019-03-21', 120, '2018', '1', '计算机科学与技术', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190007, '2018年上期期末考试', '操作系统', 1006, '2019-03-13', 120, '2018', '2', '计算机科学与技术', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190008, '2018年下期期末考试', 'C语言', 1007, '2019-03-13', 120, '2018', '1', '信息工程', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190009, '2018年上期期末考试', '高等数学', 1008, '2019-03-07', 90, '2018', '1', '信息工程', '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190014, '1', 't1', 1009, '2025-10-21', 1, '1', NULL, '1', '1', 22, '1', '1');
INSERT INTO `exam_manage` VALUES (20190015, '1', '1', 1010, '2025-10-22', 1, '1', NULL, '1', '1', NULL, '1', '1');
INSERT INTO `exam_manage` VALUES (20190016, '12', 't2', 1011, '2025-10-08', 1, '1', NULL, '1', '1', NULL, '1', '1');
INSERT INTO `exam_manage` VALUES (20190017, '1', 't3', 1012, '2025-10-29', 1, '1', NULL, '1', '1', NULL, '1', '1');
INSERT INTO `exam_manage` VALUES (20190018, '1', 't4', 1013, '2025-10-22', 1, '1', NULL, '1', '1', NULL, '1', '1');
INSERT INTO `exam_manage` VALUES (20190019, '1', 't5', 1014, '2025-10-14', 1, '1', NULL, '1', '1', NULL, '1', '1');
INSERT INTO `exam_manage` VALUES (20190020, '1', 't9', 1015, '2025-10-22', 1, '1', NULL, '1', '1', NULL, '1', '1');

-- ----------------------------
-- Table structure for fill_question
-- ----------------------------
DROP TABLE IF EXISTS `fill_question`;
CREATE TABLE `fill_question`  (
  `question_id` int NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '试题内容',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int NULL DEFAULT 2 COMMENT '分数',
  `level` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '难度等级',
  `section` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属章节',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10040 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '填空题题库' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fill_question
-- ----------------------------
INSERT INTO `fill_question` VALUES (10000, '计算机网络', '从计算机网络系统组成的角度看，计算机网络可以分为()和()', '通信子网资源子网', '11', 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10001, '计算机网络', '收发电子邮件，属于ISO/OSI RM中 ()层的功能。', '应用', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10002, '计算机网络', '在TCP/IP层次模型中与OSI参考模型第四层相对应的主要协议有()和(),其中后者提供无连接的不可靠传输服', 'TCP（传输控制协议） UDP（用户数据报协议） ', NULL, 2, '2', NULL);
INSERT INTO `fill_question` VALUES (10003, '计算机网络', '计算机网络中常用的三种有线媒体是 (),()和 ()', '同轴电缆.双绞线 光纤', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10004, '计算机网络', '国内最早的四大网络包括原邮电部的ChinaNet. 原电子部的ChinaGBN. 教育部的()和中科院的CSTnet', 'CERnet (或中国教育科研网)', NULL, 2, '4', NULL);
INSERT INTO `fill_question` VALUES (10005, '计算机网络', '复盖一个国家，地区或几个洲的计算机网络称为()，在同一建筑或复盖几公里内范围的网络称为()，而介于两者之间的是()', ' 广域网       局域网     城域网', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10006, '计算机网络', 'Outlook等常用电子邮件软件接收邮件使用的协议是(),发送邮件时使用的协议是()', 'POP3    SMTP    ', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10007, '计算机网络', '通信系统中，称调制前的电信号为()信号，调制后的信号为调制信号', '基带', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10008, '计算机网络', '按照IPV4标准,IP地址205.3.127.13属于()类地址', 'C', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10009, '计算机网络', '计算机网络采用()技术，而传统电话网络则采用()技术', '分组交换电路交换', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10010, '计算机网络', '计算机内传输的信号是()，而公用电话系统的传输系统只能传输()', '数字信号模拟信号', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10011, '计算机网络', '通信系统中，称调制前的电信号为()，调制后的信号叫()。', '基带信号调制信号', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10012, '计算机网络', 'IP地址分()和()两个部分', '网络号主机号', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10013, '计算机网络', ' IP地址协议作网间网中()层协议，提供无连接的数据报传输机制，IP数据报也分为()和()两个部分', '网络报头数据区', NULL, 2, '2', NULL);
INSERT INTO `fill_question` VALUES (10014, '计算机网络', '()是一个简单的远程终端协议。', 'TELNET', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10015, '计算机网络', '在同一个系统内，相邻层之间交换信息的连接点称之为()，而低层模块向高层提供功能性的支持称之为()。', '接口服务', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10016, '计算机网络', 'Internet广泛使用的电子邮件传送协议是()', 'SMTP', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10017, '计算机网络', '按交换方式来分类，计算机网络可以分为电路交换网，  报文交换网  和()三种', '分组交换网', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10018, '计算机网络', 'Intranet分层结构包括网络、(),应用三个层次。', '服务', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10019, '计算机网络', 'WWW上的每一个网页都有一个独立的地址，这些地址称为  ()', '统一资源定位器/URL ', NULL, 2, '2', NULL);
INSERT INTO `fill_question` VALUES (10020, '计算机网络', '分组交换网中，附加信息用来在网络中进行路由选择、() 和流量控制', '差错纠正  ', NULL, 2, '4', NULL);
INSERT INTO `fill_question` VALUES (10021, '计算机网络', '根据IEEE802模型的标准将数据链路层划分为LLC子层和 ()子层。', ' MAC ', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10022, '计算机网络', '据交换的路由信息的不同，路由算法可以分为两大类：  ()  和链路状态算法', '距离向量算法', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10023, '计算机网络', '假定某信道受奈氏准则限制的最高码元速率为2000码元/秒。如果采用振幅调制，把码元的振幅划分为16个不同等级来传送，那么可以获得的数据率为 () b/s。', '80000 ', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10024, '计算机网络', '交换型以太网系统中的 ()  ，以其为核心联接站点或者网段，端口之间帧的输入和输出已不再受到CSMA/CD媒体访问控制协议的约束。', '以太网交换器 ', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10025, '计算机网络', '局域网络参考模型是以 ()标准为基础的', 'IEEE802', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10026, '计算机网络', '路由器的核心是 () 。', ' 路由表', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10027, '计算机网络', '若 HDLC 帧数据段中出现比特串“ 01011111110 ”，则比特填充后的输出为()', '10111110110', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10028, '计算机网络', '数字调制的三种基本形式：移幅键控法ASK、 ()、移相键控法PSK', '移频键控法FSK', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10039, 't9', 'The university requires all international students to pass the English ________ test before enrollment.', 'proficiency', 'The phrase \'English proficiency test\' is commonly used in academic contexts to assess non-native speakers\' language ability.', 1, 'medium', '大学英语');

-- ----------------------------
-- Table structure for judge_question
-- ----------------------------
DROP TABLE IF EXISTS `judge_question`;
CREATE TABLE `judge_question`  (
  `question_id` int NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '试题内容',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int NULL DEFAULT 2 COMMENT '分数',
  `level` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '难度等级',
  `section` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属章节',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10026 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '判断题题库表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of judge_question
-- ----------------------------
INSERT INTO `judge_question` VALUES (10001, '计算机网络', '与有线网相比,无线网的数据传输率一般相对较慢', 'T', NULL, 2, '1', '11');
INSERT INTO `judge_question` VALUES (10002, '计算机网络', 'OSI参考模型中,不同节点的同等层具有不同的功能', 'F', NULL, 2, '1', NULL);
INSERT INTO `judge_question` VALUES (10003, '计算机网络', '普通电脑不能作为服务器', 'F', NULL, 2, '1', NULL);
INSERT INTO `judge_question` VALUES (10004, '计算机网络', '没有网线的电脑不能连入互联网', 'F', NULL, 2, '1', NULL);
INSERT INTO `judge_question` VALUES (10005, '计算机网络', '网卡必须安装驱动程序', 'T', NULL, 2, '2', NULL);
INSERT INTO `judge_question` VALUES (10006, '计算机网络', 'UTP为屏蔽双绞线', 'F', NULL, 2, '2', NULL);
INSERT INTO `judge_question` VALUES (10007, '计算机网络', '网络接口卡又称为网卡,它是构成网络的基本部件', 'T', NULL, 2, '2', NULL);
INSERT INTO `judge_question` VALUES (10008, '计算机网络', '无线AP可以成倍地扩展网络覆盖范围', 'T', NULL, 2, '3', NULL);
INSERT INTO `judge_question` VALUES (10009, '计算机网络', 'SMTP是一组用于由源地址到目的地址传送邮件的协议', 'T', NULL, 2, '4', NULL);
INSERT INTO `judge_question` VALUES (10010, '计算机网络', '任务管理器可以关闭所有的进程', 'F', NULL, 2, '3', NULL);
INSERT INTO `judge_question` VALUES (10011, '计算机网络', '利用BT下载时,用户越多,下载速度越快', 'T', NULL, 2, '2', NULL);
INSERT INTO `judge_question` VALUES (10012, '计算机网络', 'INTERNET上向朋友发送电子邮件,必须知道对方的真实姓名和家庭住址', 'F', NULL, 2, '1', NULL);
INSERT INTO `judge_question` VALUES (10013, '数据库理论', '1', 'T', '1', 2, '2', '1');
INSERT INTO `judge_question` VALUES (10014, '数据库理论', '1', 'T', '1', 2, '2', '1');
INSERT INTO `judge_question` VALUES (10016, '数据库理论', '1', 'T', '1', 2, '1', '1');
INSERT INTO `judge_question` VALUES (10018, '计算机网络', '1', 'T', '1', 1, '', '');
INSERT INTO `judge_question` VALUES (10025, 't9', '在经典力学中，物体的质量随速度变化而变化。', 'F', '在经典力学中，物体的质量被认为是恒定不变的，不随速度变化。只有在相对论力学中，质量才会随速度变化。', 1, '中等', '力学基础');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '留言编号',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '留言内容',
  `time` date NULL DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '留言表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (2, '晚上加班,这感觉非常的nice', '今天是星期一的晚上,下班后回到宿舍继续写我的毕业设计,看着项目功能日渐丰满好开心哦,你们也要元气满满哦！', '2019-03-18');
INSERT INTO `message` VALUES (15, '咸鱼', '我是一条咸鱼', '2019-03-18');
INSERT INTO `message` VALUES (16, '今天中午吃什么', '今天去吃莲藕排骨汤吧，虽然也不好吃，但这里真的没什么东西可以吃了', '2019-03-18');
INSERT INTO `message` VALUES (20, '这个网站不错', '博主大大好厉害，网页看着很清新呢，喜欢这样嘞风格。', '2019-03-18');
INSERT INTO `message` VALUES (21, '男孩子', '哇，这么可爱，那肯定是男孩子呀。', '2019-03-18');
INSERT INTO `message` VALUES (22, '好人', '你是个好人，可是我们不合适。', '2019-03-18');
INSERT INTO `message` VALUES (25, '小乔', '花会枯萎，爱永不凋零，小乔要努力变强。', '2019-03-18');
INSERT INTO `message` VALUES (26, '妲己', '妲己会一直爱主人，因为被设定成这样，来和妲己玩耍吧。', '2019-03-18');
INSERT INTO `message` VALUES (27, '土味情话', '妈妈从小对我讲，不要早恋，遇到你以后，我决定不听妈妈的话了。', '2019-03-31');
INSERT INTO `message` VALUES (35, '贝塔', '开坦克', '2019-09-05');

-- ----------------------------
-- Table structure for multi_question
-- ----------------------------
DROP TABLE IF EXISTS `multi_question`;
CREATE TABLE `multi_question`  (
  `question_id` int NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问题题目',
  `answer_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项A',
  `answer_b` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项B',
  `answer_c` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项C',
  `answer_d` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项D',
  `right_answer` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int NULL DEFAULT 2 COMMENT '分数',
  `section` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属章节',
  `level` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '难度等级',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10059 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '选择题题库表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of multi_question
-- ----------------------------
INSERT INTO `multi_question` VALUES (10000, '计算机网络', 'DNS 服务器和DHCP服务器的作用是（）', '将IP地址翻译为计算机名，为客户机分配IP地址', '将IP地址翻译为计算机名、解析计算机的MAC地址', '将计算机名翻译为IP地址、为客户机分配IP地址', '将计算机名翻译为IP地址、解析计算机的MAC地址', 'C', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10001, '计算机网络', 'HTTP协议通常使用什么协议进行传输（）', 'ARP', 'DHCP', 'UDP', 'TCP', 'D', NULL, 1, '应用层', '2');
INSERT INTO `multi_question` VALUES (10003, '计算机网络', '查看DNS缓存记录的命令（）', 'ipconfig/displaydns', 'nslookup', 'ipconfig/release', 'ipconfig/flushdns', 'A', NULL, 2, '应用层', '3');
INSERT INTO `multi_question` VALUES (10004, '计算机网络', 'DHCP(        )报文的目的IP地址为255.255.255.255', 'DhcpDisover', 'DhcpOffer', 'DhcpAck', 'DhcpNack', 'A', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10005, '计算机网络', '下列地址中，（  ）不是DHCP服务器分配的IP地址', '196.254.109.100', '169.254.12.42', '69.254.48.45', '96.254.54.15', 'B', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10006, '计算机网络', 'DHCP通常可以为客户端自动配置哪些网络参数（）', 'IP，掩码，网关，DNS', 'IP，掩码，域名，SMTP', '网关，掩码，浏览器，FTP', 'IP，网关，DNS，服务器', 'A', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10007, '计算机网络', 'DNS服务器在名称解析过程中正确的查询顺序为（）', '本地缓存记录→区域记录→转发域名服务器→根域名服务器', '区域记录→本地缓存记录→转发域名服务器→根域名服务器', '本地缓存记录→区域记录→根域名服务器→转发域名服务器', '区域记录→本地缓存记录→根域名服务器→转发域名服务器', 'A', NULL, 2, '应用层', '3');
INSERT INTO `multi_question` VALUES (10008, '计算机网络', '在TCP/IP协议中，序号小于（  ）的端口称为熟知端口(well-known port)。', '1024', '64', '256', '128', 'A', NULL, 2, '传输层', '1');
INSERT INTO `multi_question` VALUES (10009, '计算机网络', '在Internet上用TCP/IP播放视频，想用传输层的最快协议，以减少时延，要使用（ ）', 'UDP协议的低开销特性', 'UDP协议的高开销特性', 'TCP协议的低开销特性', 'TCP协议的高开销特性', 'A', NULL, 2, '传输层', '2');
INSERT INTO `multi_question` VALUES (10010, '计算机网络', '在TCP协议中采用（ ）来区分不同的应用进程', '端口号', 'IP地址', '协议类型', 'MAC地址', 'A', NULL, 2, '传输层', '3');
INSERT INTO `multi_question` VALUES (10011, '计算机网络', '可靠的传输协议中的“可靠”指的是（ ）', '使用面向连接的会话', '使用“尽力而为”的传输', '使用滑动窗口来维持可靠性', '使用确认重传机制来确保传输的数据不丢失', 'D', NULL, 2, '传输层', '2');
INSERT INTO `multi_question` VALUES (10012, '计算机网络', '假设拥塞窗口为50KB，接收窗口为80KB，TCP能够发送的最大字节数为（ ）', '50KB', '80KB', '130KB', '30KB', 'A', NULL, 2, '传输层', '4');
INSERT INTO `multi_question` VALUES (10013, '计算机网络', '主机A向主机B发送一个（SYN=1，seq=2000）的TCP报文，期望与主机B建立连接，若主机B接受连接请求，则主机B发送的正确有TCP报文可能是（ ）', '（SYN=0,ACK=0,seq=2001,ack=2001）', '（SYN=1,ACK=1,seq=2000,ack=2000）', '•	C.（SYN=1,ACK=1,seq=2001,ack=2001）', '（SYN=0,ACK=1,seq=2000,ack=2000）', 'C', NULL, 2, '传输层', '2');
INSERT INTO `multi_question` VALUES (10014, '计算机网络', '主机A向主机B连续发送了两个TCP报文段，其序号分别为70和100。试问： （1）第一个报文段携带了（）个字节的数据？', ' 70', '30', '100', '170', 'B', NULL, 2, '传输层', '3');
INSERT INTO `multi_question` VALUES (10015, '计算机网络', 'PCM脉码调制的过程（ ）', '采样、量化、编码', '量化、编码、采样', '编码、量化、采样', '采样、编码、量化', 'A', NULL, 2, '物理层', '4');
INSERT INTO `multi_question` VALUES (10016, '计算机网络', '若某采用4相位调制的通信链路的数据传输速率为2400bps，则该链路的波特率为（）', '600Baud', '1200Baud', '4800Baud', '9600Baud', 'B', NULL, 2, '物理层', '1');
INSERT INTO `multi_question` VALUES (10017, '计算机网络', '以下关于数据传输速率的描述中，错误的是( )', '数据传输速率表示每秒钟传输构成数据代码的二进制比特数', '对于二进制数据，数据传输速率为S=1/T (bps)', '常用的数据传输速率单位有: 1Mbps=1.024×106bps', '数据传输速率是描述数据传输系统性能的重要技术指标之一', 'C', NULL, 2, '物理层', '2');
INSERT INTO `multi_question` VALUES (10018, '计算机网络', '以下关于时分多路复用概念的描述中，错误的是.(  ).', '时分多路复用将线路使用的时间分成多个时间片', '时分多路复用分为同步时分多路复用与统计时分多路复用', '时分多路复用使用“帧”与数据链路层“帧”的概念、作用是不同的', '统计时分多路复用将时间片预先分配给各个信道', 'D', NULL, 2, '物理层', '2');
INSERT INTO `multi_question` VALUES (10019, '计算机网络', '1000BASE-T标准支持的传输介质是（）', '双绞线', '同轴电缆', '光纤', '无线电', 'A', NULL, 2, '物理层', '1');
INSERT INTO `multi_question` VALUES (10020, '计算机网络', '一个以太网交换机，读取整个数据帧，对数据帧进行差错校验后再转发出去，这种交换方式称为 （）', '直通交换', '无碎片交换', '无差错交换', '存储转发交换', 'D', NULL, 2, '数据链路层', '2');
INSERT INTO `multi_question` VALUES (10021, '计算机网络', '关于VLAN，下面的描述中正确的是（）', '一个新的交换机没有配置VLAN', '通过配置VLAN减少了冲突域的数量', '一个VLAN不能跨越多个交换机', '各个VLAN属于不同的广播域', 'D', NULL, 2, '数据链路层', '2');
INSERT INTO `multi_question` VALUES (10022, '计算机网络', '以太网协议中使用物理地址作用是什么？', '.用于不同子网中的主机进行通信', '作为第二层设备的唯一标识', '用于区别第二层第三层的协议数据单元', '保存主机可检测未知的远程设备', 'B', NULL, 2, '数据链路层', '2');
INSERT INTO `multi_question` VALUES (10023, '计算机网络', '以太网采用的CSMA/CD协议，当冲突发生时要通过二进制指数后退算法计算后退延时， 关于这个算法，以下论述中错误的是 （）', '冲突次数越多，后退的时间越短', '平均后退次数的多少与负载大小有关', '后退时延的平均值与负载大小有关', '重发次数达到一定极限后放弃发送', 'A', NULL, 2, '数据链路层', '3');
INSERT INTO `multi_question` VALUES (10024, '计算机网络', '以下关于交换机获取与其端口连接设备的MAC地址的叙述中，正确的是（）', '交换机从路由表中提取设备的MAC地址', '交换机检查端口流入分组的源地址', '交换机之间互相交换地址表', '网络管理员手工输入设备的MAC地址', 'B', NULL, 2, '数据链路层', '2');
INSERT INTO `multi_question` VALUES (10025, '计算机网络', '如果G (x）为11010010，以下4个CRC校验比特序列中只有哪个可能是正确的 ？', '1101011001', '101011011', '11011011', '1011001', 'B', NULL, 2, '数据链路层', '1');
INSERT INTO `multi_question` VALUES (10026, '计算机网络', '以下关于Ethernet物理地址的描述中，错误的是', 'Ethernet物理地址又叫做MAC地址', '48位的Ethernet物理地址允许分配的地址数达到247个', '网卡的物理地址写入主机的EPROM中', '每一块网卡的物理地址在全世界是唯一的', 'C', NULL, 2, '数据链路层', '3');
INSERT INTO `multi_question` VALUES (10027, '计算机网络', '下列帧类型中，不属于HDLC帧类型的是（）', '信息帧', '确认帧', '监控帧', '无编号帧', 'B', NULL, 2, '数据链路层', '1');
INSERT INTO `multi_question` VALUES (10028, '计算机网络', '通过交换机连接的一组站点，关于它们的广播域和冲突域说法正确的是（）', '组成一个冲突域，但不是一个广播域', '组成一个广播域，但不是一个冲突域', '组成一个冲突域，也是一个广播域', '既不一个冲突域，也不是一个广播域', 'B', NULL, 2, '数据链路层', '3');
INSERT INTO `multi_question` VALUES (10029, '计算机网络', '数据链路层的数据单位是（）', '帧', '字节', '比特', '分组', 'A', NULL, 2, '数据链路层', '1');
INSERT INTO `multi_question` VALUES (10030, '计算机网络', 'LAN参考模型可分为物理层、（ ）', 'MAC，LLC等三层', 'LLC，MHS等三层', 'MAC，FTAM等三层', 'LLC，VT等三层', 'A', NULL, 2, '数据链路层', '3');
INSERT INTO `multi_question` VALUES (10031, '测试', '测试', 'A', 'B', 'C', 'D', 'B', '解析', 2, '测试', '4');
INSERT INTO `multi_question` VALUES (10032, '计算机网络', 'DNS 服务器和DHCP服务器的作用是（）', 'A', 'B', 'C', 'D', 'B', '哦解析', 2, '网络层', '2');
INSERT INTO `multi_question` VALUES (10033, '计算机网络', '21', '1', '1', '1', '1', 'A', '', 2, '12', '2');
INSERT INTO `multi_question` VALUES (10034, '数据库理论', '1', '1', '1', '1', '1', 'A', '1', 2, '1', '3');
INSERT INTO `multi_question` VALUES (10045, 't9', '下列哪个是函数极限lim(x→0)(sinx/x)的值？', '0', '1', '∞', '不存在', 'B', '根据重要极限公式，lim(x→0)(sinx/x)=1，这是微积分中的一个基本极限结果。', 2, '函数极限与连续性', '基础');
INSERT INTO `multi_question` VALUES (10046, 't9', '函数f(x)在点x0处连续的定义是什么？', 'lim(x→x0) f(x)存在', 'f(x0)存在', 'lim(x→x0) f(x)=f(x0)', 'f(x)在x0的邻域内有定义', 'C', '函数在点x0处连续需要满足三个条件：f(x0)存在，lim(x→x0) f(x)存在，且两者相等。选项C完整描述了连续性的定义。', 2, '函数极限与连续性', '中等');
INSERT INTO `multi_question` VALUES (10047, 't9', '下列哪个极限不存在？', 'lim(x→0) sin(1/x)', 'lim(x→0) x·sin(1/x)', 'lim(x→0) (sinx)/x', 'lim(x→0) x²', 'A', '当x→0时，sin(1/x)在-1和1之间无限振荡，没有确定的极限值。而其他选项的极限都存在：B为0，C为1，D为0。', 2, '函数极限与连续性', '中等');
INSERT INTO `multi_question` VALUES (10048, 't9', 'Which of the following words means \'a person who is studying at a university or college\'?', 'Professor', 'Student', 'Lecturer', 'Dean', 'B', 'The word \'student\' specifically refers to someone who is studying at a university or college, while the other options refer to academic staff or administrators.', 2, '大学英语', '中等');
INSERT INTO `multi_question` VALUES (10049, 't9', 'What is the correct past tense form of the verb \'to go\'?', 'goed', 'went', 'goed', 'going', 'B', 'The irregular verb \'to go\' has the past tense form \'went\', which must be memorized as it doesn\'t follow the regular -ed pattern.', 2, '大学英语', '简单');
INSERT INTO `multi_question` VALUES (10050, 't9', 'Which of the following words means \'a person who is studying at a university\'?', 'Professor', 'Student', 'Librarian', 'Dean', 'B', 'The word \'student\' refers to a person who is studying at a university or college, while the other options refer to different roles in an academic setting.', 2, '大学英语', 'Easy');
INSERT INTO `multi_question` VALUES (10051, 't9', 'What is the correct past tense form of the verb \'go\'?', 'goed', 'went', 'goes', 'going', 'B', 'The past tense of \'go\' is \'went\', which is an irregular verb form in English.', 2, '大学英语', 'Easy');
INSERT INTO `multi_question` VALUES (10052, 't9', '函数f(x) = (x^2 - 1)/(x - 1)在x=1处的极限是多少？', '0', '1', '2', '不存在', 'C', '将函数化简为f(x) = x + 1 (x≠1)，当x趋近于1时，f(x)趋近于2', 2, '函数极限与连续性', '中等');
INSERT INTO `multi_question` VALUES (10053, 't9', 'Which of the following words means \'a person who is studying at a university\'?', 'Professor', 'Student', 'Librarian', 'Dean', 'B', 'The word \'student\' refers to a person who is studying at a university or college, while the other options refer to different roles in an academic setting.', 2, '大学英语', 'Easy');
INSERT INTO `multi_question` VALUES (10054, 't9', 'What is the correct past tense form of the verb \'go\'?', 'goed', 'went', 'goes', 'going', 'B', 'The past tense of \'go\' is \'went\', which is an irregular verb form in English.', 2, '大学英语', 'Easy');
INSERT INTO `multi_question` VALUES (10055, 't9', '设函数f(x)在点x=a处可导，则以下哪个选项是f\'(a)的定义？', 'lim_{h→0} [f(a+h)-f(a)]/h', 'lim_{x→a} [f(x)-f(a)]/(x-a)', 'f(a+h)-f(a)在h=0时的值', 'f(x)在x=a处的函数值', 'A', '根据导数的定义，f\'(a)=lim_{h→0} [f(a+h)-f(a)]/h，这是导数的标准定义形式。选项B虽然等价，但不是最标准的定义形式。', 1, '导数与微分', '中等');
INSERT INTO `multi_question` VALUES (10056, 't9', '函数f(x) = x³在x=0处的导数是？', '0', '1', '3', '不存在', 'A', 'f\'(x) = 3x²，当x=0时，f\'(0) = 3×0² = 0', 1, '导数与微分', '中等');
INSERT INTO `multi_question` VALUES (10057, 't9', '函数f(x) = x³在x=0处的导数是？', '0', '1', '3', '不存在', 'A', 'f\'(x) = 3x²，代入x=0得f\'(0)=0', 1, '导数与微分', '中等');
INSERT INTO `multi_question` VALUES (10058, 't9', '设函数f(x)在点x0处可导，则f\'(x0)表示的是', '函数在x0处的函数值', '函数在x0处的切线斜率', '函数在x0处的二阶导数', '函数在x0处的积分值', 'B', '根据导数的几何意义，函数在某点的导数表示该点处切线的斜率。', 1, '导数与微分', '中等');

-- ----------------------------
-- Table structure for paper_manage
-- ----------------------------
DROP TABLE IF EXISTS `paper_manage`;
CREATE TABLE `paper_manage`  (
  `paper_id` int NULL DEFAULT NULL COMMENT '试卷编号',
  `question_type` int NULL DEFAULT NULL COMMENT '题目类型',
  `question_id` int NULL DEFAULT NULL COMMENT '题目编号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '试卷管理表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of paper_manage
-- ----------------------------
INSERT INTO `paper_manage` VALUES (1001, 1, 10013);
INSERT INTO `paper_manage` VALUES (1001, 1, 10005);
INSERT INTO `paper_manage` VALUES (1001, 1, 10001);
INSERT INTO `paper_manage` VALUES (1001, 1, 10004);
INSERT INTO `paper_manage` VALUES (1001, 1, 10000);
INSERT INTO `paper_manage` VALUES (1001, 1, 10016);
INSERT INTO `paper_manage` VALUES (1001, 1, 10032);
INSERT INTO `paper_manage` VALUES (1001, 1, 10025);
INSERT INTO `paper_manage` VALUES (1001, 1, 10030);
INSERT INTO `paper_manage` VALUES (1001, 1, 10017);
INSERT INTO `paper_manage` VALUES (1001, 1, 10027);
INSERT INTO `paper_manage` VALUES (1001, 1, 10023);
INSERT INTO `paper_manage` VALUES (1001, 1, 10014);
INSERT INTO `paper_manage` VALUES (1001, 1, 10009);
INSERT INTO `paper_manage` VALUES (1001, 1, 10008);
INSERT INTO `paper_manage` VALUES (1001, 1, 10011);
INSERT INTO `paper_manage` VALUES (1001, 1, 10010);
INSERT INTO `paper_manage` VALUES (1001, 1, 10021);
INSERT INTO `paper_manage` VALUES (1001, 1, 10022);
INSERT INTO `paper_manage` VALUES (1001, 1, 10026);
INSERT INTO `paper_manage` VALUES (1001, 2, 10017);
INSERT INTO `paper_manage` VALUES (1001, 2, 10012);
INSERT INTO `paper_manage` VALUES (1001, 2, 10004);
INSERT INTO `paper_manage` VALUES (1001, 2, 10005);
INSERT INTO `paper_manage` VALUES (1001, 2, 10003);
INSERT INTO `paper_manage` VALUES (1001, 2, 10008);
INSERT INTO `paper_manage` VALUES (1001, 2, 10020);
INSERT INTO `paper_manage` VALUES (1001, 2, 10013);
INSERT INTO `paper_manage` VALUES (1001, 2, 10006);
INSERT INTO `paper_manage` VALUES (1001, 2, 10015);
INSERT INTO `paper_manage` VALUES (1001, 3, 10002);
INSERT INTO `paper_manage` VALUES (1001, 3, 10009);
INSERT INTO `paper_manage` VALUES (1001, 3, 10003);
INSERT INTO `paper_manage` VALUES (1001, 3, 10005);
INSERT INTO `paper_manage` VALUES (1001, 3, 10004);
INSERT INTO `paper_manage` VALUES (1001, 3, 10012);
INSERT INTO `paper_manage` VALUES (1001, 3, 10011);
INSERT INTO `paper_manage` VALUES (1001, 3, 10006);
INSERT INTO `paper_manage` VALUES (1001, 3, 10008);
INSERT INTO `paper_manage` VALUES (1001, 3, 10001);
INSERT INTO `paper_manage` VALUES (1001, 1, 10033);
INSERT INTO `paper_manage` VALUES (1002, 1, 10034);
INSERT INTO `paper_manage` VALUES (1002, 2, 10029);
INSERT INTO `paper_manage` VALUES (1002, 2, 10030);
INSERT INTO `paper_manage` VALUES (1002, 3, 10017);
INSERT INTO `paper_manage` VALUES (1009, 1, 10035);
INSERT INTO `paper_manage` VALUES (1001, 3, 10018);
INSERT INTO `paper_manage` VALUES (1014, 2, 10031);
INSERT INTO `paper_manage` VALUES (1015, 1, 10043);
INSERT INTO `paper_manage` VALUES (1015, 1, 10044);
INSERT INTO `paper_manage` VALUES (1015, 1, 10045);
INSERT INTO `paper_manage` VALUES (1015, 1, 10046);
INSERT INTO `paper_manage` VALUES (1015, 1, 10047);
INSERT INTO `paper_manage` VALUES (1015, 1, 10048);
INSERT INTO `paper_manage` VALUES (1015, 1, 10049);
INSERT INTO `paper_manage` VALUES (1015, 1, 10050);
INSERT INTO `paper_manage` VALUES (1015, 1, 10051);
INSERT INTO `paper_manage` VALUES (1015, 1, 10052);
INSERT INTO `paper_manage` VALUES (1015, 1, 10053);
INSERT INTO `paper_manage` VALUES (1015, 1, 10054);
INSERT INTO `paper_manage` VALUES (1015, 1, 10055);
INSERT INTO `paper_manage` VALUES (1015, 1, 10056);
INSERT INTO `paper_manage` VALUES (1015, 1, 10057);
INSERT INTO `paper_manage` VALUES (1015, 2, 10039);
INSERT INTO `paper_manage` VALUES (1015, 3, 10025);
INSERT INTO `paper_manage` VALUES (1015, 1, 10058);

-- ----------------------------
-- Table structure for replay
-- ----------------------------
DROP TABLE IF EXISTS `replay`;
CREATE TABLE `replay`  (
  `message_id` int NULL DEFAULT NULL COMMENT '留言编号',
  `replay_id` int NOT NULL AUTO_INCREMENT COMMENT '回复编号',
  `replay` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `replay_time` date NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`replay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '回复表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of replay
-- ----------------------------
INSERT INTO `replay` VALUES (26, 3, '好呀，我来了，你别跑！', '2019-03-18');
INSERT INTO `replay` VALUES (22, 4, '心疼你2秒钟', '2019-03-18');
INSERT INTO `replay` VALUES (25, 5, '我也要变强', '2019-03-19');
INSERT INTO `replay` VALUES (25, 6, '俺也一样', '2019-03-19');
INSERT INTO `replay` VALUES (21, 7, '既然这样，那就迎男而上吧', '2019-03-19');
INSERT INTO `replay` VALUES (16, 8, '那条街确实没什么东西可以吃了。。。', '2019-03-19');
INSERT INTO `replay` VALUES (15, 9, '咸鱼其实还可以吃，而你,emmmm', '2019-03-19');
INSERT INTO `replay` VALUES (21, 11, '我不怕人多', '2019-03-19');
INSERT INTO `replay` VALUES (20, 12, '是嘞，还行。', '2019-03-19');
INSERT INTO `replay` VALUES (26, 13, '我也爱你ε=(´ο｀*)))唉', '2019-03-19');
INSERT INTO `replay` VALUES (27, 14, '你这个坏孩子', '2019-03-31');
INSERT INTO `replay` VALUES (33, 18, '是的，今天是周一。', '2019-04-14');
INSERT INTO `replay` VALUES (34, 19, '1111', '2019-04-16');
INSERT INTO `replay` VALUES (34, 20, '2222', '2019-04-16');
INSERT INTO `replay` VALUES (35, 21, '666', '2019-09-05');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `score_id` int NOT NULL AUTO_INCREMENT COMMENT '分数编号',
  `exam_code` int NULL DEFAULT NULL COMMENT '考试编号',
  `student_id` int NULL DEFAULT NULL COMMENT '学号',
  `subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程名称',
  `pt_score` int NULL DEFAULT NULL COMMENT '平时成绩',
  `et_score` int NULL DEFAULT NULL COMMENT '期末成绩',
  `score` int NULL DEFAULT NULL COMMENT '总成绩',
  `answer_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '答题日期',
  PRIMARY KEY (`score_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '成绩管理表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (4, 20190001, 20154084, '计算机网络', NULL, 70, NULL, '2019-04-03');
INSERT INTO `score` VALUES (14, 20190002, 20154084, '数据库理论', NULL, 78, NULL, '2019-04-20');
INSERT INTO `score` VALUES (15, 20190002, 20154084, '数据库理论', NULL, 80, NULL, '2019-04-20');
INSERT INTO `score` VALUES (16, 20190002, 20154084, '数据库理论', NULL, 83, NULL, '2019-04-20');
INSERT INTO `score` VALUES (17, 20190001, 20154001, '计算机网络', NULL, 74, NULL, '2019-04-13');
INSERT INTO `score` VALUES (18, 20190001, 20154001, '计算机网络', NULL, 70, NULL, '2019-04-10');
INSERT INTO `score` VALUES (19, 20190001, 20155003, '计算机网络', NULL, 86, NULL, '2019-04-14');
INSERT INTO `score` VALUES (20, 20190001, 20155007, '计算机网络', NULL, 90, NULL, '2019-04-11');
INSERT INTO `score` VALUES (21, 20190001, 20155007, '计算机网络', NULL, 92, NULL, '2019-04-12');
INSERT INTO `score` VALUES (22, 20190001, 20155008, '计算机网络', NULL, 80, NULL, '2019-04-12');
INSERT INTO `score` VALUES (23, 20190001, 20155003, '计算机网络', NULL, 90, NULL, '2019-04-13');
INSERT INTO `score` VALUES (24, 20190001, 20155008, '计算机网络', NULL, 88, NULL, '2019-04-14');
INSERT INTO `score` VALUES (27, 20190001, 20154084, '计算机网络', NULL, 80, NULL, '2019-04-25');
INSERT INTO `score` VALUES (30, 20190001, 20154084, '计算机网络', NULL, 0, NULL, '2019-04-29');
INSERT INTO `score` VALUES (31, 20190001, 20154084, '计算机网络', NULL, 0, NULL, '2019-09-06');
INSERT INTO `score` VALUES (32, 20190001, 20154084, '计算机网络', NULL, 0, NULL, '2025-10-16');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `student_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `grade` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '年级',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '专业',
  `clazz` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级',
  `institute` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电子邮件',
  `pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `card_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证号',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `role` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '2' COMMENT '角色(0管理员，1教师，2学生)',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20155009 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '学生信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (20154001, '隔壁老王', '2015', '计算机科学与技术', '2', '软件工程学院', '13585439532', 'gblw@163.com', '123456', '3412312', '男', '2');
INSERT INTO `student` VALUES (20154084, '大咸鱼', '2015', '计算机科学与技术', '2', '软件工程学院', '13658377857', '13658377857@sina.cn', '123456', '124123124535', '男', '2');
INSERT INTO `student` VALUES (20155003, '张大宝', '2015', '信息工程', '1', '软件工程学院', '15583829425', '15583829425@163.com', '123456', '3242342', '男', '2');
INSERT INTO `student` VALUES (20155007, '翠花', '2015', '网络工程', '1', '软件工程学院', '18734538457', '18734538457@163.com', '123456', '2423423', '女', '2');
INSERT INTO `student` VALUES (20155008, '小王', '2015', '信息工程', '2', '软件工程学院', '15523619564', '15523619564@163.com', '123456', '500234199704022353', '男', '2');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `teacher_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `institute` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院',
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `card_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证号',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职称',
  `role` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色（0管理员，1教师，2学生）',
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '教师信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (20081001, '张', '软件工程学院', '男', '13598458442', '13598458442@163.com', '123456', '423423283498', '讲师', '1');
INSERT INTO `teacher` VALUES (20081002, '王大志', '软件工程学院', '男', '1231221312', '1231221312@163.com', '123456', '24241234', '讲师', '1');

SET FOREIGN_KEY_CHECKS = 1;
