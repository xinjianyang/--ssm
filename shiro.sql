/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-01 16:44:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('2', 'xinjian', '111111', '2018-02-28 16:03:33', null);
INSERT INTO `account` VALUES ('3', 'qqq', '111111', '2018-02-28 16:09:05', null);
INSERT INTO `account` VALUES ('4', 'www', '111111', '2018-02-28 16:09:15', null);
INSERT INTO `account` VALUES ('5', 'eee', '111111', '2018-02-28 16:09:21', null);

-- ----------------------------
-- Table structure for account_role
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `account_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`account_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES ('2', '1');
INSERT INTO `account_role` VALUES ('3', '2');
INSERT INTO `account_role` VALUES ('4', '3');
INSERT INTO `account_role` VALUES ('5', '4');
INSERT INTO `account_role` VALUES ('6', '5');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'accountAdd', '2018-02-28 16:13:32', null);
INSERT INTO `permission` VALUES ('2', 'roleAdd', '2018-02-28 16:13:41', null);
INSERT INTO `permission` VALUES ('3', 'permissionAdd', '2018-02-28 16:13:52', null);
INSERT INTO `permission` VALUES ('4', 'dsfsaf', '2018-03-01 16:23:57', null);
INSERT INTO `permission` VALUES ('5', 'qqqqq', '2018-03-01 16:25:35', null);
INSERT INTO `permission` VALUES ('6', 'wwwww', '2018-03-01 16:27:57', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '2018-02-28 16:10:01', null);
INSERT INTO `role` VALUES ('2', 'add', '2018-02-28 16:10:28', null);
INSERT INTO `role` VALUES ('3', 'delete', '2018-02-28 16:10:38', null);
INSERT INTO `role` VALUES ('4', 'update', '2018-02-28 16:10:45', null);
INSERT INTO `role` VALUES ('5', 'select', '2018-02-28 16:10:49', null);
INSERT INTO `role` VALUES ('6', 'add+update', '2018-02-28 16:11:11', null);
INSERT INTO `role` VALUES ('7', 'select+update', '2018-02-28 16:11:34', null);
INSERT INTO `role` VALUES ('8', 'select+delete', '2018-02-28 16:11:42', null);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('1', '2');
INSERT INTO `role_permission` VALUES ('1', '3');
