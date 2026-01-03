CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE students (
    id BIGSERIAL PRIMARY KEY, -- BIGSERIAL en lugar de AUTO_INCREMENT
    document_number VARCHAR(20) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE courses (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    credits INT
);

CREATE TABLE enrollments (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT,
    course_id BIGINT,
    enrollment_date TIMESTAMP, -- TIMESTAMP en lugar de DATETIME
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES courses(id)
);