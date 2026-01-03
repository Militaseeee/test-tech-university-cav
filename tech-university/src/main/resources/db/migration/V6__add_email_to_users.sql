-- Agregamos la columna email a la tabla de usuarios
ALTER TABLE users ADD COLUMN email VARCHAR(150) UNIQUE;