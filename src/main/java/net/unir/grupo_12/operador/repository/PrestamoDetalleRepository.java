package net.unir.grupo_12.operador.repository;

import net.unir.grupo_12.operador.entity.model.PrestamoDetalleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoDetalleRepository extends JpaRepository<PrestamoDetalleModel, Long> {
}
