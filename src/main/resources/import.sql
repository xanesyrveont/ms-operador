INSERT INTO prestamo (id, usuario_id, fecha_prestamo, fecha_devolucion, created_at, visible) VALUES (1, 1, '2024-06-12', '2024-06-19', '2024-06-12T10:00:00', true);

INSERT INTO prestamo_detalle (id, libro_id, prestamo_id, fecha_retorno, created_at, visible) VALUES (1, 3, 1, '2024-06-19', '2024-06-12T10:00:00', true);
INSERT INTO prestamo_detalle (id, libro_id, prestamo_id, fecha_retorno, created_at, visible) VALUES (2, 4, 1, '2024-06-20', '2024-06-12T10:00:00', true);
