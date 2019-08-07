-- tabela do banco

create table usuario (
	id integer not null primary key,
	nome varchar(255),
	atualizado boolean,
	deletado boolean
);

