package net.unir.grupo_12.prestamos.service;

import net.unir.grupo_12.prestamos.entity.dto.Detalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrestamoDetalleService {
    Page<Detalle> findAll(Pageable pageable);

    Detalle findById(Long id);

    void save(Detalle detalle);

    void deleteById(Long id);
}
