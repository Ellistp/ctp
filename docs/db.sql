## 创建ghub数据库 ##
CREATE DATABASE ghub;
## 使用ghub数据库 ##
use ghub;
## 用户表 ##
DROP TABLE IF EXISTS acc_user;
CREATE TABLE `acc_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `account` varchar(128) NOT NULL COMMENT '账户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `salt` varchar(32) NOT NULL COMMENT '加盐',
  `nick_name` varchar(128) NOT NULL COMMENT '用户昵称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
insert into `acc_user` (`id`, `gmt_create`, `gmt_modified`, `account`, `password`, `salt`, `nick_name`) values('1','2018-07-24 15:56:37','2018-07-24 15:56:39','zhangsan','46a9e4b7118f3a2b4c7568a26b5aefa5','9c6bdd0d12eefaf42ecf978779ac6b2a','张三');


## 系统日志表 ##
DROP TABLE IF EXISTS sys_log;
CREATE TABLE `sys_log` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '操作用户id',
  `ip` VARCHAR(128) NOT NULL COMMENT '请求ip',
  `url` VARCHAR(128) NOT NULL COMMENT '请求路径',
  `module_name` VARCHAR(64) DEFAULT NULL COMMENT '模块名称(账户(account))',
  `operate_type` VARCHAR(32) DEFAULT NULL COMMENT '操作类型(add,delete,update)',
  `operate_status` TINYINT(4) DEFAULT NULL COMMENT '操作状态(1表示成功,0表示失败)',
  `operate_desc` TEXT DEFAULT NULL COMMENT '操作描述',
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`user_id`),
  KEY `idx_moduleName` (`module_name`),
  KEY `idx_operateType` (`operate_type`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='日志表';