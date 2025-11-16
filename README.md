# Repartir

## Ambiente

 * JDK 17
 * Docker
 * Chrome

## Ejecutar pruebas

Para ejecutar todas las pruebas

```
./gradlew check --info
```

## Para levantar en el ambiente local

```
./gradlew bootRun
```
## Acceso web

http://localhost:8080/

## Open API

http://localhost:8080/swagger-ui.html

##

Para que funcione
en el src/main/frontend ejecutar: $env:NODE_OPTIONS="--openssl-legacy-provider"
npm run build