Descripción del proyecto

El contador de palabras es una herramienta automática básica que nos permite contar el número de palabras que se encuentran en un determinado archivo de texto y nos permite hacer una separación entre palabras y auxiliares de lenguaje en español, al final de la ejecución del programa nos genera un reporte resaltando:

    El total de palabras sin auxiliares dentro del archivo de texto
    El total de palabras con auxiliares dentro del archivo de texto
    Las 10 palabras más repetidas.
    Un conteo general de todas las palabras usadas
    
El contador de palabras identifica las palabras  usando delimitadores, en esta ocasión use la coma (,), punto (.), punto y coma (;), dos puntos (:), diagonal invertida (\) y el guion medio (-) y como se mencionó nos muestra las 10 palabras más repetidas lo cual nos puede ayudar a evitar el exceso del uso de estas.

Tecnologías.

El lenguaje de programación orientado a objetos que utilicé para desarrollar el contador es Java, trabajando en la plataforma Eclipse JUNO, dentro del sistema operativo Windows 10.
Forma de uso
Para comenzar a utilizar el programa desde línea de comandos primero debemos localizar nuestra carpeta que contiene el código fuente llamado “Main.java”,
el archivo de texto que queremos trabajar  (en mi caso llamado “data.txt”) , para facilitar la ejecución usted puede copiar dentro de la carpeta del
código fuente el archivo que desee procesar y el documento de texto que contiene nuestros auxiliares de lenguaje “stop.txt”, en mi  caso la ruta es:

    C:\Users\amigos\Documents\ProyectosJava\CONTADOR-DE-PALABRAS\src

Ahora dentro de esta carpeta ejecutaremos el comando javac+Main.java para compilar nuestro programa, en este caso ejecutaremos:

        Javac Main.java 
        
Después para ejecutar el programa ejecutaremos java+Main+el nombre del documento de texto a procesar, en este caso:

        java Main data.txt 
        
En consola lo que nos mostrara los siguientes puntos:

    Total de palabras sin auxiliares
    Total de palabras con auxiliares
    Las 10 palabras más repetidas
Generando al final de la ejecución un reporte llamado:

    mitexto_reporte.txt
    
Donde está escrito lo mismo que en consola, agregando todas las palabras y su número de repeticiones dentro del archivo de texto.
