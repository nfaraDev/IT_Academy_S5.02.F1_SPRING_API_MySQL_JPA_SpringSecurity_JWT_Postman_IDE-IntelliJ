# 
<p >
  <img src="src/main/resources/images/logos.png" width="100" />

</p>

## Spring Boot, Hibernate, MySQL, Security,JWT, Postman

### Description

Proyecto final, crear una API 100%

Nivel 1

Es un juego de dados se juega con dos dados. En caso de que el resultado de la suma de los dos dados sea 7, la partida es ganada, si no es perdida.
Un jugador/a bote ver un listado de todas las tiradas que ha hecho y el porcentaje de éxito.
Para poder jugar al juego y realizar una tirada, un usuario/aria se tiene que registrar con un nombre no repetido. Al crearse, se le asigna un 
identificador numérico único y una fecha de registro. Si el usuario/aria así lo desea, puedes no añadir ningún nombre y se llamará “ANÓNIMO”.
Puede haber más de un jugador “ANÓNIMO”.
Cada jugador/a bote ver un listado de todas las tiradas que ha hecho, con el valor de cada dado y si se ha ganado o no la partida. Además, puede 
saber su porcentaje de éxito por todas las tiradas que ha hecho.
No se puede eliminar una partida en concreto, pero sí que se puede eliminar todo el listado de tiradas por un jugador/a.
El software tiene que permitir listar todos los jugadores/se que hay al sistema, el porcentaje de éxito de cada jugador/a y el porcentaje de éxito
mediano de todos los jugadores/se en el sistema.
El software tiene que respetar los principales patrones de diseño.

**NOTAS**
Persistencia: utiliza como base de datos MySQL. 

Tienes que tener en cuenta los siguientes detalles de construcción:

**URL's** 

TABLA: /players: crea un jugador/a.

HEDE /players: modifica el nombre del jugador/a.

TABLA /players/{*id}/*games/ : un jugador/a específico realiza una tirada de los dados.

DELETE /players/{*id}/*games: elimina las tiradas del jugador/a.

GET /players/: devuelve el listado de todos los jugadores/se del sistema con su porcentaje mediano de éxitos.

GET /players/{*id}/*games: devuelve el listado de jugadas por un jugador/a.

GET /players/*ranking: devuelve el ranking medio de todos los jugadores/se del sistema. Es decir, el porcentaje mediano de éxitos.

GET /players/*ranking/*loser: devuelve el jugador/a con peor porcentaje de éxito.

GET /players/*ranking/*winner: devuelve el jugador con peor porcentaje de éxito.

**PROYECTO: JUEGO DE DADOS** 

**Application.properties **

Data Base= MySQL:db_game

server.port=9001

spring.datasource.url=jdbc:mysql://localhost:3307/db_game

spring.datasource.username=root

spring.datasource.password=

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

### Postman summary 

Endpoints filter by pre-authorization:
```
POST/ http://localhost:9001/auth/register
By Register: Donde el ID debe ser el mismo que el ID del usuario relacionado con el token JWT

POST/ http://localhost:9001/auth/login
By Login: Donde con el email y password se loga el jugador y le devuelve la autorizacion con un token JWT

POST/ http://localhost:9001/api/player/add
By agregar player: con el token jwt del jugador logado podemos añadir mas jugadores

PUT/ http://localhost:9001/api/player/update/1
By modificar player: con el token jwt, el jugador n1 (era Calimero ) logado modificar al jugador y poner Mono en su lugar

POST / http://localhost:9001/api/game/1/games
By tirar dados el jugador 1: con el token jwt, el jugador N1 (Mono) tira los dados pierde y sigue tirando hasta que gana

GET/ http://localhost:9001/api/player/
By listar todos los jugadores: con el token jwt, el jugador listamos (all/player) y nos da una lista de 4 jugadores

GET/  http://localhost:9001/api/game/3/games
By listamos todas las jugadas del jugador 3: con el token jwt, el jugador N3(Mickey) listamos todas las jugadas

GET/ http://localhost:9001/api/game/ranking/loser
By peor Porcentaje Exito: con el token jwt, nos da el peor porcentaje de exito 20% del Jugador N1 Mono

GET/ http://localhost:9001/api/game/ranking/winner
By mejor Porcentaje de Exito: con el token jwt, nos da el mejor porcentaje de exito 25% del Jugador N3 Mickey

DELETE/ http://localhost:9001/api/game/6/games
By eliminar el jugador N6(Lobo)

### References:

- JPA entity relationships
  - [Jaxx- Spring Boot | DTOs con Spring Data JPA y Spring Boot-Parte 1 ](https://www.youtube.com/watch?v=H8QmmbFs8tk)
  - [Jaxx- Spring Boot | DTOs con Spring Data JPA y Spring Boot-Parte 2 ](https://www.youtube.com/watch?v=HvLbN9L6_Hg)

- MySQL
  - [Teddy Smith- Spring Boot For Beginners - Architecture Overview ] (https://www.youtube.com/watch?v=2tUHNRp7Auo)

- JWT - SpringBoot Security
  - [La Tecnologia Avanza - Spring Boot Token based Authentication with Spring Security & JWT](https://www.youtube.com/watch?v=ZzpDyIJizjo)

- Postman
  - [Geek QA- Pruebas de APIs con POSTMAN ](https://desarrolloweb.com/articulos/como-usar-postman-probar-api)

  
##Explicacion Arquitectura Paquete Seguridad en el Proyecto "JUEGO DE DADOS":

La estructura de este proyecto parece sigue este patrón.

Aquí te explicaré cómo funciona cada componente:

     PAQUETE AUTH:

-CLASE AuthenticationController: Este es el controlador que maneja las solicitudes de autenticación. Recibe las credenciales
 del usuario (nombre de usuario y contraseña) y las pasa al servicio de autenticación para su procesamiento.

-CLASES AuthenticationRequest y AuthenticationResponse: Estas clases representan los objetos de solicitud y respuesta
utilizados en el proceso de autenticación.La solicitud contiene las credenciales del usuario y la respuesta contiene el token
de autenticación JWT.

-CLASE AuthenticationService: Este es el servicio que maneja la lógica de autenticación. Utiliza el servicio de usuario para
verificar las credenciales del usuario y genera un token JWT si las credenciales son válidas.

-CLASE RegisterRequest: Esta clase representa la solicitud de registro de un nuevo usuario. Contiene los detalles necesarios
para crear una nueva cuenta de usuario.

    PAQUETE CONFIG:

-CLASES ApplicationConfig y SecurityConfig: Estas clases contienen la configuración de la aplicación y la seguridad, respectivamente.
Proporcionan la configuración necesaria para Spring Boot y Spring Security, incluyendo la configuración de los filtros de seguridad,
los servicios de autenticación y las rutas de la API.

     PAQUETE JWT:

-CLASES JwtAuthenticationFilter y JwtService: El filtro JwtAuthenticationFilter intercepta las solicitudes HTTP y extrae el
 token JWT de la cabecera de autorización.Luego, utiliza el servicio JwtService para validar el token y establecer la autenticación
 en el contexto de seguridad de Spring.

    PAQUETE REPOSITORY:

-INTERFACE UserRepository: Esta interfaz extiende de JpaRepository y proporciona métodos para interactuar con la base de datos
de usuarios.

    PAQUETE USER:

-ENUN Role y la CLASE User: Estas clases representan los roles y los usuarios en tu aplicación. Proporcionan los detalles
necesarios para la autenticación y la autorización,como el nombre de usuario, la contraseña y los roles del usuario.
********************************************************************************************************************************************
En resumen, la seguridad en Spring Boot se maneja principalmente a través de la autenticación basada en tokens JWT.
Cuando un usuario se autentica con éxito, el servidor genera un token JWT que el usuario debe incluir en las cabeceras de
autorización de sus solicitudes HTTP subsiguientes. Este token es validado por el filtro JwtAuthenticationFilter en cada solicitud,
y si es válido, la autenticación del usuario se establece en el contexto de seguridad de Spring.



