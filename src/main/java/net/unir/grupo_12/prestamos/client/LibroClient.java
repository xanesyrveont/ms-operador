package net.unir.grupo_12.prestamos.client;

import net.unir.grupo_12.prestamos.entity.dto.Libro;
import net.unir.grupo_12.prestamos.exception.BadRequestException;
import net.unir.grupo_12.prestamos.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class LibroClient {

    @Value("${service.libros.url}")
    private String librosApi;

    private final RestClient.Builder restClient;

    public LibroClient(RestClient.Builder restClient) {
        this.restClient = restClient;
    }

    public Libro findById(Long id) {
        return restClient.build().get()
                .uri(String.format(librosApi, id))
                .retrieve()
                .onStatus(status -> status.value() == 400, (request, response) -> {
                    throw new BadRequestException(response.getStatusText());
                })
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    throw new NotFoundException(response.getStatusText());
                })
                .body(Libro.class);
    }
}
