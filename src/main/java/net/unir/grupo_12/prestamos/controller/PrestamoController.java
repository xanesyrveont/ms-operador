package net.unir.grupo_12.prestamos.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.unir.grupo_12.prestamos.entity.dto.Prestamo;
import net.unir.grupo_12.prestamos.service.PrestamoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prestamos")
public class PrestamoController {

    private final PrestamoService service;

    public PrestamoController(PrestamoService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Prestamo> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.findAll(PageRequest.of(page, size));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prestamo findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Prestamo prestamo, BindingResult result) {
        service.save(prestamo);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@NotNull @PathVariable Long id, @RequestBody @Valid Prestamo prestamo, BindingResult result) {
        service.save(new Prestamo(
                id,
                prestamo.usuarioId(),
                prestamo.fechaPrestamo(),
                prestamo.fechaDevolucion()
        ));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@NotNull @PathVariable Long id) {
        service.deleteById(id);
    }

}
