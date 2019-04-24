create table groups
(
    id           bigint       not null
        constraint groups_pkey
            primary key,
    name         varchar(255) not null,
    size         bigint,
    study_type   bigint
        constraint fk_group_study_type
            references study_type
);

create sequence group_id_seq;