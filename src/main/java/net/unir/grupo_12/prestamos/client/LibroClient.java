package net.unir.grupo_12.prestamos.client;

import net.unir.grupo_12.prestamos.entity.dto.Libro;
import net.unir.grupo_12.prestamos.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Component
public class LibroClient {

    @Value("${service.libros.url}")
    private String librosApi;

    private final RestClient restClient;
    private final RestTemplate restTemplate;

    public LibroClient(RestClient restClient, RestTemplate restTemplate) {
        this.restClient = restClient;
        this.restTemplate = restTemplate;
    }

    public Libro findById(Long id) {
        try {
            return restTemplate.getForObject(String.format(librosApi, id), Libro.class);
        } catch (Exception e) {
            return null;
        }
    }

    public Libro findById1(Long id) {
        return restClient.get()
                .uri(String.format(librosApi, id))
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    throw new NotFoundException(response.getStatusText());
                })
                .body(Libro.class);
    }
}
