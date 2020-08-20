/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.6.37-log

说明：之前有些地方使用了复数形式，应该统一到与 Constant 里的一致
@author ahming
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

-- SELECT `type`, COUNT(*) FROM tc_resource r GROUP BY `type`;

UPDATE tc_resource SET `type` = 'image' WHERE `type` = 'images';
UPDATE tc_resource SET `type` = 'video' WHERE `type` = 'videos';
