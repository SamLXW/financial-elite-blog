--创建DB
create database if not exists fineliteblogdb DEFAULT CHARACTER SET utf8;

USE FineliteBlogDB;

--User Table
create table if not exists USER(
    ID int  auto_increment comment '用户id [自增 |主键]',
    NICK_NAME varchar(50) NOT NULL comment '用户昵称',
    PASSWORD varchar(100) NOT NULL comment '用户登录密码',
    CREATED_TIME datetime DEFAULT NULL comment '账户创建时间',
    UPDATED_BY int DEFAULT NULL comment '账户更新人',
    UPDATED_TIME datetime DEFAULT NULL comment '账户更新时间',
    PRIMARY KEY (ID)
)engine=innoDB  default charset=utf8;
