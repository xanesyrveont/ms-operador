package net.unir.grupo_12.prestamos.repository;

import net.unir.grupo_12.prestamos.entity.model.PrestamoDetalleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoDetalleRepository extends JpaRepository<PrestamoDetalleModel, Long> {
}
