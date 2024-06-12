package net.unir.grupo_12.prestamos.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record Detalle(
        Long id,
        @JsonProperty("libro_id")
        Long libroId,
        @JsonProperty("fecha_retorno")
        LocalDate fechaRetorno,
        Prestamo prestamo
) {
}
