# AppLander
Aplicación web JPA - AppLander

El objetivo es incluir el código HTML de un juego en una estructura de aplicación web. El acceso al juego está limitado por un control de usuarios apoyado por una base de datos en PostgreSQL. La comunicación entre la base de datos y la aplicación se realiza a través de un modelo objeto-relacional persistente y una serie de servlets que gestionan los procesos realizados.

CREACIÓN BASE DE DATOS

La base de datos GARSAN está creada en PostgreSQL. Consta de dos tablas (Usuario, Partida):

              USUARIO                                 PARTIDA
            - id_usuario (clave primaria)           - id_partida (clave primaria)
            - name_usuario (campo único)            - date_begin
            - nacionality                           - date_finish
            - password                              - score
                                                    - id_usuario_fk (clave foránea)
                                                    
CONEXIÓN DE LA BASE DE DATOS

Una vez importado el driver de PostgreSQL en java, se crean los modelos de las clases objeto-relacionales. La conexión la realizo en la clase listener.

DESCRIPCIÓN DEL PROYECTO

- Paquete garsan_modelos: Contiene los modelos de las entidades que nos permiten acceder a los datos persistentes de las tablas.
- Paquete garsan_servicios: Contiene las clases con los métodos necesarios para interaccionar con la base de datos (añadir nuevos usuarios y partidas, hacer consultas,etc.) .
- Paquete listeners: Contiene el listener. Es la clase que inicializa y cierra el proyecto mediante dos métodos encargados de crear y cerrar la conexión.
- Paquete servlets: Contiene los servlets utilizados para gestionar la comunicación entre el juego (html, jsp, js) con los modelos de la base de datos. Hay un servlet por cada proceso (Registro, Login, Cookies, Partidas).

FUNCIONAMIENTO DEL PROYECTO

- Paquete garsan_modelos
      - Usuario: esta clase se crea automáticamente y contiene los métodos necesarios para obtener la información de la tabla usuario.            Esta es la clase que instanciamos desde los servicios cada vez que queremos manejar un objeto usuario.
      - Partida: esta clase se crea automáticamente y contiene los métodos necesarios para obtener la información de la table partida.            Esta es la clase que instanciamos desde los servicios cada vez que queremos manejar un objeto partida.
      
- Paquete garsan_servicios
      - Usuario_servicio: contiene los métodos utilizados en los servlets para crear, modificar o consultar en la base de datos. En esta        clase instanciamos la clase Usuario del paquete garsan_modelos.
      - Partida_servicio: contiene los métodos utilizados en los servlets para crear, modificar o consultar en la base de datos. En esta        clase instanciamos la clase Partida del paquete garsan_modelos.
     
- Paquete listeners
      - listener: esta clase utiliza dos métodos principalmente. El método contextInitialized() crea la conexión con la base de datos y        el método contextDestroyed() cierra la conexión cuando acaba la aplicación.
      
- Paquete servlets
      - ServletCookies: en su método doPost() recorre la lista de cookies. Si el usuario y la contraseña guardados en la cookie están          registrados accede al juego. Sino te muestra la pantalla de login.
      - ServletLogin: en su método doPost recibe un usuario y una contraseña, comprueba si existen en la base de datos. Si existe,              ejecuta el juego. Sino abre la página de registro.
      - ServletRegistro: en su método doPost() recibe un usuario y una contraseña con la crea un nuevo usuario sino existe ya. Además,          antes de ejecutar el juego crea una nueva partida.
      - ServletPartidas: en su método doPost(), que es llamado cuando finaliza una partida, se actualiza la partida, modificando el            campo puntuación y fecha de finalización.
      
 - Parte WEB
      - index.jsp: redirecciona al método doPost() del ServletCookies.
      - login.jsp: es la página que, en comunicación con el ServletLogin, permite a un usuario ya registrado acceder al juego. Si               intenta acceder un usuario no registrado, lo redirecciona a registro.jsp.
      - registro.jsp: permite a un usuario registrarse, para ello se comunica con el ServletRegistro.
      - juego_lander.jsp: es el juego del aterrizaje espacial con un menú superior que te ofrece varias opciones (todavía no                     funcionales) además de una opción "Salir" (que sí funciona).
