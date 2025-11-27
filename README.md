# Challenge Conversor de Monedas

Este es un conversor de monedas simple desarrollado en Java como parte de un desafío de programación. La aplicación permite a los usuarios convertir cantidades entre diferentes monedas utilizando las tasas de cambio más recientes obtenidas de una API externa.

## Características

*   Conversión de moneda en tiempo real.
*   Interfaz de línea de comandos (CLI) interactiva.
*   Utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio.
*   Manejo de errores para entradas inválidas.

## Prerrequisitos

Para poder ejecutar este proyecto, necesitarás tener instalado lo siguiente:

*   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) (versión 11 o superior).
*   [Apache Maven](https://maven.apache.org/download.cgi) para la gestión de dependencias y la construcción del proyecto.

**Importante:** Asegúrate de que el comando `mvn` esté disponible en la variable de entorno `PATH` de tu sistema. Si recibes un error como `'mvn' is not recognized`, significa que Maven no está instalado correctamente o no está en el `PATH` de tu sistema.

## Configuración

1.  **Clona el repositorio:**
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd Challenge_conversor_monedas
    ```

2.  **Configura tu API Key:**
    La aplicación requiere una clave de API de ExchangeRate-API. Debes agregar tu clave en el código. Busca el lugar donde se hace la llamada a la API (probablemente en `src/main/java/com/conversor/Main.java` o una clase de servicio) y reemplaza el marcador de posición con tu clave.

    *Busca una línea similar a esta y añade tu clave:*
    ```java
    String apiKey = "TU_API_KEY";
    ```

## Uso

Una vez que hayas configurado el proyecto y tu API key, puedes compilarlo y ejecutarlo usando Maven 
    ```

La aplicación se iniciará en tu consola y te guiará a través de las opciones de conversión.
