package net.unir.grupo_12.operador.entity.dto;

public record Libro(
        String id,
        String titulo,
        String autor,
        String isbn,
        Long anio,
        Long edicion,
        String editorial
) {
}
