/*
MySQL Data Transfer
Source Host: localhost
Source Database: library_system
Target Host: localhost
Target Database: library_system
Date: 2020/2/27 16:26:39
*/

CREATE DATABASE /*!32312 IF NOT EXISTS*/`library_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library_system`;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_admin_user
-- ----------------------------
CREATE TABLE `tb_admin_user` (
  `admin_id` tinyint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(600) DEFAULT NULL,
  `login_password` varchar(150) DEFAULT NULL,
  `admin_nick_name` varchar(150) DEFAULT NULL,
  `locked` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
CREATE TABLE `tb_news` (
  `news_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '新闻主键id',
  `news_title` varchar(200) NOT NULL DEFAULT '' COMMENT '标题',
  `news_category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '新闻类型',
  `news_cover_image` varchar(200) NOT NULL DEFAULT '' COMMENT '新闻封面图片',
  `news_content` text NOT NULL COMMENT '内容',
  `news_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '发布状态 0-发布 1-草稿',
  `news_views` bigint(20) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_news_category
-- ----------------------------
CREATE TABLE `tb_news_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类别主键id',
  `category_name` varchar(200) NOT NULL DEFAULT '' COMMENT '类别名称',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_news_comment
-- ----------------------------
CREATE TABLE `tb_news_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论主键id',
  `news_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联咨询主键id',
  `commentator` varchar(200) NOT NULL DEFAULT '' COMMENT '评论人',
  `comment_body` varchar(300) NOT NULL DEFAULT '' COMMENT '评论内容',
  `comment_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '评论状态 0-未审核 1-审核通过',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_admin_user` VALUES ('2', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'shuaiguo', '0');
