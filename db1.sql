/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2020-07-26 10:51:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mytext_user
-- ----------------------------
DROP TABLE IF EXISTS `mytext_user`;
CREATE TABLE `mytext_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mytext_user
-- ----------------------------
INSERT INTO `mytext_user` VALUES ('1', '213asdf');
INSERT INTO `mytext_user` VALUES ('2', 'asdf');
INSERT INTO `mytext_user` VALUES ('3', 'assfg');
