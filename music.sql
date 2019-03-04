/*
SQLyog v10.2 
MySQL - 5.5.40 : Database - db_music
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_music` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `t_content` */

CREATE TABLE `t_content` (
  `cid` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) DEFAULT NULL,
  `mid` int(8) DEFAULT NULL,
  `content` varchar(400) DEFAULT NULL,
  `content_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `uid` (`uid`),
  KEY `mid` (`mid`),
  CONSTRAINT `t_content_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`),
  CONSTRAINT `t_content_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `t_music` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_content` */

insert  into `t_content`(`cid`,`uid`,`mid`,`content`,`content_time`) values (1,1,5,' 也许你现在仍然是一个人吃饭，一个人看电影，一个人发呆，一个人睡觉，一个人等天明。 然而你却能一个人吃饭，一个人看电影，一个人发呆，一个人睡觉，一个人等天明。很多人离开另外一个人， 就没有自己。而你却能够一个人，等天明。你的孤独，虽败犹荣。','2017-11-16 10:35:41'),(2,1,5,'Till you showed me what your all about','2017-11-16 12:13:13');

/*Table structure for table `t_evaluate` */

CREATE TABLE `t_evaluate` (
  `eid` int(8) NOT NULL AUTO_INCREMENT,
  `mid` int(8) DEFAULT NULL,
  `uid` int(8) DEFAULT NULL,
  `evaluate` int(1) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `mid` (`mid`),
  KEY `uid` (`uid`),
  CONSTRAINT `t_evaluate_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`),
  CONSTRAINT `t_evaluate_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `t_music` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_evaluate` */

insert  into `t_evaluate`(`eid`,`mid`,`uid`,`evaluate`) values (2,5,1,0);

/*Table structure for table `t_music` */

CREATE TABLE `t_music` (
  `mid` int(8) NOT NULL AUTO_INCREMENT,
  `music_name` varchar(50) DEFAULT NULL,
  `path_name` varchar(100) DEFAULT NULL,
  `upload_user` int(8) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `upload_user` (`upload_user`),
  CONSTRAINT `t_music_ibfk_1` FOREIGN KEY (`upload_user`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_music` */

insert  into `t_music`(`mid`,`music_name`,`path_name`,`upload_user`,`upload_time`) values (1,'徐梦圆 - China-P','/upload/music/4199b5a0-9cef-434a-830f-32beae7d6deb.mp3',1,'2017-11-12 20:30:54'),(4,'黒石ひとみ - If I were a Bird','/upload/music/b8d4b205-0174-425c-b411-33fd6f79508e.mp3',1,'2017-11-12 21:22:50'),(5,'茶太 - 宝物','/upload/music/724a0c0c-4765-4285-8c35-78051fc427cc.mp3',1,'2017-11-13 16:18:06'),(6,'五月天-好好','/upload/music/4dbc61f8-51c7-4b9e-aad2-f4927b6f0899.mp3',1,'2017-11-16 23:07:10'),(7,'林俊杰 - 裂缝中的阳光','/upload/music/d503c6bf-2895-4ea3-9082-772e0daed852.mp3',1,'2017-11-16 23:10:27'),(8,'Ace组合 - 青花引','/upload/music/06fb38e6-6330-4cf0-ab75-bebed19b1871.mp3',1,'2017-11-16 23:11:43');

/*Table structure for table `t_music_info` */

CREATE TABLE `t_music_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `mid` int(8) DEFAULT NULL,
  `musicImage` varchar(100) DEFAULT NULL,
  `clickRate` int(8) DEFAULT NULL,
  `downloads` int(8) DEFAULT NULL,
  `user_like` int(8) DEFAULT NULL,
  `user_dislike` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  CONSTRAINT `t_music_info_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `t_music` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_music_info` */

insert  into `t_music_info`(`id`,`mid`,`musicImage`,`clickRate`,`downloads`,`user_like`,`user_dislike`) values (1,1,'/images/m0.jpg',1,6,0,0),(2,4,'/images/m0.jpg',1,0,0,0),(3,5,'/images/m0.jpg',1,6,1,0),(4,6,'/images/m0.jpg',1,0,0,0),(5,7,'/images/m0.jpg',1,0,0,0),(6,8,'/images/m0.jpg',1,0,0,0);

/*Table structure for table `t_user` */

CREATE TABLE `t_user` (
  `uid` int(8) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) DEFAULT NULL,
  `userPassword` varchar(100) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `userImage` varchar(100) DEFAULT NULL,
  `userMood` varchar(200) DEFAULT NULL,
  `userGrade` int(2) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`uid`,`email`,`userPassword`,`userName`,`userImage`,`userMood`,`userGrade`) values (1,'1@qq.com','1','白风和','/images/m0.jpg','太阳当空照，花儿对我笑',0),(3,'112441231@qq.com','1','首次测试','/images/m0.jpg','太阳当空照，花儿对我笑',0),(4,'11@qq.com','11','测试用户','/images/m0.jpg','太阳当空照，花儿对我笑',0);

/*Table structure for table `t_user_grade` */

CREATE TABLE `t_user_grade` (
  `gid` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) DEFAULT NULL,
  `grade` int(2) DEFAULT NULL,
  `score` int(8) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `uid` (`uid`),
  CONSTRAINT `t_user_grade_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_grade` */

insert  into `t_user_grade`(`gid`,`uid`,`grade`,`score`) values (1,1,1,85),(3,3,1,0),(4,4,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
