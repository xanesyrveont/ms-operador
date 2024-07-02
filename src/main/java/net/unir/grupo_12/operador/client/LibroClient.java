package net.unir.grupo_12.operador.client;

import net.unir.grupo_12.operador.entity.dto.Libro;
import net.unir.grupo_12.operador.exception.BadRequestException;
import net.unir.grupo_12.operador.exception.NotFoundException;
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

    public Libro findById(String id) {
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
