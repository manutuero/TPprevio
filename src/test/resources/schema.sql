DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS provincia;
DROP TABLE IF EXISTS pais;
CREATE TABLE usuario
( username VARCHAR(25) PRIMARY KEY,
  password VARCHAR(8),
  activo BOOLEAN DEFAULT true
);
CREATE TABLE pais
( codigo_pais varchar(4) PRIMARY KEY,
  nombre_pais VARCHAR(25),
  UNIQUE KEY (nombre_pais)
);

CREATE TABLE provincia 
( codigo_provincia varchar(4) PRIMARY KEY,
  nombre_provincia varchar(40) ,
  fk_pais varchar(4),  
  UNIQUE KEY (nombre_provincia),
  FOREIGN KEY(FK_PAIS) REFERENCES pais(codigo_pais)
);

INSERT INTO usuario (username, password, activo) VALUES ('manu','1234',true); 
INSERT INTO usuario (username, password, activo) VALUES ('gabo','123',true);
INSERT INTO usuario (username, password, activo) VALUES ('admin','admin',true);
 