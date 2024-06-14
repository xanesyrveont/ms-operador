package net.unir.grupo_12.operador.service;

import net.unir.grupo_12.operador.client.LibroClient;
import net.unir.grupo_12.operador.entity.dto.Detalle;
import net.unir.grupo_12.operador.entity.dto.Libro;
import net.unir.grupo_12.operador.entity.mapper.PrestamoDetalleMapper;
import net.unir.grupo_12.operador.entity.model.PrestamoDetalleModel;
import net.unir.grupo_12.operador.entity.model.PrestamoModel;
import net.unir.grupo_12.operador.exception.NotFoundException;
import net.unir.grupo_12.operador.repository.PrestamoDetalleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PrestamoDetalleServiceImpl implements PrestamoDetalleService {

    private final LibroClient client;
    private final PrestamoDetalleMapper mapper;
    private final PrestamoDetalleRepository repository;

    public PrestamoDetalleServiceImpl(LibroClient client, PrestamoDetalleMapper mapper, PrestamoDetalleRepository repository) {
        this.client = client;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Page<Detalle> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper);
    }

    @Override
    public Detalle findById(Long id) {
        return repository.findById(id)
                .map(mapper)
                .orElseThrow(() -> new NotFoundException("No se encontro Detalle con id: " + id));
    }

    @Override
    public void save(Detalle detalle) {
        Long id = detalle.id() != null ? detalle.id() : 0L;

        Libro libro = client.findById(detalle.libro().id());

        repository.findById(id).ifPresentOrElse(
                model -> {
                    PrestamoModel prestamoModel = new PrestamoModel();
                    prestamoModel.setId(detalle.prestamo().id());
                    prestamoModel.setUsuarioId(detalle.prestamo().usuarioId());
                    prestamoModel.setFechaPrestamo(detalle.prestamo().fechaPrestamo());
                    prestamoModel.setFechaDevolucion(detalle.prestamo().fechaDevolucion());

                    model.setPrestamo(prestamoModel);
                    model.setLibroId(libro.id());
                    model.setFechaRetorno(detalle.fechaRetorno());
                    repository.save(model);
                },
                () -> {
                    PrestamoDetalleModel model = new PrestamoDetalleModel();
                    model.setLibroId(libro.id());

                    PrestamoModel prestamoModel = new PrestamoModel();
                    prestamoModel.setId(detalle.prestamo().id());

                    model.setPrestamo(prestamoModel);
                    model.setFechaRetorno(detalle.fechaRetorno());
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
