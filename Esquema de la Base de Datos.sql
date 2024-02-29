CREATE DATABASE IF NOT EXISTS Medicare;
USE Medicare;

CREATE TABLE IF NOT EXISTS Usuarios(
Correo varchar(30) primary key,
Usuario varchar(15) unique,
Contraseña varchar(20) not null,
Tipo_Usuario varchar(2) not null
);

INSERT INTO Usuarios VALUES
('john@gmail.com','john123', 'jjmm', 'A'),
('dustin@gmail.com','dus123', 'djms', 'A'),
('isabel@gmail.com', 'isa123', 'jipc', 'M'),
('alejandro@gmail.com','ale123', 'aamc', 'M');

SELECT * FROM Usuarios WHERE Correo = 'dustin@gmail.com' or Usuario = 'dus123' and Contraseña = 'djms';

CREATE TABLE Medicos(
Cedula numeric(10) primary key not null,
Nombres varchar(50) not null,
Apellidos varchar(50) not null,
Telefono numeric(10),
Especialidad varchar(20) not null,
Ubicacion text not null,
Tipo_Usuario varchar(30) not null check (Tipo_Usuario='Medico'),
foreign key (Tipo_Usuario) references Usuarios(Tipo_Usuario)
);

INSERT INTO Medicos VALUES
(1751046745, 'Anthony Alejandro', 'Minga Campoverde', '0968862211', 'Medicina General', 'Quito', 'Medico'),
(1751046746, 'Jesenia Isabel', 'Pazto Corregidor', '0990123317', 'Pediatra', 'Quito', 'Medico');

SELECT * FROM Medicos;

CREATE TABLE Clientes(
Cedula numeric(10) primary key not null,
NombresCompleto varchar(50) not null,
Correo varchar(50),
Telefono numeric(10) unique,
Sexo varchar(1) not null,
Alergias text,
Estatura numeric(3) check (Estatura<250),
Peso numeric(3) check (Peso<300)
);
INSERT INTO Clientes VALUES
(1234567890, 'Nombres Apellidos', 'Correo@gmail.com', 0987654321, 'H', 'Ninguna', 185, 80),
(1751046745, 'Ander Campoverde', 'Ander@gmail.com', 0987654321, 'H', 'Ninguna', 185, 80);
(1751046746, 'Jesenia Pazto', 'Jesenia@gmail.com', 0987654321, 'M', 'Ninguna', 160, 60);




select * from Clientes;

create table Citas(
ID int primary key not null,
Nombre_Cliente varchar(50) not null,
Cedula numeric(10) not null,
Medico_a_cargo varchar(50) not null,
Motivo_cita varchar(500) not null,
Fecha timestamp not null, 
foreign key (Cedula) references Clientes (Cedula)
);
insert into Citas values (00001,'Ander Campoverde','1751046745','Anthony Alejandro A.','Consulta','2024-01-25');

create table Resultados(
ID int primary key auto_increment,
Cedula numeric(10) not null,
Resultado text,
Tratamiento text,
Medicamento text,
Temperatura numeric(2) not null check(Temperatura<45),
Presion_Arterial numeric(3) check(Presion_Arterial<200),
foreign key (Cedula) references Clientes(Cedula)
);
insert into Resultados values (0001,'Ander Campoverde','1751046745','Anthony Alejandro A.','Paracetamol','Una cada 8 horas');

create table HistorialMedico(
IdHC int primary key not null,
Cedula numeric(10) not null,
ID_Medico numeric(10) not null,
Servicio varchar (75) not null,
foreign key (Cedula) references Clientes (Cedula),
foreign key (ID_Medico) references Medicos (Cedula)
);

insert into HistorialMedico values (1001,1751046745,'Anthony Alejandro A.','Consulta','Una cada 8 horas');

