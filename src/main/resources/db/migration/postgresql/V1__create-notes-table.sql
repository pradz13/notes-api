create sequence nt_id_seq start with 1 increment by 50;

create table notes (id bigint default nextval('nt_id_seq') not null,
                    title varchar(255) not null,
                    content varchar(255) not null,
                    created_at timestamp(6) with time zone,
                    primary key (id));