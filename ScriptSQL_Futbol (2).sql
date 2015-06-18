DROP DATABASE IF EXISTS Futbol;

CREATE DATABASE Futbol;

USE FUTBOL;

DROP TABLE IF EXISTS equipos;

create table equipos(
    id_equipo int(2) primary key auto_increment,
    nombre varchar(50) not null,
    estadio varchar(50) unique not null,
    aforo int(6),
    ano_fundacion int(4),
    ciudad varchar(50)
);

DROP TABLE IF EXISTS jugadores;

create table jugadores(
    id_jugador int(3) primary key auto_increment,
    nombre varchar(50) not null,
	apellidos varchar(60),
	nacionalidad varchar(50) not null,
    fecha_nac DATE,
	id_equipo int(2),
    posicion varchar(20)not null,
	valor_jugador long,
	Altura_jugador float,
    constraint jug_ide_fk foreign key (id_equipo)
        references equipos (id_equipo) on delete cascade
);

DROP TABLE IF EXISTS partidos;

create table partidos(
    id_equipo_casa int(2),
    id_equipo_fuera int(2),
    fecha DATETIME,
    goles_casa int(2),
    goles_fuera int(2),
    observaciones TEXT,
    foreign key (id_equipo_casa)
        references equipos (id_equipo),
    foreign key (id_equipo_fuera)
        references equipos (id_equipo),
    primary key (id_equipo_casa,id_equipo_fuera),
    constraint partidos_ck check (id_equipo_casa != id_equipo_fuera)
);

DROP TABLE IF EXISTS goles;

create table goles(
    id_equipo_casa int(2),
    id_equipo_fuera int(2),
    minuto TIME,
    descripcion TEXT,
    id_jugador int(3),
    foreign key (id_equipo_casa)
        references equipos (id_equipo),
    foreign key (id_equipo_fuera)
        references equipos (id_equipo),
    foreign key (id_jugador)
        references jugadores (id_jugador) on delete cascade,
    constraint goles_pk primary key (id_equipo_casa,id_equipo_fuera,minuto)
);

USE FUTBOL;

#Insertar Registros Equipos


INSERT INTO equipos VALUES
#id/N.equipo/estadio/aforo/año de fundacion/ciudad

(1,'Real Madrid C.F','Santiago Bernabeu',81044,1902,'Madrid'),
(2,'F.C.Barcelona','Camp Nou',99354,1999,'Barcelona'),
(3,'Valencia C.F','Mestalla',55000,1919,'Valencia'),
(4,'Sevilla F.C','Ramón Sánchez-Pizjuán',45500, 1905,'Sevilla'),
(5,'Club Atlético de Madrid','Vicente Calderón',54907,1966,'Madrid'),
(6,'Malaga C.F','La Rosaleda',30044,1941,'Málaga');

INSERT INTO jugadores VALUES

#id/nombre/apellidos/nacionalidad/fch.Nac(año/mes/dia)/equipo/posicion

(1,'Cristiano Ronaldo','Do Santos Aveiro','Portugal','1985/05/02',1,'Delantero',10000,1.90),
(2,'James David','Rodríguez Rubio','Colombia','1991/07/12',1,'Media Punta',10000,1.90),
(3,'Iker','Casillas Fernández','España','1981/05/20',1,'Portero',10000,1.90),
(4,'Daniel','Carvajal Ramos','España','1992/01/11',1,'Lateral',10000,1.90),
(5,'Sergio','Ramos García','España','1986/03/30',1,'Defensa',10000,1.90),
(6,'Marcelo','Vieira da Silva','Brasil','1988/5/12',1,'Defensa',10000,1.90),

(7,'Lionel Andrés','Messi Cuccittini','Argentino','1987/06/24',2,'Delantero',10000,1.90),
(8,'Sergio','Busquets Burgos','España','1988/07/16',2,'Medio Centro',10000,1.90),
(9,'Andrés','Iniesta Luján','España','1984/05/11',2,'Medio Centro',10000,1.90),
(10,'Jordi','Alba Ramos','España','1989/03/21',2,'Lateral',10000,1.90),
(11,'Pedro Eliezer','Rodríguez Ledesma','España','1987/07/28',2,'Delantero',10000,1.90),
(12,'Luis Alberto','Suárez Díaz','Uruguay','1987/01/24',2,'Delantero',10000,1.90),

(13,'Francisco','Alcácer García','España','1993/08/30',3,'Delantero',10000,1.90),
(14,'Álvaro','Negredo Sánchez','España','1985/08/20',3,'Delantero',10000,1.90),
(15,'Jose Luis','Gayà Peña','España','1995/05/25',3,'Defensa',10000,1.90),
(16,'Enzo','Nicolás Pérez','Argentino','1986/02/22',3,'Medio Centro',10000,1.90),
(17,'Javier','Fuego Martínez','España','1984/01/04',3,'Medio Centro',10000,1.90),
(18,'Diego','Alves Carreira','Brasil','1985/07/24',3,'Portero',10000,1.90),

(19,'Grzegorz','Krychowiak','Polonia','1990/01/29',4,'Medio Centro',10000,1.90),
(20,'Aleix','Vidal Parreu','España','1989/08/21',4,'Medio Centro',10000,1.90),
(21,'Denis','Suárez Fernández','España','1994/01/06',4,'Medio Centro',10000,1.90),
(22,'Iago','Aspas Juncal','España','1987/08/01',4,'Delantero',10000,1.90),
(23,'Gerard','Deulofeu Lázaro','España','1994/03/13',4,'Delantero',10000,1.90),
(24,'Nicolás','Martín Pareja','Argentina','1984/01/19',4,'Defensa',10000,1.90),

(30,'Antoine','Griezmann','Francia','1991/03/21',5,'Delantero',10000,1.90),
(31,'Mario','Mandžukić','Polonia','1986/05/21',5,'Delantero',10000,1.90),
(32,'Miguel Ángel','Moyá Rumbo','España','1984/04/02',5,'Portero',10000,1.90),
(33,'Jesús','Gámez Duarte','España','1985/04/10',5,'Defensa',100000,1.90),
(34,'Fernando José','Torres Sanz','España','1984/03/24',5,'Delantero',10000,1.90),
(35,'Raúl Alonso','Jiménez Rodríguez','Mexico','1991/03/05',5,'Delantero',10000,1.90),

(36,'Carlos','Idriss Kameni','Camerún','1984/02/18',6,'Portero',10000,1.90),
(37,'Juan Miguel','Jiménez López','Esapaña','1993/05/20',6,'Delantero',10000,1.90),
(38,'Sergi','Darder Moll','España','1993/12/22',6,'Medio Centro',10000,1.90),
(39,'Samuel','Castillejo Azuaga','España','1995/01/18',6,'Media Punta',10000,1.90),
(40,'Marcos Alberto','Angeleri','Argentina','1983/04/07',6,'Defensa',10000,1.90),
(41,'Ricardo Jorge','Da Luz Horta','Portugal','1994/09/15',6,'Delantero',10000,1.90);

INSERT INTO partidos VALUES
(1,2,'2004/10/8 20:00:00',1,2,'Se aplazó al día siguiente'),
(1,3,'2004/7/8 21:00:00',2,0,'4 penaltis para el equipo de casa'),
(2,4,'2004/7/8 18:00:00',4,2,'Se inundó el vestuario de billetes de 500 €'),
(3,2,'2004/5/8 20:00:00',0,2,'Las abejas no dejaron de picar al árbitro'),
(3,4,'2004/1/8 20:00:00',0,0,'Un rayo se cargó la pelota'),
(4,1,'2004/2/4 21:00:00',2,2,'Los jugadores estaban algo distraidos');

INSERT INTO goles VALUES 
(1,2,'00:9:00','Golazo de cabeza',1),
(1,2,'01:00:00','Carambola',16),
(1,2,'01:27:00','Zurdazo impresionantes',12),
(1,3,'00:28:00','De penalti',1),
(1,3,'00:57:00','De falta',1),
(2,4,'00:17:00','Gran combinación',12),
(2,4,'00:21:00','De falta',12),
(2,4,'01:15:00','Desde el medio campo',34),
(2,4,'01:18:00','Centro chut',35),
(2,4,'01:22:00','De penalti',14),
(2,4,'01:29:00','De penalti',12),
(4,1,'01:07:00','En propia puerta',34),
(4,1,'01:18:00','regate impresionante y marca tras quedarse solo',36),
(3,2,'00:27:00','De falta',12),
(4,1,'01:23:00','Cabezazo desde el borde del area pequeña',1),
(4,1,'01:28:00','De penalti',1),
(3,2,'01:18:00','De cabeza',16);
