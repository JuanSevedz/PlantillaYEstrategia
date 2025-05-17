# PlantillaYEstrategia

***

## Grupo 1 (Integrantes)

* Juan Sebastian Vega Diaz 20231020087  
* Felipe Cardenas Mora 20231020145  
* Yuber Alejandro Bohorquez Roa 20231020195  
* David Neira 20192020086  
* Juan Felipe Chibuque Lopez 20232020093  

***

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

* [Java JDK 11 o superior](https://adoptium.net/)
* [Apache Maven](https://maven.apache.org/install.html)

Verifica su instalación con:

```bash
java -version
mvn -version
```

***

## Configurar la API Key

Este proyecto utiliza la API de [OpenRouteService](https://openrouteservice.org/) para calcular rutas reales.

### 🔐 Pasos para configurar tu API key:

1. Regístrate o inicia sesión en [openrouteservice.org](https://openrouteservice.org/).
2. Genera tu API Key desde tu perfil.
3. Crea un archivo llamado `.env` en la carpeta `Strategy/` con este contenido:

```env
API_KEY=tu_clave_aqui
```

**⚠️ Importante:** No compartas públicamente tu API key. El sistema la cargará automáticamente mediante la librería `dotenv`.

***

## Instrucciones para ejecutar el programa

### 1. Clona el repositorio

```bash
git clone https://github.com/JuanSevedz/PlantillaYEstrategia.git
cd PlantillaYEstrategia/Strategy
```

### 2. Ejecuta el programa

```bash
mvn clean compile exec:java
```

> 💡 Puedes usar `mvn exec:java` si ya has compilado antes con `mvn compile`.

***

## ¿Qué hace el programa?

Este es un sistema de navegación para viajeros ocasionales que implementa el patrón de diseño **Strategy**, lo que permite calcular diferentes tipos de rutas de manera flexible.

### Tipos de ruta disponibles:

- 🚗 Ruta por carretera  
- 🚶 Ruta peatonal  
- 🚌 Ruta en transporte público  
- 🏛️ Ruta turística  
- 🚴 Ruta ciclista  

El usuario elige el tipo de ruta desde la terminal, y el sistema calcula la distancia, duración estimada e instrucciones reales paso a paso, usando la API de OpenRouteService.

***

## Estructura del proyecto

```
PlantillaYEstrategia/
└── Strategy/
    ├── .env
    ├── pom.xml
    └── src/
        └── main/
            └── java/
                └── com/
                    └── navegador/
                        ├── Cliente.java
                        ├── Navegador.java
                        ├── EstrategiaRuta.java
                        ├── RutaCarretera.java
                        ├── RutaPeatonal.java
                        ├── RutaTransportePublico.java
                        ├── RutaTuristica.java
                        └── RutaCiclista.java
```

***

## Licencia

Proyecto académico desarrollado para fines educativos. Uso libre con fines didácticos.
