DROP TABLE usuario IF EXISTS;

CREATE TABLE usuario
( username VARCHAR(25),
  password VARCHAR(8),
  activo BOOLEAN DEFAULT True
);

INSERT INTO usuario (username, password, activo) VALUES ('manu','1234',true);