DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario
( username VARCHAR(25),
  password VARCHAR(8),
  activo BOOLEAN DEFAULT true
);

INSERT INTO usuario (username, password, activo) VALUES ('manu','1234',true);
INSERT INTO usuario (username, password, activo) VALUES ('gabi','5678',true);
