package net.unir.grupo_12.operador.repository;

import net.unir.grupo_12.operador.entity.model.PrestamoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<PrestamoModel, Long> {
}
