package net.unir.grupo_12.operador.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record Detalle(
        Long id,
        Libro libro,
        @JsonProperty("fecha_retorno")
        LocalDate fechaRetorno,
        Prestamo prestamo
) {
}
