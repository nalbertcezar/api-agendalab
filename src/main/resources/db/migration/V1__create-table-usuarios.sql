create table usuarios (
	id int not null auto_increment,
	nome varchar(100) not null,
    nomeusuario varchar(20) not null unique,
    senha varchar(100),
    
    primary key(id)
);