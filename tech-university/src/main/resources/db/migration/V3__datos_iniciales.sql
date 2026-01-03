-- 1. Insertar Usuarios para Autenticación (Contraseña: password123)
-- El hash corresponde a 'password123' en BCrypt
INSERT INTO users (username, password, role) VALUES
('admin', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOn2', 'ADMIN'),
('student_user', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOn2', 'STUDENT');

-- 2. Insertar información del Estudiante (Relacionado con el usuario student_user si fuera necesario)
INSERT INTO students (document_number, first_name, last_name, email) VALUES
('10101010', 'Cami', 'Velez', 'cami.student@tech.edu'),
('20202020', 'Admin', 'User', 'admin@tech.edu');

-- 3. Insertar algunos Cursos para tener qué matricular
INSERT INTO courses (name, credits) VALUES
('Arquitectura Hexagonal Avanzada', 5),
('Microservicios con Spring Cloud', 4),
('Despliegue con Docker y Kubernetes', 3);