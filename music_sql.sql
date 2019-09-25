/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : db_music

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 25/09/2019 21:31:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_content
-- ----------------------------
DROP TABLE IF EXISTS `t_content`;
CREATE TABLE `t_content`  (
  `cid` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) NULL DEFAULT NULL,
  `mid` int(8) NULL DEFAULT NULL,
  `content` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  CONSTRAINT `t_content_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_content_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `t_music` (`mid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_content
-- ----------------------------
INSERT INTO `t_content` VALUES (1, 1, 5, ' 也许你现在仍然是一个人吃饭，一个人看电影，一个人发呆，一个人睡觉，一个人等天明。 然而你却能一个人吃饭，一个人看电影，一个人发呆，一个人睡觉，一个人等天明。很多人离开另外一个人， 就没有自己。而你却能够一个人，等天明。你的孤独，虽败犹荣。', '2019-09-24 00:00:00');
INSERT INTO `t_content` VALUES (2, 1, 5, 'Till you showed me what your all about', '2019-09-24 22:52:10');

-- ----------------------------
-- Table structure for t_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluate`;
CREATE TABLE `t_evaluate`  (
  `eid` int(8) NOT NULL AUTO_INCREMENT,
  `mid` int(8) NULL DEFAULT NULL,
  `uid` int(8) NULL DEFAULT NULL,
  `evaluate` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`eid`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `t_evaluate_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `t_music` (`mid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_evaluate_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_evaluate
-- ----------------------------
INSERT INTO `t_evaluate` VALUES (2, 5, 1, 0);

-- ----------------------------
-- Table structure for t_music
-- ----------------------------
DROP TABLE IF EXISTS `t_music`;
CREATE TABLE `t_music`  (
  `mid` int(8) NOT NULL AUTO_INCREMENT,
  `music_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upload_user` int(8) NULL DEFAULT NULL,
  `upload_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  INDEX `upload_user`(`upload_user`) USING BTREE,
  CONSTRAINT `t_music_ibfk_1` FOREIGN KEY (`upload_user`) REFERENCES `t_user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_music
-- ----------------------------
INSERT INTO `t_music` VALUES (1, 'We Dont Talk Anymore', '/upload/music/b8d4b205-0174-425c-b411-33fd6f79508e.mp3', 1, '2019-09-24 22:58:56');
INSERT INTO `t_music` VALUES (9, 'Varien - Future Funk', '/upload/music/424777b0-3205-4739-bcab-35d1f71b540b.mp3', 1, '2019-09-24 15:11:22');

-- ----------------------------
-- Table structure for t_music_info
-- ----------------------------
DROP TABLE IF EXISTS `t_music_info`;
CREATE TABLE `t_music_info`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `mid` int(8) NULL DEFAULT NULL,
  `musicImage` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clickRate` int(8) NULL DEFAULT NULL,
  `downloads` int(8) NULL DEFAULT NULL,
  `user_like` int(8) NULL DEFAULT NULL,
  `user_dislike` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  CONSTRAINT `t_music_info_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `t_music` (`mid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_music_info
-- ----------------------------
INSERT INTO `t_music_info` VALUES (1, 1, '/images/m1.jpg', 2, 0, 0, 0);
INSERT INTO `t_music_info` VALUES (7, 9, '/images/m0.jpg', 2, 0, 0, 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` int(8) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPassword` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userImage` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userMood` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userGrade` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'test@qq.com', '1', 'wcc', '/images/m0.jpg', '笑', 0);
INSERT INTO `t_user` VALUES (3, '2947872572@qq.com', '1', '首次测试', '/images/m0.jpg', '太阳当空照，花儿对我笑', 0);
INSERT INTO `t_user` VALUES (4, '11@qq.com', '11', '测试用户', '/images/m0.jpg', '太阳当空照，花儿对我笑', 0);

-- ----------------------------
-- Table structure for t_user_grade
-- ----------------------------
DROP TABLE IF EXISTS `t_user_grade`;
CREATE TABLE `t_user_grade`  (
  `gid` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) NULL DEFAULT NULL,
  `grade` int(2) NULL DEFAULT NULL,
  `score` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`gid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `t_user_grade_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_grade
-- ----------------------------
INSERT INTO `t_user_grade` VALUES (1, 1, 1, 95);
INSERT INTO `t_user_grade` VALUES (3, 3, 1, 0);
INSERT INTO `t_user_grade` VALUES (4, 4, 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
