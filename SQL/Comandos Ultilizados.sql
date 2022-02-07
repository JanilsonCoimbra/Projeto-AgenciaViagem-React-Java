create schema AgenciaViagens;
use AgenciaViagens;
create table Clientes(
id int primary key auto_increment,
nome varchar(60),
email varchar(30) unique,
cpf char(15) unique,
senha varchar(60),
index (cpf),
index (email)
);
create table Destinos(
idDestino int primary key auto_increment,
nome varchar(60),
descricao varchar(500),
valor float(15),
index (nome)
);
create table Compras(
idCompra int primary key auto_increment,
idCliente int,
idDestino int,
foreign key (idCliente) references agenciaviagens.clientes(id) ON DELETE CASCADE,
foreign key (idDestino) references agenciaviagens.Destinos(idDestino) ON DELETE CASCADE,
index(idCliente),
index(idDestino)
);
create table Contato(
idContato int primary key auto_increment,
nomeMensagem varchar(60),
emailMensagem varchar(30),
mensagem varchar(500),
index(emailMensagem)
);

insert into clientes values(default, "janilson", "janilson.coimbra@gmail.com", "066572354932", "04579621");
insert into clientes values(default, "Pedro", "pedro.silva@gmail.com", "765572354932", "054542341");
select * from clientes;clientes

insert into destinos values(default, "Morro de São Paulo", "Morro de São Paulo é uma vila sem automóveis na extremidade nordeste da Ilha de Tinharé do Brasil.", 500);
insert into destinos values(default, "Chapada Diamantina", "Chapada Diamantina é uma região de serras, protegida na categoria de parque nacional, situada no centro do estado brasileiro da Bahia, onde nascem quase todos os rios das bacias do Paraguaçu, do Jacuípe e do Rio de Contas.", 900);
select * from compras where idCliente = 1

insert into compras  values(default, 1, 2);
insert into compras  values(default, 2, 2);
insert into compras  values(default, 1, 1);
insert into compras  values(default, 2, 1);

select cp.idCliente, ct.id, ct.email, ct.cpf, dst.idDestino, dst.nome from 
compras as cp
inner join
clientes as ct
inner join
destinos as dst
on cp.idCliente = 1 and ct.id = 1 and dst.idDestino = cp.idDestino;
 
select idCliente from compras where idCliente = 1;
update clientes set nome = "vitor", senha = "32384545" where id = 10;

