create table Language (
  id int primary key,
  name varchar(50) not null unique
);

create table Word (
  id int primary key,
  value varchar(50) not null unique,
  language int not null,
  constraint fk_lang foreign key (language) references Language(id) on delete no action on update no action
);

create table Translation (
  id int primary key,
  word1 int not null,
  word2 int not null,
  lang int not null,
  constraint fk_word1 foreign key (word1) references Word(id) on delete no action on update no action,
  constraint fk_word2 foreign key (word2) references Word(id) on delete no action on update no action,
  constraint fk_lang foreign key (lang) references Language(id) on delete no action on update no action
);

insert into Language values('English');
insert into Language values('Russian');

insert into Word values(1, 'hello', 1);
insert into Word values(2, '??????', 2);

insert into Translation values(1, 1, 2, 1);
insert into Translation values(2, 2, 1, 2);