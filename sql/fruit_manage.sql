/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : fruit_manage

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-06-13 21:32:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accessory
-- ----------------------------
DROP TABLE IF EXISTS `accessory`;
CREATE TABLE `accessory` (
  `accessoryid` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '附属品ID',
  `fruitid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '商品ID',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '附属品名称',
  `price` decimal(10,2) NOT NULL COMMENT '附属品价格',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`accessoryid`),
  KEY `fruitid` (`fruitid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of accessory
-- ----------------------------
INSERT INTO `accessory` VALUES ('213231', '3234', '包装袋', '0.10', '2019-06-05 17:42:26');
INSERT INTO `accessory` VALUES ('2658721f62014b1c82502c7fb8866c65', '25f6cd5c25f74f4cb045911bcb56f148', '纸箱', '2.00', '2019-06-08 16:43:17');
INSERT INTO `accessory` VALUES ('325125', '3234', '纸板盒', '0.30', '2019-02-07 17:43:00');
INSERT INTO `accessory` VALUES ('413099a719ed46bbbea53c0bfc1b4acd', '3234', '盒子', '4.00', '2019-06-05 19:30:32');
INSERT INTO `accessory` VALUES ('835c80978cbd4239a0a1f15bbb1a4eab', '3234', '保鲜膜', '0.60', '2019-06-05 19:29:31');
INSERT INTO `accessory` VALUES ('98468c62209e4eaeae17156dc22debe5', '25f6cd5c25f74f4cb045911bcb56f148', '盒子', '4.00', '2019-06-08 16:43:23');

-- ----------------------------
-- Table structure for commodities
-- ----------------------------
DROP TABLE IF EXISTS `commodities`;
CREATE TABLE `commodities` (
  `fruitid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '商品ID',
  `fruitname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '水果名称',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `locality` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '产地',
  `createtime` datetime NOT NULL COMMENT '录单时间',
  PRIMARY KEY (`fruitid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of commodities
-- ----------------------------
INSERT INTO `commodities` VALUES ('25f6cd5c25f74f4cb045911bcb56f148', '葡萄', '2.20', '新疆', '2019-06-05 01:15:16');
INSERT INTO `commodities` VALUES ('3234', '火龙果', '6.68', '浙江省绍兴市', '2017-09-13 20:15:43');
INSERT INTO `commodities` VALUES ('5f5c51c001ee4bb9aa27f3df2046a0ba', '梨子', '3.20', '南京', '2019-06-09 01:34:40');
INSERT INTO `commodities` VALUES ('b463332f1a7b46728b653ffaf61c50f0', '梨子', '3.20', '南京', '2019-06-09 01:34:35');
INSERT INTO `commodities` VALUES ('d582b68bf9c94a00a8d32b3ff12f55f1', '苹果', '5.00', '北京', '2019-06-05 02:21:26');
INSERT INTO `commodities` VALUES ('d81ea785224c480d8c1183b00b0c1c09', '苹果', '4.00', '北京', '2019-06-05 02:22:41');
INSERT INTO `commodities` VALUES ('da17f3587bdf4b2c9288d652e8b58562', '梨子', '3.20', '南京', '2019-06-09 01:34:24');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `contractid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '合同ID',
  `barcode` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '合同号',
  `type` int(1) NOT NULL COMMENT '运输类型',
  `retailerid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '零售商ID',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`contractid`),
  KEY `retailerid` (`retailerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of contract
-- ----------------------------

-- ----------------------------
-- Table structure for middletab
-- ----------------------------
DROP TABLE IF EXISTS `middletab`;
CREATE TABLE `middletab` (
  `middleid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '中间表ID',
  `contractid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '合同ID',
  `fruitid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '商品ID',
  `number` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`middleid`),
  KEY `contractid` (`contractid`),
  KEY `fruitid` (`fruitid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of middletab
-- ----------------------------

-- ----------------------------
-- Table structure for retailer
-- ----------------------------
DROP TABLE IF EXISTS `retailer`;
CREATE TABLE `retailer` (
  `retailerid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '零售商ID',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '零售商姓名',
  `telephone` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '零售商电话',
  `address` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '零售商地址',
  `status` int(1) NOT NULL COMMENT '状态（0/1）',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`retailerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of retailer
-- ----------------------------
INSERT INTO `retailer` VALUES ('231231231231', '蒋家骏', '13666666666', '上海市宝山区', '1', '2019-06-04 17:10:24');
INSERT INTO `retailer` VALUES ('4654546565465462', '蒋虎子', '13888888888', '上海市嘉定区', '0', '2019-06-04 16:59:06');
INSERT INTO `retailer` VALUES ('4654546565465465', '石恩华', '13777777777', '上海市普陀区', '0', '2019-06-04 17:10:32');
INSERT INTO `retailer` VALUES ('986c83e0-f476-4db7-8296-2a7f46992418', '张三', '13722222222', '上海宝山区', '0', '2019-06-04 20:04:16');
INSERT INTO `retailer` VALUES ('c2613c793a5742d1bb7dd50e91916ded', '李四', '13811111111', '上海市普陀区', '0', '2019-06-04 20:08:42');
INSERT INTO `retailer` VALUES ('c6b899350e444a789160eedf357142a9', '王五', '13922222222', '福建省厦门市', '1', '2019-06-04 20:11:26');
INSERT INTO `retailer` VALUES ('e1af20c9aa8242d3a73189826954c9e3', '阿斯蒂芬', '13732232323', '福建省福州市', '1', '2019-06-04 20:13:08');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `username` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '账号',
  `password` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `telephone` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '手机号码',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0c56bbb78bac4b338a9af8a9de205ce7', '哈哈', '1234', '1234', '13111111111');
INSERT INTO `user` VALUES ('1c057a8ef4bc41d69f7aa6b3227114a5', 'nancy', '1234', 'nancy', '13788888888');
INSERT INTO `user` VALUES ('2d0279e8cf7c4d5287d212433df8bf87', '3', '3', '欧阳锋', '13811111111');
INSERT INTO `user` VALUES ('3af57d0545766ec940d2c32a6567cc06ae5', 'jack', '1234', '张三', '15588888888');
INSERT INTO `user` VALUES ('4189262ff14843b983a9d0cbe20faa39', '22', '22', '22', '13222222222');
INSERT INTO `user` VALUES ('4c540a0758f94b278728e40698a72ad2', '2', '2', '王五', '13666666666');
INSERT INTO `user` VALUES ('53bbb9ba14bd4df984f1b21baa200843', '1', '1', '1', '13888888888');
INSERT INTO `user` VALUES ('9fb46559a3ab4b2598e7f97cd1c1c562', '12', '12', '3', '13411111111');
INSERT INTO `user` VALUES ('a7590c84dab84f079965d58e4301d4a9', 'jane', '1234', '李四', '13411111111');
