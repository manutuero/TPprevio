DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS state;
DROP TABLE IF EXISTS country;

CREATE TABLE usuario
( username VARCHAR(25) PRIMARY KEY,
  password VARCHAR(8),
  activo BOOLEAN DEFAULT true
);

CREATE TABLE country
( codigo_country VARCHAR(4) PRIMARY KEY,
  nombre_country VARCHAR(25),
  UNIQUE KEY (nombre_country)
);

CREATE TABLE state 
( codigo_state VARCHAR(4) PRIMARY KEY,
  nombre_state VARCHAR(40) ,
  fk_country VARCHAR(4),  
  UNIQUE KEY (nombre_state),
  FOREIGN KEY(FK_country) REFERENCES country(codigo_country)
);

INSERT INTO usuario (username, password, activo) VALUES ('manu','1234',true); 
INSERT INTO usuario (username, password, activo) VALUES ('gabo','123',true);
INSERT INTO usuario (username, password, activo) VALUES ('admin','admin',true);
 