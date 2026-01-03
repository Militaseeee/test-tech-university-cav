-- Agregamos la columna que falta para guardar el ID del servicio externo
ALTER TABLE enrollment_validations ADD COLUMN external_check_id VARCHAR(100);