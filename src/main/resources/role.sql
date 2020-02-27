/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.104_3306
Source Server Version : 50627
Source Host           : 192.168.0.104:3306
Source Database       : aaatest

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2020-02-27 11:33:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '射手', '22');
