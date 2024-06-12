package net.unir.grupo_12.prestamos.entity.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "prestamo")
public class PrestamoModel extends BaseModel {

    private Long usuarioId;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    @JsonManagedReference
    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrestamoDetalleModel> detalles;

}
