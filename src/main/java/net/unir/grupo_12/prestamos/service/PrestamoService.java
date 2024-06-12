package net.unir.grupo_12.prestamos.service;

import net.unir.grupo_12.prestamos.entity.dto.Prestamo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrestamoService {
    Page<Prestamo> findAll(Pageable pageable);

    Prestamo findById(Long id);

    void save(Prestamo prestamo);

    void deleteById(Long id);
}
