package net.unir.grupo_12.prestamos.entity.mapper;

import net.unir.grupo_12.prestamos.entity.dto.Prestamo;
import net.unir.grupo_12.prestamos.entity.model.PrestamoModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PrestamoMapper implements Function<PrestamoModel, Prestamo> {
    @Override
    public Prestamo apply(PrestamoModel prestamoModel) {
        return new Prestamo(
                prestamoModel.getId(),
                prestamoModel.getUsuarioId(),
                prestamoModel.getFechaPrestamo(),
                prestamoModel.getFechaDevolucion()
        );
    }
}
