/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : sign

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-07-31 18:22:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `mid` int(10) NOT NULL AUTO_INCREMENT,
  `mname` varchar(100) NOT NULL,
  `mdesc` varchar(100) DEFAULT NULL,
  `murl` varchar(100) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '签到签退', null, 'main/right.jsp');
INSERT INTO `menu` VALUES ('2', '查看个人信息', null, 'common/userInfo.jsp');
INSERT INTO `menu` VALUES ('3', '修改密码', null, 'common/updatePwd.jsp');
INSERT INTO `menu` VALUES ('4', '查看小组信息', null, 'group?oper=groupInfo');
INSERT INTO `menu` VALUES ('5', '查看班级信息', null, '');
INSERT INTO `menu` VALUES ('6', '管理学生信息', null, '');
INSERT INTO `menu` VALUES ('7', '添加学生', null, '');
INSERT INTO `menu` VALUES ('8', '查看班级签到信息', null, '');

-- ----------------------------
-- Table structure for rm
-- ----------------------------
DROP TABLE IF EXISTS `rm`;
CREATE TABLE `rm` (
  `rid` int(10) NOT NULL,
  `mid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rm
-- ----------------------------
INSERT INTO `rm` VALUES ('1', '1');
INSERT INTO `rm` VALUES ('1', '2');
INSERT INTO `rm` VALUES ('1', '3');
INSERT INTO `rm` VALUES ('2', '1');
INSERT INTO `rm` VALUES ('2', '2');
INSERT INTO `rm` VALUES ('2', '3');
INSERT INTO `rm` VALUES ('2', '4');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(10) NOT NULL AUTO_INCREMENT,
  `rname` varchar(100) NOT NULL,
  `rdesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '学生', null);
INSERT INTO `role` VALUES ('2', '组长', null);
INSERT INTO `role` VALUES ('3', '班长', null);
INSERT INTO `role` VALUES ('4', '管理员', null);

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `unumber` int(10) NOT NULL,
  `sintime` varchar(100) DEFAULT NULL,
  `sinstatus` char(2) DEFAULT NULL,
  `souttime` varchar(100) DEFAULT NULL,
  `soutstatus` char(2) DEFAULT NULL,
  `sdate` varchar(100) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES ('9', '20170729', '15:4:14', '1', '17:33:41', '1', '2017-7-31');
INSERT INTO `sign` VALUES ('10', '20170731', '18:5:42', '1', '18:5:44', '0', '2017-7-31');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `unumber` int(10) NOT NULL,
  `uname` varchar(100) NOT NULL,
  `upwd` varchar(50) NOT NULL,
  `usex` varchar(10) NOT NULL,
  `uage` int(3) DEFAULT NULL,
  `uaddress` varchar(100) DEFAULT NULL,
  `rid` int(10) NOT NULL,
  `pnumber` int(10) NOT NULL,
  PRIMARY KEY (`unumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('20170729', 'admin', 'admin', '男', '22', '北京', '1', '20170731');
INSERT INTO `user` VALUES ('20170731', 'haha', 'haha', '男', '32', '北京', '2', '0');
