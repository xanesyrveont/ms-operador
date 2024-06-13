package net.unir.grupo_12.prestamos.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.unir.grupo_12.prestamos.entity.dto.Detalle;
import net.unir.grupo_12.prestamos.service.PrestamoDetalleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/detalles")
@Tag(name = "Detalles", description = "Endpoint de Detalles")
public class PrestamoDetalleController {

    private final PrestamoDetalleService service;

    public PrestamoDetalleController(PrestamoDetalleService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Detalle> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.findAll(PageRequest.of(page, size));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Detalle findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Detalle detalle, BindingResult result) {
        service.save(detalle);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@NotNull @PathVariable Long id, @RequestBody @Valid Detalle detalle, BindingResult result) {
        service.save(new Detalle(
                id,
                detalle.libro(),
                detalle.fechaRetorno(),
                detalle.prestamo()
        ));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@NotNull @PathVariable Long id) {
        service.deleteById(id);
    }
}
