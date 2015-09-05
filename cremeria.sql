create table usuarios(
id_usuario int unique not null,
nombre varchar(100) not null,
apellidopaterno varchar (100) not null,
contraseni varchar (100) not null,
tipo varchar (100) not null,
direccion varchar (100) not null,
telefono int not null,
correo varchar (100) not null,
primary key(id_usuario)
); 

create table comentarios(
descripcion varchar (100) not null,
fecha_publicacion date not null,
idusuario int not null,
Foreign key(idusuario) references usuarios(id_usuario) on delete cascade on update cascade
);

create table pedidos(
id_pedido int unique not null,
cantidad int not null,
fecha_registro date not null,
idusuario int not null,
primary key(id_pedido),
Foreign key(idusuario) references usuarios(id_usuario) on delete cascade on update cascade
);

create table productos(
id_producto int unique not null,
nombre_prod varchar (100) not null,
precio float not null,
existencia int not null,
primary key(id_producto)
);

create table pedido_producto(
idpedido int not null,
idproducto int not null,
Foreign key(idpedido) references pedidos(id_pedido) on delete cascade on update cascade,
Foreign key(idproducto) references productos(id_producto) on delete cascade on update cascade
);

alter table usuarios rename contraseni to contrasenia;
