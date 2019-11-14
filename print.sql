create table print
(
  printId    int auto_increment
    primary key,
  size       varchar(50)  not null,
  printStyle varchar(50)  not null,
  printColor varchar(50)  not null,
  note       varchar(500) null,
  gmtCreate  mediumtext   not null,
  gmtModify  mediumtext   not null,
  number     varchar(11)  not null
);

create table user
(
  number   varchar(11) not null
    primary key,
  name     varchar(10) not null,
  phone    varchar(11) not null,
  password varchar(20) not null
);

