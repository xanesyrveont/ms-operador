package net.unir.grupo_12.prestamos.repository;

import net.unir.grupo_12.prestamos.entity.model.PrestamoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<PrestamoModel, Long> {
}
