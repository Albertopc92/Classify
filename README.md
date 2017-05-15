## Descripción de la aplicación
La aplicación que se desarrolla en este proyecto va a permitir al usuario crear un catálogo tanto de series como de películas. Se pretende que el usuario tenga un entorno visual en el que tenga toda la información sobre el contenido que consume, y además pueda llevar un seguimiento del mismo.
Así pues, el usuario podrá añadir nuevas series y películas a su catálogo, creando una ficha técnica de cada una. Además, en el caso de las series podrá añadir las temporadas y los capítulos que conformen las mismas.
Para crear las fichas técnicas el usuario podrá introducir diversa información a través de cuadros de texto como de menús de selección.
También se tendrá la opción de borrar una serie o una película, como de modificar los datos de las mismas, en el caso de las series se permitirá borrar y modificar tanto temporadas como capítulos. Una opción para realizar búsquedas por nombre también estará disponible.
El usuario tendrá opción de listar series y películas, y podrá ordenar por número de por puntuación y en el caso de las series también lo podrá hacer por número de temporadas. En el caso de las series, el usuario podrá hacer un seguimiento de los capítulos que ha visualizado marcando estos como vistos.

### 1. ArrayList
Se hacen uso de varios ArrayList, en la clase Videoteca se utilizará para almacenar todas las instancias de la clase Serie y clase Película. De esta manera poder gestionar las instancias de esas clases mediante los métodos definidos en Videoteca.
También se hace uso de ellos en la clase Temporada, donde serán almacenados las instancias de Capítulos y así mismo otro en la clase Serie, donde se almacenan las instancias de Temporada.

### 2. Enumeraciones
Se hará uso de las enumeraciones para crear los géneros de las series y las películas, así como para los premios. Así delimitamos al usuario a una selección determinada.

### 3. Herencia
Se hace uso de la herencia mediante las clases Serie y Película, que heredan de la clase Multimedia.

### 4. Interfaces
Se hará uso de la funcionalidad de las interfaces mediante la clase abstracta Multimedia, ya que estamos condicionando el comportamiento de las clases Serie y Película. También se implementarán las interfaces Comparable y Serializable, para poder escribir y recuperar los datos de la aplicación mediante el uso de ficheros.
Crearemos un método abstracto puntuable, el cuál calculará la nota final que se le asignará a la serie o la película según unos factores:

##### Serie
* Nota del usuario · 0,4
* Premio · 0,2
* Nº de temporadas · 0,2
* Nº de visualizaciones · 0,2

##### Pelicula
* Nota del usuario · 0,5 
* Premios · 0,3 
* N.º de visualizaciones · 0,2

### 5. Fujos de datos y ficheros
Se hará uso de los flujos de datos para poder guardar y recuperar la información de la aplicación mediante el uso de ficheros.

### 6. Excepciones
Se hará uso de excepciones para controlar rangos de valores no válidos, intentar acceder a elementos no existentes, controlar intentos de acceder a listas vacías, crear elementos ya existentes o introducir valores que no cumplan ciertos requisitos. Se controlará que el usuario al introducir una nota de una serie o una película no se permitirán valores menores de 0 ni mayores a 10.

### 7. Expresiones regulares
Las expresiones regulares serán utilizadas para controlar que la entrada de datos que realice el usuario en la aplicación en los campos sea del formato correcto y cumplan unos requisitos. Se controlará que el título de las películas, series y capítulos de las mismas, deben contener al menos un carácter alfanumérico, sin permitir caracteres especiales.

### 8. Fechas
Las fechas serán utilizadas para registrar el momento en el que se ha realiza la visualización de una serie o una película, quedando registrado la fecha de último visionado. Además, también se utilizarán para indicar el años de estreno tanto de películas como de series.

### 9. GUI
Se hará uso de una interfaz gráfica de usuario para que el manejo de la aplicación por parte del usuario sea mucho más sencilla y visual. Para ello se utilizarán ventana para abrir las diferentes características de la misma.