package net.unir.grupo_12.prestamos.entity.dto;

public record Libro(
        Long id,
        String titulo,
        String autor,
        String isbn,
        Long anio,
        Long edicion,
        String editorial
) {
}
