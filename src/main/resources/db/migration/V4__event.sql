create table events
(
    id              bigint not null
        constraint events_pkey
            primary key,
    description     varchar(10233),
    end_date_time   timestamp,
    location        varchar(255),
    start_date_time timestamp,
    summary         varchar(255),
    calendar_id     bigint
        constraint fk_event_calendar
            references schedule
);

create sequence event_id_seq;