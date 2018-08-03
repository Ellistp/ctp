/*创建ghub数据库*/
CREATE DATABASE ghub;

/*使用ghub数据库*/
USE ghub;

/*用户表*/
DROP TABLE IF EXISTS acc_user;
CREATE TABLE `acc_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `account` varchar(128) NOT NULL COMMENT '账户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `salt` varchar(32) NOT NULL COMMENT '加盐',
  `nick_name` varchar(128) NOT NULL COMMENT '用户昵称',
  `state` varchar(32) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
insert into `acc_user` (`id`, `gmt_create`, `gmt_modified`, `account`, `password`, `salt`, `nick_name`, `state`) values('1','2018-07-24 15:56:37','2018-07-24 15:56:39','zhangsan','46a9e4b7118f3a2b4c7568a26b5aefa5','9c6bdd0d12eefaf42ecf978779ac6b2a','张三',NULL);
insert into `acc_user` (`id`, `gmt_create`, `gmt_modified`, `account`, `password`, `salt`, `nick_name`, `state`) values('2','2018-08-03 11:14:00','2018-08-03 11:14:05','lisi','46a9e4b7118f3a2b4c7568a26b5aefa5','9c6bdd0d12eefaf42ecf978779ac6b2a','李四',NULL);

/*权限表*/
DROP TABLE IF EXISTS `acc_permission`;
CREATE TABLE `acc_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名',
  `permission_sign` varchar(128) DEFAULT NULL COMMENT '权限标识,程序中判断使用,如"user:create"',
  `description` varchar(256) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';
insert into `acc_permission` (`id`, `gmt_create`, `gmt_modified`, `permission_name`, `permission_sign`, `description`) values('1','2018-07-24 15:56:37','2018-07-24 15:56:39','用户新增','user:create','用户新增权限');
insert into `acc_permission` (`id`, `gmt_create`, `gmt_modified`, `permission_name`, `permission_sign`, `description`) values('2','2018-08-03 11:10:12','2018-08-03 11:10:13','用户删除','user:delete','用户删除权限');
insert into `acc_permission` (`id`, `gmt_create`, `gmt_modified`, `permission_name`, `permission_sign`, `description`) values('3','2018-08-03 11:10:48','2018-08-03 11:10:50','用户更新','user:update','用户更新权限');
insert into `acc_permission` (`id`, `gmt_create`, `gmt_modified`, `permission_name`, `permission_sign`, `description`) values('4','2018-08-03 11:11:10','2018-08-03 11:11:12','用户查询','user:select','用户查询权限');

/*角色表*/
DROP TABLE IF EXISTS `acc_role`;
CREATE TABLE `acc_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `role_sign` varchar(128) DEFAULT NULL COMMENT '角色标识,如"admin"',
  `description` varchar(256) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
insert into `acc_role` (`id`, `gmt_create`, `gmt_modified`, `role_name`, `role_sign`, `description`) values('1','2018-07-24 15:56:37','2018-07-24 15:56:39','admin','admin','管理员');
insert into `acc_role` (`id`, `gmt_create`, `gmt_modified`, `role_name`, `role_sign`, `description`) values('2','2018-08-03 11:09:28','2018-08-03 11:09:32','normal_user','normal_user','普通用户');

/*角色权限关联表*/
DROP TABLE IF EXISTS `acc_role_permission`;
CREATE TABLE `acc_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) unsigned DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  KEY `idx_roleId` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';
insert into `acc_role_permission` (`id`, `gmt_create`, `gmt_modified`, `role_id`, `permission_id`) values('2','2018-08-03 11:12:24','2018-08-03 11:12:25','1','2');
insert into `acc_role_permission` (`id`, `gmt_create`, `gmt_modified`, `role_id`, `permission_id`) values('3','2018-08-03 11:12:32','2018-08-03 11:12:34','1','3');
insert into `acc_role_permission` (`id`, `gmt_create`, `gmt_modified`, `role_id`, `permission_id`) values('4','2018-08-03 11:12:43','2018-08-03 11:12:45','1','4');
insert into `acc_role_permission` (`id`, `gmt_create`, `gmt_modified`, `role_id`, `permission_id`) values('5','2018-08-03 11:12:54','2018-08-03 11:12:55','2','4');
insert into `acc_role_permission` (`id`, `gmt_create`, `gmt_modified`, `role_id`, `permission_id`) values('6','2018-08-03 11:13:32','2018-08-03 11:13:34','2','3');

/*用户角色关联表*/
DROP TABLE IF EXISTS `acc_user_role`;
CREATE TABLE `acc_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';
insert into `acc_user_role` (`id`, `gmt_create`, `gmt_modified`, `user_id`, `role_id`) values('1','2018-07-24 15:56:37','2018-07-24 15:56:39','1','1');
insert into `acc_user_role` (`id`, `gmt_create`, `gmt_modified`, `user_id`, `role_id`) values('2','2018-08-03 11:15:15','2018-08-03 11:15:16','2','2');

/*系统日志表*/
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