## 用户表 ##
DROP TABLE IF EXISTS acc_user;
CREATE TABLE `acc_user` (
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
`gmt_create` datetime NOT NULL COMMENT '创建时间',
`gmt_modified` datetime NOT NULL COMMENT '修改时间',
`name` varchar(128) DEFAULT NULL COMMENT '真实姓名',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';


## 系统日志表 ##
DROP TABLE IF EXISTS sys_log;
CREATE TABLE `sys_log` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
  `user_id` BIGINT(20) NOT NULL COMMENT '操作用户id',
  `ip` VARCHAR(128) NOT NULL COMMENT '请求ip',
  `url` VARCHAR(128) NOT NULL COMMENT '请求路径',
  `module_name` VARCHAR(64) NOT NULL COMMENT '模块名称(账户(account),课程(course),资源(resource))',
  `operate_type` VARCHAR(32) NOT NULL COMMENT '操作类型(add,delete,update)',
  `operate_status` TINYINT(4) NOT NULL COMMENT '操作状态(1表示成功,0表示失败)',
  `operate_desc` TEXT NOT NULL COMMENT '操作描述',
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`user_id`),
  KEY `idx_moduleName` (`module_name`),
  KEY `idx_operateType` (`operate_type`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='日志表';