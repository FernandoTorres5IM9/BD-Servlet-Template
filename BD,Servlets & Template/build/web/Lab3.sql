create database UsuariosLab3;
use UsuariosLab3;
create table Usuarios1(
usuario varchar(20),
contraseña varchar(20),
rango varchar(20)
);
insert into Usuarios1 values("fernando@mail.com", "12345","administrador");
insert into Usuarios1 values("fernando2@mail.com", "abcd","normal");
select rango from Usuarios1 where usuario = "fernando@mail.com";
select * from Usuarios1 where usuario = "fernando@mail.com" and contraseña = "12345";

