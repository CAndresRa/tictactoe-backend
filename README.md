# Tic Tac Toe - Spring, React y MongoDB 
### Autor: Carlos Andrés Ramírez Torres
### Fecha: Lunes, 6 de Julio del 2020
##### LOC/h: 2019/16 = 126.18 LOC/h

Tic tac toe es un juego clasico en donde el jugador que complete una tres espacios adyacentes o en forma diagonal con su figura correspondiente es el ganador, en caso que ninguno lo logre sera un empate.

* **X:** Representa a un jugador, inicia en el primer turno.
* **O:** Representa a un jugador.
* **Ganador:** Quien logre completar una diagonal, fila o columna con su figura.

## Uso 

Para el desarrollo del proyecto se utilizo **Maven** como una herramienta para la construccion y gestion del mismo, el codigo fue desarrollado con el lenguaje de programación **Java**, framework **Spring**, desarrollo web usando **React** y persitencia en base de datos no relacional **MongoDB** y se encuentra desplegado en **Heroku**.

Para el correcto funcionamiento de la aplicacion y dado de que la misma se encuentra en dos repositositorios serapados, uno destinado para el backend y otro para el frontend debera iniciar primero el servidor backend mediante la siguiente url en el browser.

- https://carlostictactoeback.herokuapp.com/

Debera salir la siguiente respuesta.

![Texto alternativo](https://github.com/CAndresRa/tictactoe-backend/blob/master/imgReadme/Screen%20Shot%202020-07-06%20at%207.48.29%20PM.png)

A continuacion se podra ingresar al link de la aplicacion web:

- https://tictactoearsw.herokuapp.com/

Para ejecutar de manera local se recomienda cambiar la variable host que se encuentra en el frontend a `localhost:8080` e iniciar el servidor de la siguiente manera desde terminal 

Utilizar `mvn spring-boot:run` para inicializar todos los componentes **Spring**.

por ejemplo y dando como resultado:

![Texto alternativo](https://github.com/CAndresRa/tictactoe-backend/blob/master/imgReadme/Screen%20Shot%202020-07-06%20at%207.41.37%20PM.png)


## Diagrama

* Aplicación 

![Texto alternativo](https://github.com/CAndresRa/tictactoe-backend/blob/master/imgReadme/Screen%20Shot%202020-07-06%20at%207.02.05%20PM.png)

Para la aplicacion se implemento una clase llamada **EndPointToGame** la cual en su configuracion tiene el **end point** para la conexion entre el cliente con el backend de la aplicacion, esta clase es la encargada de abrir conexiones y enviar los mensajes correspondientes a las mismas, esta se conecta con la entidad **Room** que es un objeto que contiene las sesiones que se encuentran en la misma, la secuencia de los estados que han ocurrido y el nombre de la sala, con lo cual el **EndPointToGame** podra identificar tanto las salas como las sesiones en las mismas. Por ultimo la zona de persitencia esta establecido por services, el cual contiene la interfaz **RoomService** que es implementada por **RoomServiceImpl** la cual utiliza a **RoomRepository** para la conexion hacia la base de datos **MongoDB**.


## Pruebas 

Se han realizado diferentes pruebas de **aceptación** sobre la aplicación que se mostraran a continuación, se probaron los siguientes eventos:

* Creacion de sala.
* Acceso a diferentes salas.
* Funcionamiento del juego multiusuario.
* Boton retroceder movimiento.
* Cargar información del ultimo de estado a las nuevas conexiones.

Ejemplos

* Se crean dos salas diferentes desde la pagina inicial de la aplicación

![](https://github.com/CAndresRa/tictactoe-backend/blob/master/imgReadme/Screen%20Shot%202020-07-06%20at%207.27.19%20PM.png)

* Al momento de ingresar a alguna sala observamos un cambio en la url que dirige a la sala correspondiente.

![](https://github.com/CAndresRa/tictactoe-backend/blob/master/imgReadme/Screen%20Shot%202020-07-06%20at%207.27.48%20PM.png)

* Se puede observar que los juegos se realizan en salas diferentes simultaneamente.

![](https://github.com/CAndresRa/tictactoe-backend/blob/master/imgReadme/Screen%20Shot%202020-07-06%20at%207.28.32%20PM.png)

* Si hay otra conexion a la misma sala, se cargara el estado actual de la partida en la nueva sesion.

![](https://github.com/CAndresRa/tictactoe-backend/blob/master/imgReadme/Screen%20Shot%202020-07-06%20at%207.29.21%20PM.png)
