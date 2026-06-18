CREATE DATABASE IF NOT EXISTS empresa_db;
USE empresa_db;

CREATE TABLE IF NOT EXISTS departamentos (
    id_depto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL
);

INSERT INTO departamentos (nombre_depto) VALUES 
    ('Recursos Humanos'),
    ('Finanzas'),
    ('Tecnología'),
    ('Marketing');

CREATE TABLE IF NOT EXISTS empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    departamento_id INT,
    foto VARCHAR(255),
    FOREIGN KEY (departamento_id) REFERENCES departamentos(id_depto)
);