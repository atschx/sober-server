-- 创建业务数据库
drop database if exists `adnetwork`;
create database `adnetwork` CHARSET=utf8;
use `adnetwork`;

CREATE USER 'sober'@'localhost' IDENTIFIED BY 'sober';
CREATE USER 'sober'@'%' IDENTIFIED BY 'sober';

GRANT ALL PRIVILEGES ON adnetwork.* TO 'sober'@'localhost';
GRANT ALL PRIVILEGES ON adnetwork.* TO 'sober'@'%';
FLUSH PRIVILEGES;
