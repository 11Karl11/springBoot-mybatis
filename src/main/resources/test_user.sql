/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.104_3306
Source Server Version : 50627
Source Host           : 192.168.0.104:3306
Source Database       : aaatest

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2020-01-20 18:08:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test_user
-- ----------------------------
DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
