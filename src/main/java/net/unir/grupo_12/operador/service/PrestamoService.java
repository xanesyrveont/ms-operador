package net.unir.grupo_12.operador.service;

import net.unir.grupo_12.operador.entity.dto.Prestamo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrestamoService {
    Page<Prestamo> findAll(Pageable pageable);

    Prestamo findById(Long id);

    void save(Prestamo prestamo);

    void deleteById(Long id);
}
