------------------- BASE DE DATOS ---------------------

USE mysql;
DROP DATABASE IF EXISTS Medicare;
CREATE DATABASE Medicare;
USE Medicare;

------------------- TABLA USUARIOS -------------------

DROP TABLE IF EXISTS Usuarios;

CREATE TABLE Usuarios(
Correo varchar(30) primary key,
Usuario varchar(15) unique,
Contraseña varchar(20) not null,
Tipo_Usuario varchar(2) not null);

INSERT INTO Usuarios VALUES
('john@gmail.com','john123', 'jjmm', 'A'),
('dustin@gmail.com','dus123', 'djms', 'A'),
('isabel@gmail.com', 'isa123', 'jipc', 'M'),
('alejandro@gmail.com','ale123', 'aamc', 'M');

SELECT * FROM Usuarios;

------------------- TABLA MEDICOS -------------------

DROP TABLE IF EXISTS Medicos;

CREATE TABLE Medicos(
Cedula_Medico numeric(10) primary key check (Cedula_Medico>90000000),
Nombre_Medico varchar(50) not null,
Telefono_Medico numeric(10),
Especialidad varchar(20) not null,
Ubicacion text not null,
Usuario varchar(15) not null,
foreign key (Usuario) references Usuarios (Usuario)
);

INSERT INTO Medicos VALUES
(1234567890, 'Dr. Alejandro Minga' , 2109876543, 'Urologo', 'Quito', 'ale123'),
(2345678901, 'Dra. Isabel Pazto' , 1098765432, 'Medicina General', 'Quito', 'isa123');

SELECT * FROM Medicos;

------------------- TABLA CLIENTES -------------------

DROP TABLE IF EXISTS Pacientes;

CREATE TABLE IF NOT EXISTS Pacientes(
Cedula_Paciente numeric(10) primary key check (Cedula_Paciente>90000000),
Nombre_Paciente varchar(50) not null,
Correo varchar(50),
Telefono_Paciente numeric(10) unique not null,
Sexo varchar(6) not null,
Alergias text,
Estatura numeric(3) check (Estatura<250) not null,
Peso numeric(5,2) check (Peso<300) not null
);

INSERT INTO Pacientes VALUES
(4567890123, 'Ana Martinez', 'ana.martinez@example.com', 6543210987, 'Mujer', 'Gluten', 165, 55),
(5678901234, 'Pedro Gonzalez', 'pedro.gonzalez@example.com', 5432109876, 'Hombre', 'Ninguna', 175, 75),
(6789012345, 'Laura Lopez', 'laura.lopez@example.com', 4321098765, 'Mujer', 'Lactosa', 155, 50),
(7890123456, 'Luis Torres', 'luis.torres@example.com', 3210987654, 'Hombre', 'Ninguna', 185, 85),
(8901234567, 'Sofia Morales', 'sofia.morales@example.com', 2109876543, 'Mujer', 'Frutos secos', 160, 60),
(9012345678, 'Javier Gutierrez', 'javier.gutierrez@example.com', 1098765432, 'Hombre', 'Ninguna', 180, 80),
(3123456789, 'Carmen Ramos', 'carmen.ramos@example.com', 0987654321, 'Mujer', 'Mariscos', 170, 65),
(1234567809, 'Ricardo Reyes', 'ricardo.reyes@example.com', 9876543210, 'Hombre', 'Ninguna', 190, 90),
(2345678901, 'Isabel Cruz', 'isabel.cruz@example.com', 8765432109, 'Mujer', 'Polen', 165, 55),
(3456789012, 'Fernando Ortiz', 'fernando.ortiz@example.com', 7654321098, 'Hombre', 'Ninguna', 175, 75);

SELECT * FROM Pacientes;

------------------- TABLA CITAS -------------------

DROP TABLE IF EXISTS Citas;

CREATE TABLE IF NOT EXISTS Citas(
ID_Cita int primary key,
Cedula_Paciente numeric(10) not null,
Cedula_Medico numeric(10) not null,
Motivo_Cita varchar(500) not null,
Fecha timestamp not null default current_timestamp(),
foreign key (Cedula_Paciente) references Pacientes (Cedula_Paciente),
foreign key (Cedula_Medico) references Medicos (Cedula_Medico)
);

INSERT INTO Citas VALUES
(1, 4567890123, 1234567890, 'Dolor en el riñon', default),
(2, 5678901234, 2345678901, 'Dolor de cabeza', default),
(3, 6789012345, 1234567890, 'Dolor de estomago', default),
(4, 7890123456, 2345678901, 'Dolor de garganta', default),
(5, 8901234567, 1234567890, 'Dolor de espalda', default),
(6, 9012345678, 2345678901, 'Dolor de rodilla', default),
(7, 3123456789, 1234567890, 'Dolor de muela', default),
(8, 1234567809, 2345678901, 'Dolor de oido', default),
(9, 2345678901, 1234567890, 'Dolor de estomago', default),
(10, 3456789012, 2345678901, 'Dolor de cabeza', default);

SELECT * FROM Citas;

------------------- TABLA RESULTADOS -------------------

DROP TABLE IF EXISTS Resultados;

CREATE TABLE Resultados(
ID_Resultado int primary key,
Cedula_Paciente numeric(10) not null,
Resultado text,
Tratamiento text,
Medicamento text,
Temperatura numeric(2) not null check (Temperatura < 45),
Presion numeric(3) check (Presion < 200),
foreign key (Cedula_Paciente) references Pacientes (Cedula_Paciente)
);

INSERT INTO Resultados VALUES
(1, 4567890123, 'Dolor en el riñon, tiene piedras en el riñon', 'Tomar mucha agua', 'Ibuprofeno', 37, 120),
(2, 5678901234, 'Dolor de cabeza, tiene migraña', 'Tomar mucho liquido', 'Paracetamol', 36, 110),
(3, 6789012345, 'Dolor de estomago, tiene gastritis', 'No comer picante', 'Omeprazol', 38, 130),
(4, 7890123456, 'Dolor de garganta, tiene amigdalitis', 'Tomar mucha agua', 'Amoxicilina', 37, 120),
(5, 8901234567, 'Dolor de espalda, tiene lumbalgia', 'No cargar peso', 'Ibuprofeno', 36, 110),
(6, 9012345678, 'Dolor de rodilla, tiene desgaste de rodilla', 'No hacer ejercicios', 'Paracetamol', 38, 130),
(7, 3123456789, 'Dolor de cabeza, tiene migraña', 'Tomar mucho liquido', 'Paracetamol', 36, 110),
(8, 1234567809, 'Dolor de estomago, tiene gastritis', 'No comer picante', 'Omeprazol', 38, 130),
(9, 2345678901, 'Dolor de garganta, tiene amigdalitis', 'Tomar mucha agua', 'Amoxicilina', 37, 120),
(10, 3456789012, 'Dolor de espalda, tiene lumbalgia', 'No cargar peso', 'Ibuprofeno', 36, 110);

SELECT * FROM Resultados;

------------------- TABLA HISTORIAL MEDICO -------------------

DROP TABLE IF EXISTS HistorialMedico;

CREATE TABLE HistorialMedico(
ID_Historia int primary key,
ID_Cita int not null,
Cedula_Paciente numeric(10) not null,
Cedula_Medico numeric(10) not null,
Servicio varchar (75) not null,
foreign key (Cedula_Paciente) references Pacientes (Cedula_Paciente),
foreign key (Cedula_Medico) references Medicos (Cedula_Medico),
foreign key (ID_Cita) references Citas (ID_Cita)
);

INSERT INTO HistorialMedico VALUES
(1, 1, 4567890123, 1234567890, 'Consulta General'),
(2, 2, 5678901234, 2345678901, 'Consulta General'),
(3, 3, 6789012345, 1234567890, 'Consulta General'),
(4, 4, 7890123456, 2345678901, 'Consulta General'),
(5, 5, 8901234567, 1234567890, 'Consulta General'),
(6, 6, 9012345678, 2345678901, 'Consulta General'),
(7, 7, 3123456789, 1234567890, 'Consulta General'),
(8, 8, 1234567809, 2345678901, 'Consulta General'),
(9, 9, 2345678901, 1234567890, 'Consulta General'),
(10, 10, 3456789012, 2345678901, 'Consulta General');

SELECT * FROM HistorialMedico;