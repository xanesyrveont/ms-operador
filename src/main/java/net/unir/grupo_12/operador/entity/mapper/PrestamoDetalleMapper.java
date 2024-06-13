package net.unir.grupo_12.operador.entity.mapper;

import net.unir.grupo_12.operador.client.LibroClient;
import net.unir.grupo_12.operador.entity.dto.Detalle;
import net.unir.grupo_12.operador.entity.dto.Libro;
import net.unir.grupo_12.operador.entity.dto.Prestamo;
import net.unir.grupo_12.operador.entity.model.PrestamoDetalleModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PrestamoDetalleMapper implements Function<PrestamoDetalleModel, Detalle> {

    private final LibroClient client;

    public PrestamoDetalleMapper(LibroClient client) {
        this.client = client;
    }

    @Override
    public Detalle apply(PrestamoDetalleModel detalleModel) {
        Libro libro = client.findById(detalleModel.getLibroId());
        return new Detalle(
                detalleModel.getId(),
                libro,
                detalleModel.getFechaRetorno(),
                new Prestamo(
                        detalleModel.getPrestamo().getId(),
                        detalleModel.getPrestamo().getUsuarioId(),
                        detalleModel.getPrestamo().getFechaPrestamo(),
                        detalleModel.getPrestamo().getFechaDevolucion()
                )
        );
    }
}
