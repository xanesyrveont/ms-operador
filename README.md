# MS-PRESTAMOS

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
