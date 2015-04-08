create type profile
external name 'edu.ycp.cs320spring2015.oubliation.shared'
language java

create table accounts (id integer, username varchar, password varchar, primary key id);
create table profiles (id integer, profile profile, primary key id);