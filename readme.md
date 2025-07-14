# Proyecto de Clima - Microservicios con Spring Boot y Docker

Este proyecto simula un sistema climático distribuido, compuesto por varios microservicios. Cada uno tiene una responsabilidad distinta: generar, recolectar, almacenar y analizar datos del clima (temperatura y humedad).

Todo está desarrollado en Java con Spring Boot 3.5.3 y empaquetado con Docker. No necesitas instalar cada servicio por separado — Docker lo hace por ti.

---

##  ¿Qué contiene este proyecto?

| Servicio            | Puerto | ¿Qué hace?                                                 |
|---------------------|--------|------------------------------------------------------------|
| **sensor-service**   | 8080   | Simula un sensor: genera datos de temperatura y humedad.  |
| **collector-service**| 8081   | Recibe esos datos y los reenvía a otros servicios.         |
| **storage-service**  | 8082   | Guarda los datos en una base de datos PostgreSQL.         |
| **alert-service**    | 8083   | Detecta si hay condiciones peligrosas (alertas).          |
| **frontend-service** | 8084   | Punto de entrada para el usuario (API externa).           |
| **db (PostgreSQL)**  | 5432   | Base de datos para el `storage-service`.                  |

---

## ⚙️ ¿Qué necesitas tener instalado?

Antes de empezar, asegúrate de tener lo siguiente:

- **Java 17** (https://adoptium.net)
- **Maven** (https://maven.apache.org/download.cgi)
- **Docker y Docker Compose** (https://www.docker.com/products/docker-desktop)

Puedes verificar si los tienes instalados así:

```bash

java -version
mvn -v
docker -v
docker compose version

```



## Estructura esperada
```bash
/clima-microservicios/
│
├── docker-compose.yml
├── sensor-service/
│   └── Dockerfile
│   └── target/sensor-service-0.0.1-SNAPSHOT.jar
├── collector-service/
│   └── Dockerfile
├── storage-service/
│   └── Dockerfile
├── alert-service/
│   └── Dockerfile
├── frontend-service/
│   └── Dockerfile
```
## Paso 1 compilar los microservicios
Cada servicio necesita ser empaquetado antes de usar Docker. Ejecuta estos comandos desde la raíz del servicio(tienes que hacer los servicios 1 a 1 ):
```bash
mvn clean package -DskipTests
```
## Paso2 Levantar todos los servicios con Docker
Desde la raíz del proyecto (donde está docker-compose.yml), ejecuta:

```bash
docker compose up --build
```



## Paso 3 Consumir el servicio
Ingresar en la url
```bash
http://localhost:8084
```

