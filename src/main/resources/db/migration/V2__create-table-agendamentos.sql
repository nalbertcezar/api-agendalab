create table agendamentos (
	id int not null auto_increment,
    usuario_id int not null,
    data date not null,
    hora time not null,
    
    primary key(id),
    constraint fk_agendamentos_usuario_id foreign key(usuario_id) references usuarios(id)
);