CREATE TABLE enrollment_validations (
    id BIGSERIAL PRIMARY KEY,
    status VARCHAR(20) NOT NULL, -- Ej: 'APPROVED'
    validated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Relación 1-1: Una matrícula tiene una validación
ALTER TABLE enrollments ADD COLUMN validation_id BIGINT;
ALTER TABLE enrollments ADD CONSTRAINT fk_enrollment_validation
FOREIGN KEY (validation_id) REFERENCES enrollment_validations(id);