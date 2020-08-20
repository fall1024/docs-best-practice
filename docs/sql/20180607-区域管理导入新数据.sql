/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.6.37-log

@author ahming
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

ALTER TABLE sys_area
ADD COLUMN `no` INT(11) UNSIGNED DEFAULT '0' COMMENT '编号',
ADD COLUMN `parent_no` INT(11) UNSIGNED DEFAULT '0' COMMENT '父编号',
ADD COLUMN `shortName` VARCHAR(50) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '短名称',
ADD COLUMN `level` CHAR(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '层次',
ADD COLUMN `cityCode` VARCHAR(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '区号',
ADD COLUMN `zipCode` VARCHAR(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮编',
ADD COLUMN `mergerName` VARCHAR(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '合并名称',
ADD COLUMN `lng` DECIMAL(13,6) DEFAULT NULL COMMENT '经度',
ADD COLUMN `lat` DECIMAL(13,6) DEFAULT NULL COMMENT '纬度',
ADD COLUMN `pinyin` VARCHAR(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '拼音';
