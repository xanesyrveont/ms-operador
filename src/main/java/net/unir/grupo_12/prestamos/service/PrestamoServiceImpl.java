package net.unir.grupo_12.prestamos.service;

import net.unir.grupo_12.prestamos.entity.dto.Prestamo;
import net.unir.grupo_12.prestamos.entity.mapper.PrestamoMapper;
import net.unir.grupo_12.prestamos.entity.model.PrestamoModel;
import net.unir.grupo_12.prestamos.exception.NotFoundException;
import net.unir.grupo_12.prestamos.repository.PrestamoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoMapper mapper;
    private final PrestamoRepository repository;

    public PrestamoServiceImpl(PrestamoMapper mapper, PrestamoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Page<Prestamo> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper);
    }

    @Override
    public Prestamo findById(Long id) {
        return repository.findById(id)
                .map(mapper)
                .orElseThrow(() -> new NotFoundException("No se encontro Prestamo con id: " + id));

    }

    @Override
    public void save(Prestamo prestamo) {
        Long id = prestamo.id() != null ? prestamo.id() : 0L;
        repository.findById(id).ifPresentOrElse(
                model -> {
                    model.setUsuarioId(prestamo.usuarioId());
                    model.setFechaPrestamo(prestamo.fechaPrestamo());
                    model.setFechaDevolucion(prestamo.fechaDevolucion());
                    repository.save(model);
                },
                () -> {
                    PrestamoModel model = new PrestamoModel();
                    model.setUsuarioId(prestamo.usuarioId());
                    model.setFechaPrestamo(prestamo.fechaPrestamo());
                    model.setFechaDevolucion(prestamo.fechaDevolucion());
                    repository.save(model);
                }
        );
    }

    @Override
    public void deleteById(Long id) {
        if (findById(id) != null) {
            repository.deleteById(id);
        }
    }
}
