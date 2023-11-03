# 
<p float="left">
  <img src="src/main/resources/images/logos.png" width="100" />

</p>

## Spring Boot MySQL, Security, Postman

### Description

Proyecto final, crear una API 100%

Nivel 1
Es un juego de dados se juega con dos dados. En caso de que el resultado de la suma de los dos dados sea 7, la partida es ganada, si no es perdida. Un jugador/a bote ver un listado de todas las tiradas que ha hecho y el porcentaje de éxito.
Para poder jugar al juego y realizar una tirada, un usuario/aria se tiene que registrar con un nombre no repetido. Al crearse, se le asigna un identificador numérico único y una fecha de registro. Si el usuario/aria así lo desea, puedes no añadir ningún nombre y se llamará “ANÓNIMO”. Puede haber más de un jugador “ANÓNIMO”.
Cada jugador/a bote ver un listado de todas las tiradas que ha hecho, con el valor de cada dado y si se ha ganado o no la partida. Además, puede saber su porcentaje de éxito por todas las tiradas que ha hecho.
No se puede eliminar una partida en concreto, pero sí que se puede eliminar todo el listado de tiradas por un jugador/a.
El software tiene que permitir listar todos los jugadores/se que hay al sistema, el porcentaje de éxito de cada jugador/a y el porcentaje de éxito mediano de todos los jugadores/se en el sistema.
El software tiene que respetar los principales patrones de diseño.
**NOTAS**
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

### Swagger summary 
Endpoints filter by pre-authorization:
```
By ROLE: The role assigned to the user related to the JWT token
@PreAuthorize("hasAuthority('ADMIN')")
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")

By ID: Where the ID must be the same that the id of the user related to the JWT token
@PreAuthorize("#id == authentication.principal.id")

By ID or ROLE: 
@PreAuthorize("#id == authentication.principal.id or hasAuthority('ADMIN')")


### References:

- JPA entity relationships
  - [Bezkoder](https://www.bezkoder.com/jpa-one-to-many/) 
  - [Tutorialspoint](https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm)

-MySql - 
 
- JWT - SpringBoot Security
  - [Bezkoder - Spring Boot Token based Authentication with Spring Security & JWT](https://www.bezkoder.com/spring-boot-jwt-authentication/)

- Postman
  - [REST API Request Validation & Exception Handling Realtime Example | JavaTechie](https://www.youtube.com/watch?v=gPnd-hzM_6A)
  


