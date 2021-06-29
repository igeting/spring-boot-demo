create table test.user
(
    id         bigint unsigned auto_increment primary key,
    created_at datetime     null,
    updated_at datetime     null,
    deleted_at datetime     null,
    nickname   varchar(256) null,
    username   varchar(256) null,
    password   varchar(256) null
);

create index idx_test_user_deleted_at on test.user (deleted_at);

INSERT INTO test.user (created_at, updated_at, deleted_at, nickname, username, password) VALUES ('2021-05-29 05:17:22', '2021-05-29 05:17:22', null, '', 'ADMIN', '21232F297A57A5A743894A0E4A801FC3');