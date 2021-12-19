CREATE TABLE IF NOT EXISTS user_info
(
    id       bigserial PRIMARY KEY,
    username varchar(32) NOT NULL,
    password varchar(64)
);

CREATE TABLE IF NOT EXISTS order_info
(
    id      bigserial PRIMARY KEY,
    name    varchar(64),
    des     text,
    user_id bigint
);

INSERT INTO user_info (username, password)
VALUES ('zhangsan', '123456'),
       ('lisi', '123456'),
       ('wangwu', '123456'),
       ('zhaoliu', '123456');

INSERT INTO order_info (name, des, user_id)
VALUES ('order1', 'this order1', 1),
       ('order2', 'this order2', 2),
       ('order3', 'this order3', 3),
       ('order4', 'this order4', 4);