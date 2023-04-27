/* Este código define una clase llamada ResourceNotFoundException que es una
excepción personalizada utilizada en la gestión de empleados. La excepción se
lanza cuando no se encuentra un empleado en el sistema.

VER ABAJO MÁS INFO SOBRE EXCEPCIONES PERSONALIZADAS*/

package com.gestion.empleados.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/*@ResponseStatus para indicar el código de estado HTTP que se enviará en la
respuesta cuando se lance la excepción. En este caso, se establece el valor
HttpStatus.NOT_FOUND, que representa el código de estado 404 (NOT_FOUND).*/
@ResponseStatus (value = HttpStatus.NOT_FOUND)
/*Extiende de RuntimeException para que la excepción se convierta en una
excepción no verificada, lo que significa que no es necesario declararla en las
firmas de método o manejarla explícitamente en las cláusulas throws.*/
public class ResourceNotFoundException extends RuntimeException{
    // Si no existe un empleado, se llamará la excepción personalizada

    /*Se utiliza para mantener la compatibilidad entre diferentes versiones de
    la clase cuando se serializa o deserializa. El valor 1L es una convención
    para la versión inicial de la clase.*/
    private static final long serialVersionID = 1L;

    // constructor
    public ResourceNotFoundException(String mensaje) {
        /*Llamo al constructor de la clase base (RuntimeException) pasando el
        mensaje proporcionado mediante la palabra clave super. Esto permite que
        el mensaje de error se propague cuando se lanza la excepción.*/
        super(mensaje);
    }
}

/*----------------- EXCEPCIONES PERSONALIZADAS -----------------------

Las excepciones personalizadas, también conocidas como excepciones
personalizadas o excepciones definidas por el usuario, son excepciones que se
crean específicamente para una aplicación o sistema en particular. Estas
excepciones se utilizan para capturar y manejar situaciones excepcionales o
errores específicos que pueden ocurrir durante la ejecución de un programa.

A diferencia de las excepciones predefinidas en el lenguaje de programación,
como NullPointerException o IllegalArgumentException, las excepciones
personalizadas se diseñan para abordar situaciones específicas relacionadas con
la lógica de negocio de una aplicación. Al crear una excepción personalizada,
puedes proporcionar un mensaje de error específico y definir el comportamiento
de manejo de la excepción de acuerdo con las necesidades de tu aplicación.

Las excepciones personalizadas se suelen utilizar para:
    1. Indicar situaciones excepcionales específicas en una aplicación.
    2. Proporcionar información detallada sobre el error ocurrido.
    3. Proporcionar una jerarquía de excepciones más específica y estructurada
    en una aplicación.
    4. Separar el manejo de errores y excepciones específicas de la lógica
    principal del programa.

Crear una excepción personalizada implica crear una clase que extienda de una
clase de excepción existente, como Exception o RuntimeException, y añadir
funcionalidad adicional según sea necesario. Esto incluye la definición de
constructores, métodos y propiedades específicas de la excepción.*/
