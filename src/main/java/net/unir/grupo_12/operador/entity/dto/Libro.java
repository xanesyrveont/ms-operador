package net.unir.grupo_12.operador.entity.dto;

import java.time.LocalDate;

public record Libro(
        String id,
        String isbn,
        String titulo,
        String autor,
        String genero,
        String portada,
        Long edicion,
        String editorial,
        LocalDate fechaPublicacion
) {
}
