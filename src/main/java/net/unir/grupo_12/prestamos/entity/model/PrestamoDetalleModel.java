package net.unir.grupo_12.prestamos.entity.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "prestamo_detalle")
public class PrestamoDetalleModel extends BaseModel {
    private Long libroId;
    private LocalDate fechaRetorno;
    @JsonBackReference
    @ManyToOne(optional = false)
    private PrestamoModel prestamo;
}
