create table folder
(
    id      int auto_increment
        primary key,
    user_id int          not null,
    name    varchar(255) not null
);

INSERT INTO login.folder (id, user_id, name) VALUES (2, 12, 'string1');
INSERT INTO login.folder (id, user_id, name) VALUES (3, 12, 'string2');
INSERT INTO login.folder (id, user_id, name) VALUES (4, 14, 'string');
create table todo
(
    id         int auto_increment
        primary key,
    user_id    int          not null,
    folder_id  int          not null,
    title      varchar(255) not null,
    createtime bigint       not null,
    noticetime bigint       not null,
    content    text         null
);

INSERT INTO login.todo (id, user_id, folder_id, title, createtime, noticetime, content) VALUES (2, 12, 2, 'string2', 2, 2, 'string2');
INSERT INTO login.todo (id, user_id, folder_id, title, createtime, noticetime, content) VALUES (5, 14, 4, 'string3', 3, 0, 'string5');
INSERT INTO login.todo (id, user_id, folder_id, title, createtime, noticetime, content) VALUES (7, 14, 4, 'string4', 4, 4, 'string4');
INSERT INTO login.todo (id, user_id, folder_id, title, createtime, noticetime, content) VALUES (8, 14, 4, 'string5', 5, 5, 'string5');
INSERT INTO login.todo (id, user_id, folder_id, title, createtime, noticetime, content) VALUES (11, 14, 4, 'string', 0, 0, 'string3');
INSERT INTO login.todo (id, user_id, folder_id, title, createtime, noticetime, content) VALUES (12, 14, 4, 'string3', 0, 0, 'string');
create table user
(
    id       int auto_increment
        primary key,
    name     varchar(255) not null,
    email    text         not null,
    password varchar(255) not null,
    logo_url text         null
);

INSERT INTO login.user (id, name, email, password, logo_url) VALUES (2, 'testing', '123@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '123');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (3, 'testing2', '456@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '456');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (4, 'testing2', '234@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '123');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (5, 'qwetre', '89@qq.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'string');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (6, 'string', '321', 'yvGj37UF/+0NAkEw9Yxc+g==', 'string');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (7, '1234', '1234', 'gdyb21LQTcIANtvYMT7QVQ==', 'string');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (8, '123456', '123', 'xMpCOKC5I4INzFCab3WEmw==', 'string');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (9, 'testing2', '890@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '123');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (10, 'zxc', 'zxc@qq.com', 'X6cjWPC0+08sXX3oyaQYRg==', 'zxc');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (11, '', '', '1B2M2Y8AsgTpgAmY7PhCfg==', '');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (12, '345', '345', '2B+cG+LgiWS/nySxXw5JAA==', '345');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (13, '234', '234', 'KJ3/B2adeiPeDviNL3Ep5w==', '234');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (14, 'string', 'string', 'tFz/4ITdPSDZKL7oXnsPIQ==', 'string');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (15, '1234@qq.com', '1234@qq.com', 'ICy5YqxZB1uWSwcVLSNLcA==', ' ');
INSERT INTO login.user (id, name, email, password, logo_url) VALUES (16, '12345@qq.com', '12345@qq.com', 'ICy5YqxZB1uWSwcVLSNLcA==', ' ');