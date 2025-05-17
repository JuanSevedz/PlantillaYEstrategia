# PlantillaYEstrategia

***

## Grupo 1 (Integrantes)

* Juan Sebastian Vega Diaz 20231020087
* Felipe Cardenas Mora 20231020145
* Yuber Alejandro Bohorquez Roa 20231020195
* David Neira 20192020086
* Juan Felipe Chibuque Lopez  20232020093

***

### Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

* [Java JDK 11 o superior](https://adoptium.net/)
* [Apache Maven](https://maven.apache.org/install.html)

Puedes verificar si están instalados con los siguientes comandos:

```bash
java -version
mvn -version
```

***

## Configurar la API Key

Para que el proyecto funcione correctamente, necesitas una API Key de [OpenRouteService](https://openrouteservice.org/).

### Pasos

1. Regístrate o inicia sesión en [openrouteservice.org](https://openrouteservice.org/).
2. Ve a tu perfil y genera una nueva **API Key**.
3. Abre el archivo `RutaCarretera.java`.
4. Reemplaza el texto `'API_KEY'` por tu clave personal.

Así:

```java
// Antes
private static final String API_KEY = "API_KEY";

// Después
private static final String API_KEY = "tu_clave_aquí";
// Linea 14
```

***

## Instrucciones para calcular la ruta

1. En la terminal pararse sobre el folder Strategy

```bash
cd Strategy
```

2. Hacer

```bash
mvn clean install
mvn exec:java
```
