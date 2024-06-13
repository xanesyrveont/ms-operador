# MS-OPERADOR

Para levantar la base de datos, ejecuta el siguiente comando dentro de la carpeta del proyecto:

```bash
docker-compose up
```
## Construir 

Para crear el ejecutable:

```bash
./gradlew clean bootJar
``` 

## Ejecutar
Para arrancar la aplicación, ejecuta:

```bash
bash -c "java -jar build/libs/*.jar"
``` 

## Documentación

Puede consultar la documentación de los servicios a través del siguiente enlace: [Swagger](http://localhost:8080/docs/swagger-ui/index.html)
