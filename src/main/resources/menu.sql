/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.104_3306
Source Server Version : 50627
Source Host           : 192.168.0.104:3306
Source Database       : aaatest

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2020-02-26 17:31:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', null, '0');
INSERT INTO `menu` VALUES ('2', '平台监控', null, '0');
INSERT INTO `menu` VALUES ('1001', '用户管理', '/user', '1');
INSERT INTO `menu` VALUES ('1002', '角色管理', '/role', '1');
INSERT INTO `menu` VALUES ('1003', '单位管理', '/employer', '1');
INSERT INTO `menu` VALUES ('2001', '系统监控', '/system/monitor', '2');
INSERT INTO `menu` VALUES ('2002', '数据监控', '/data/monitor', '2');
