package net.unir.grupo_12.prestamos.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record Prestamo(
        Long id,
        @JsonProperty("usuario_id")
        Long usuarioId,
        @JsonProperty("fecha_prestamo")
        LocalDate fechaPrestamo,
        @JsonProperty("fecha_devolucion")
        LocalDate fechaDevolucion
) {
}
