package net.unir.grupo_12.operador.entity.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        String path,
        String message,
        String error,
        int statusCode,
        LocalDateTime timestamp
) {
}
