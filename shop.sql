/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : shop1

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-04-16 15:16:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shouhuoren` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `isdefault` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', 'afdfdf', '13678763456', 'dfdfdfdf', '20', '否');
INSERT INTO `t_address` VALUES ('2', 'dfdf', '13678763456', 'dfdf', '20', '是');
INSERT INTO `t_address` VALUES ('3', 'aaaa', '11111', 'dsfdfdfdf', '20', '否');

-- ----------------------------
-- Table structure for `t_goods_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_info`;
CREATE TABLE `t_goods_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(20) DEFAULT NULL,
  `goods_description` varchar(100) DEFAULT NULL,
  `goods_pic` varchar(200) DEFAULT NULL,
  `goods_price` double(20,2) DEFAULT NULL,
  `goods_stock` int(11) DEFAULT NULL,
  `goods_price_off` double(20,2) DEFAULT NULL,
  `goods_discount` double(11,2) DEFAULT NULL,
  `goods_fatherid` int(11) DEFAULT NULL,
  `goods_parentid` int(11) DEFAULT NULL,
  `isdelete` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods_info
-- ----------------------------
INSERT INTO `t_goods_info` VALUES ('1', '铜锣烧aa', '回头客铜锣烧160g红豆味西式糕点手撕小口袋面包早餐 好好吃哦！aaaaaaaaaaaa', 'zhuomian.png', '6.50', '0', '0.00', '0.00', '7', '1', '否');
INSERT INTO `t_goods_info` VALUES ('2', '瑞士卷蛋糕', '达利园 瑞士卷蛋糕（芒果味）240g/袋（12枚）', 'ruishi.jpg', '10.90', '0', '0.00', '0.00', '8', '1', '否');
INSERT INTO `t_goods_info` VALUES ('3', '奥利奥饼干', '奥利奥巧克力味夹心 12*3片促销装 325g+65g', 'aoliao.jpg', '19.75', '208', '15.80', '0.80', '9', '2', '否');
INSERT INTO `t_goods_info` VALUES ('4', '太平饼干', '亿滋 饼干太平梳打奶盐味100g办公室休闲零食茶点', 'taiping.jpg', '3.30', '23', '3.30', '1.00', '9', '2', '否');
INSERT INTO `t_goods_info` VALUES ('5', '乐事薯片', '百事食品 乐事薯片美国经典原味145克 膨化休闲零食', 'leshi.jpg', '9.90', '67', '9.90', '1.00', '10', '2', '否');
INSERT INTO `t_goods_info` VALUES ('6', '蒸奶香蛋糕', '港荣 蒸奶香蛋糕 1kg/箱 整箱装', 'zhengnaixiang.jpg', '38.20', '1100', '38.20', '1.00', '7', '1', '否');
INSERT INTO `t_goods_info` VALUES ('7', '蔓越莓西饼', '巴拿米 蔓越莓西饼 170g/袋', 'xibing.jpg', '10.90', '278', '10.90', '1.00', '8', '1', '否');
INSERT INTO `t_goods_info` VALUES ('8', '凤梨酥', '百草味 凤梨酥 300g/盒', 'fenglisu.jpg', '14.50', '111', '14.50', '1.00', '8', '1', '否');
INSERT INTO `t_goods_info` VALUES ('9', '麻薯', '良品铺子 手造麻薯 抹茶味 150g/袋 X 2', 'mashu.jpg', '12.50', '323', '12.50', '1.00', '8', '1', '否');
INSERT INTO `t_goods_info` VALUES ('10', '核桃饼', '好吃点 香脆核桃饼 108g/袋', 'haochidian.jpg', '4.40', '434', '4.40', '1.00', '9', '2', '否');
INSERT INTO `t_goods_info` VALUES ('11', '威化饼', '嘉顿 柠檬威化 200g/袋', 'jiadun.jpg', '7.50', '4333', '7.50', '1.00', '9', '2', '否');
INSERT INTO `t_goods_info` VALUES ('12', '大波浪薯片', '乐事 大波浪薯片 香脆烤鸡翅味 70g/袋', 'dalangshupian.jpg', '3.90', '344', '3.90', '1.00', '10', '2', '否');
INSERT INTO `t_goods_info` VALUES ('14', '热狗', 'Smithfield 双汇史密斯 美式香肠 热狗肠火腿肠烤肠香肠 熏肠 396克*3袋', 'regou.jpg', '79.90', '50', '79.90', '1.00', '12', '3', '否');
INSERT INTO `t_goods_info` VALUES ('15', '牛肉干', '淘豆 五香牛肉干100g/袋', 'niurougan.jpg', '19.90', '100', '19.90', '1.00', '11', '3', '否');
INSERT INTO `t_goods_info` VALUES ('16', '猪肉脯', '百草味 精制猪肉脯 200g/袋', 'zhurugan.jpg', '17.90', '5000', '14.30', '0.80', '12', '3', '否');
INSERT INTO `t_goods_info` VALUES ('23', '梅尼耶干蛋糕', '盼盼 梅尼耶干蛋糕1000g箱装 奶香味干蛋糕饼干 正品茶点零食 美味早餐下午茶', 'meiniyegan.jpg', '49.90', '1000', '49.90', '1.00', '7', '1', '否');
INSERT INTO `t_goods_info` VALUES ('24', '好丽友', '好丽友 派 巧克力味涂饰蛋类芯饼 680g/盒 20枚', 'haoliyou.jpg', '26.50', '500', '26.50', '1.00', '7', '1', '否');
INSERT INTO `t_goods_info` VALUES ('25', '乐事青瓜薯片', '乐事 无限薯片（清新清爽翡翠黄瓜味）104g/筒 X 3', 'leshiqinggua.jpg', '19.50', '123', '19.50', '1.00', '10', '2', '否');
INSERT INTO `t_goods_info` VALUES ('26', '可比克薯片', '可比克 薯片 烧烤味 45g/罐', 'kebike.jpg', '4.20', '356', '4.20', '1.00', '10', '2', '否');

-- ----------------------------
-- Table structure for `t_goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gtype_name` varchar(30) DEFAULT NULL,
  `gtype_parentid` int(11) DEFAULT NULL,
  `gtype_pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods_type
-- ----------------------------
INSERT INTO `t_goods_type` VALUES ('1', '蛋糕类', '0', 'cake.png');
INSERT INTO `t_goods_type` VALUES ('2', '饼干类', '0', 'cookies.png');
INSERT INTO `t_goods_type` VALUES ('3', '熟食类', '0', 'meat.png');
INSERT INTO `t_goods_type` VALUES ('4', '素食类', '0', 'bamboo.png');
INSERT INTO `t_goods_type` VALUES ('5', '坚果类', '0', 'nut.png');
INSERT INTO `t_goods_type` VALUES ('6', '糖果类', '0', 'candy.png');
INSERT INTO `t_goods_type` VALUES ('7', '蛋糕', '1', null);
INSERT INTO `t_goods_type` VALUES ('8', '点心', '1', null);
INSERT INTO `t_goods_type` VALUES ('9', '饼干', '2', null);
INSERT INTO `t_goods_type` VALUES ('10', '薯片', '2', null);
INSERT INTO `t_goods_type` VALUES ('11', '牛肉干', '3', null);
INSERT INTO `t_goods_type` VALUES ('12', '猪肉干', '3', null);
INSERT INTO `t_goods_type` VALUES ('16', '洗漱用品', '16', null);

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL,
  `o_sendtype` varchar(20) DEFAULT NULL,
  `o_paytype` varchar(20) DEFAULT NULL,
  `o_paycount` double(20,0) DEFAULT NULL,
  `o_orderdate` date DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `o_shperson` varchar(20) DEFAULT NULL,
  `o_shphone` varchar(20) DEFAULT NULL,
  `o_shaddress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('201641431', '申通', '支付宝', '120', '2016-11-03', '3', 'afdfdf', '13678763456', '\r\n													dfdfdfdf\r\n											');
INSERT INTO `t_order` VALUES ('201710041', '申通', '微信', '114', '2017-03-29', '3', 'afdfdf', '13678763456', '\r\n													dfdfdfdf\r\n											');
INSERT INTO `t_order` VALUES ('201723242', '申通', '微信', '39', '2017-03-29', '3', 'aaaa', '11111', '\r\n													dsfdfdfdf\r\n											');
INSERT INTO `t_order` VALUES ('201740400', '', '', '59', '2017-03-29', '3', '', '', '');
INSERT INTO `t_order` VALUES ('201744443', '圆通', '银联', '62', '2017-03-29', '3', 'dfdf', '13678763456', '\r\n												dfdf\r\n										');

-- ----------------------------
-- Table structure for `t_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `goods_date` date DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `o_orderid` int(11) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `goodsname` varchar(20) DEFAULT NULL,
  `goodsprice` double(20,2) DEFAULT NULL,
  `goods_description` varchar(100) DEFAULT NULL,
  `goodsnum` int(20) DEFAULT NULL,
  `goodspic` varchar(100) DEFAULT NULL,
  `goods_total_price` double(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ORDER` (`o_orderid`),
  CONSTRAINT `FK_ORDER` FOREIGN KEY (`o_orderid`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES (null, '1', '201641431', '1', '铜锣烧', '6.50', '回头客铜锣烧160g红豆味西式糕点手撕小口袋面包早餐 好好吃哦！', '4', 'tls.jpg', '20.80');
INSERT INTO `t_order_detail` VALUES (null, '2', '201641431', '15', '牛肉干', '19.90', '淘豆 五香牛肉干100g/袋', '5', 'niurougan.jpg', '99.50');
INSERT INTO `t_order_detail` VALUES (null, '3', '201723242', '2', '瑞士卷蛋糕', '10.90', '达利园 瑞士卷蛋糕（芒果味）240g/袋（12枚）', '4', 'ruishi.jpg', '39.24');
INSERT INTO `t_order_detail` VALUES (null, '4', '201744443', '9', '麻薯', '12.50', '良品铺子 手造麻薯 抹茶味 150g/袋 X 2', '5', 'mashu.jpg', '62.50');
INSERT INTO `t_order_detail` VALUES (null, '5', '201710041', '9', '麻薯', '12.50', '良品铺子 手造麻薯 抹茶味 150g/袋 X 2', '6', 'mashu.jpg', '75.00');
INSERT INTO `t_order_detail` VALUES (null, '6', '201710041', '2', '瑞士卷蛋糕', '10.90', '达利园 瑞士卷蛋糕（芒果味）240g/袋（12枚）', '4', 'ruishi.jpg', '39.24');
INSERT INTO `t_order_detail` VALUES (null, '7', '201740400', '2', '瑞士卷蛋糕', '10.90', '达利园 瑞士卷蛋糕（芒果味）240g/袋（12枚）', '6', 'ruishi.jpg', '58.86');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `is_admin` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('3', 'cc', '123456', '女', '1585646732', 'bbbb@qq.com', '是');
INSERT INTO `t_user` VALUES ('7', 'aa', '123456', '男', '13678763456', 'ccc@qq.com', '否');
