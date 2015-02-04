-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.28 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 cpp 的数据库结构
DROP DATABASE IF EXISTS `cpp`;
CREATE DATABASE IF NOT EXISTS `cpp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `cpp`;


-- 导出  表 cpp.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID 主键自增',
  `USER_NAME` varchar(100) NOT NULL COMMENT '用户名',
  `NICK_NAME` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `PASSWORD` varchar(255) NOT NULL COMMENT '用户密码',
  `CREATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `UPDATETIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 正在导出表  cpp.user 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`USER_ID`, `USER_NAME`, `NICK_NAME`, `PASSWORD`, `CREATETIME`, `UPDATETIME`) VALUES
	(1, 'chdaly', '一只胖子', '1213', '2015-01-18 00:05:30', '2015-01-18 00:07:19'),
	(2, 'aitcax', '☆天赐暗香☆', '33', '2015-01-18 00:06:55', '2015-01-18 00:07:26'),
	(3, 'popo', '硬币', '76676', '2015-01-18 08:36:10', '2015-01-18 08:37:05');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
