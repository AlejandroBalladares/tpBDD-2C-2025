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

Aclaraciones:
1-Para que funcione tuve que ejecutar en el src/main/frontend: $env:NODE_OPTIONS="--openssl-legacy-provider"
luego tuve que hacer un "npm run build" y anduvo

2-En mi computadora los tests de la catedra a veces fallaban sin algún motivo pero en general pasaban todos. Además se probó manualmente la funcionalidad y funcionó.