# Challenge Conversor de Moneda - Alura Latam G8<br>Especialización Back-End

## Descripción
Reto que se desarrolla como parte de la fase Java Orientado a Objetos G8 - ONE.

>En este desafío, desarrollarás una aplicación llamada "Conversor de Monedas", en la que se realizarán solicitudes a una API de tasas de cambio, manipulando datos en formato JSON y finalmente, se filtrarán y mostrarán las monedas de interés.

Tomado de la **[plantilla del desafío](https://trello.com/b/RU41cvaQ/conversor-de-moneda-challenge-one-java-back-end)**

## Estado del desafío
:white_check_mark: **2025-05-07**: *Crear el repositorio del proyecto en GitHub.*

:white_check_mark: **2025-05-07**: *Configuración de entorno (Registro en Herramienta API, Prueba de peticiones GET en herramienta Postman).*

:white_check_mark: **2025-05-07**: *Conociendo la API para traer datos: [exchangerate-api](https://www.exchangerate-api.com).*

:white_check_mark: **2025-05-07**: *Importando la biblioteca Gson en Intellij.*

:white_check_mark: **2025-05-08**: *Construyendo el Cliente para Solicitudes (HttpClient), la solicitud (HttpRequest) y la respuesta (HttpResponse)*

:white_check_mark: **2025-05-11**: *Analizando la respuesta en formato JSON, utilizando las clases proporcionadas por la librería Gson, como son JsonParser y JsonObject*

:white_check_mark: **2025-05-12**: *Se realiza el filtrado de monedas utilizando para el desafío los siguientes códigos:*
- *ARS - Peso argentino*
- *BOB - Boliviano boliviano*
- *BRL - Real brasileño*
- *CLP - Peso chileno*
- *COP - Peso colombiano*
- *USD - Dólar estadounidense*

:white_check_mark: **2025-05-13**: *Se ejecuta la consulta a la api de conversión entre tipos de monedas, se establece una clase para la configuración de la consulta a la API*

:white_check_mark: **2025-05-13**: *Se distribuye el llamado a la solicitud, petición, respuesta Http y consulta con la librería Gson, en una clase Conversor.*

:white_check_mark: **2025-05-14**: *Se hace uso de ĺas clases FileWriter, FileReader y BufferedReader para escritura y lectura del archivo historial de conversiones.*

:white_check_mark: **2025-05-14**: *Validación de posibles casos de error en ejecución, consulta de api, conversión de tipos de moneda, lectura y escritura de archivo.*

:cherries: **2025-05-14**: *Se crea la interfáz de usuario, donde puede elegir entre tipos de conversión y generar historial de consultas.*

## Funcionalidades
- **Consumo de la API**: .

- **Análisis de la respuesta JSON**: .

- **Filtro de monedas**: .

- **Exhibición de resultados a los usuarios**: .

- **Historial de conversiones**: .

## Vista previa
<img src="https://live.staticflickr.com/65535/54521320142_9de0aed0a9_w_d.jpg" width=400><br>
<img src="https://live.staticflickr.com/65535/54522188321_619edf15d1_w_d.jpg" width=400><br>
<img src="https://live.staticflickr.com/65535/54522438723_f2d25b868d_w_d.jpg" width=400>


## Acceso al proyecto
Puedes descargarlo **[AQUI](https://github.com/oabm77/challenge-conversor-moneda/archive/refs/heads/master.zip)**

## Tecnologías utilizadas
- Lenguaje de programación Java
- Librería Gson, desarrollada por Google
- Postman (Herramienta para probar API REST)
- APIs para traer datos referenteas al intercambio de divisas [ExchangeRate-API](https://www.exchangerate-api.com), [Open Exchange Rates](https://openexchangerates.org) y [Coingecko](https://www.coingecko.com/en/api).

## Autores
| [<img src="https://www.aluracursos.com/assets/img/home/alura-logo.1730889068.svg" width=115 height=115 style="background-color:black;"><br><sub>Equipo Alura Latam</sub>](https://www.aluracursos.com) |  [<img src="https://live.staticflickr.com/65535/54296423135_023657de24_q_d.jpg" width=115><br><sub>Omar Bautista</sub>]([https://udocumentos.blogspot.com) |
| :---: | :---: |