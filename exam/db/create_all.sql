-- user table
SET character_set_client=utf8;
SET character_set_connection=utf8;
set character_set_results=utf8;
CREATE DATABASE IF NOT EXISTS exam CHARACTER SET utf8 COLLATE utf8_general_ci;

USE exam;

-- 表的结构 `user`
CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
  `username` BIGINT(20) COMMENT '姓名',
  `id_number` VARCHAR(64) COMMENT '身份证号码',
  `gender` CHAR(1) COMMENT '性别（1 男，0 女）',
  `mobile` VARCHAR(32) COMMENT '手机号码',
  
  `province` VARCHAR (64) NOT NULL COMMENT '省',
  `city` VARCHAR (64) NOT NULL COMMENT '市',
  `address` VARCHAR (64) NOT NULL COMMENT '详细地址',
  `created_at` DATETIME NOT NULL COMMENT '创建时间',
  `updated_at` TIMESTAMP  NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index` (`mobile`,`fill_form_time`),
  INDEX `mobile_index` (`mobile`)
)
COMMENT '用户表'
ENGINE = InnoDB DEFAULT CHARSET = utf8 ;