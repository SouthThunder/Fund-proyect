create database PymeWave;

use PymeWave;
 
create table usuario(
	correo varchar(40) not NULL,
    nombre varchar(20) NULL,
    apellidos varchar(20) NULL,
    telefono varchar(14) not NULL,
    username varchar (20) not NULL,
    contraseña varchar (64) NOT NULL,
    CONSTRAINT usuario_PK PRIMARY KEY (correo)
);


create table empresa(
	nombre_empresa varchar(30) not NULL,
    correo varchar(40) not NULL,
    dir_fisica varchar (50) not NULL,
    id_empresa int not null AUTO_INCREMENT,
    estado_suscripcion boolean not NULL,
    calificacion double,
    telefono varchar(14) not NULL,
    contraseña varchar(64) not null,
    rut varchar(9) not null,
    CONSTRAINT empresa_PK PRIMARY KEY (id_empresa)
);

-- insertar modificación de las FK y con los datos respectivos a empresa

create table dominios_red(
  dominio_red varchar(250),
    id_empresa int,
    constraint dominio_red_FK foreign key (id_empresa) references empresa(id_empresa)
);

create table catalogo(
  id_empresa int,
    descripcion_empresa varchar(500) not NULL,
    id_catalogo int AUTO_INCREMENT,
    CONSTRAINT catalogo_PK PRIMARY KEY (id_catalogo),
    CONSTRAINT empresa_catalogo_FK FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa)
);

create table producto(
  descripcion varchar(500) not NULL,
    id_catalogo int,
    nombre varchar(50) not NULL,
    id_producto int AUTO_INCREMENT,
    CONSTRAINT producto_PK PRIMARY KEY (id_producto)
);

create table calificaciones(
  num_estrellas int,
    resena varchar(500),
    id_calificacion int AUTO_INCREMENT,
    id_empresa int, -- FK empresa - id_empresa
    correo varchar(40) not null, 
    CONSTRAINT calificaciones_PK PRIMARY KEY (id_calificacion),
    constraint empresa_calificaciones_FK FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa),
    CONSTRAINT usuario_calificaciones_FK FOREIGN KEY (correo) REFERENCES usuario(correo)
);

create table categoria(
  nombre varchar(25) not NULL,
    id_categoria int AUTO_INCREMENT,
    CONSTRAINT categoria_PK PRIMARY KEY (id_categoria)
);

create table categoria_empresa(
  id_empresa int,
    id_categoria int,
    CONSTRAINT categoria_categoria_empresa_FK FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
    CONSTRAINT empresa_categoria_empresa_FK FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa)
);

ALTER table empresa add id_catalogo int;
alter table empresa add id_categoria int;


alter table empresa add CONSTRAINT catalogo_empresa_FK FOREIGN KEY (id_catalogo) REFERENCES catalogo(id_catalogo);

alter table empresa add CONSTRAINT categoria_empresa_FK FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria);
alter table producto modify column id_catalogo int;

alter table producto add constraint producto_catalogo foreign key (id_catalogo) references catalogo(id_catalogo);


select * from producto;

select *from usuario;

Delete from usuario where correo='testing';



