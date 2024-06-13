package net.unir.grupo_12.operador.service;

import net.unir.grupo_12.operador.entity.dto.Detalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrestamoDetalleService {
    Page<Detalle> findAll(Pageable pageable);

    Detalle findById(Long id);

    void save(Detalle detalle);

    void deleteById(Long id);
}
