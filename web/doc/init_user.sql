CREATE TABLE IF NOT EXISTS user_info
(
    id       bigserial PRIMARY KEY,
    username varchar(32) NOT NULL,
    password varchar(64)
);

INSERT INTO user_info (username, password)
VALUES ('zhangsan', '123456'),
       ('lisi', '123456'),
       ('wangwu', '123456'),
       ('zhaoliu', '123456');