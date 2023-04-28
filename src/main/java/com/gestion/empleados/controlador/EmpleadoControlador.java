/* Este código define un controlador REST que proporciona una API para obtener
una lista de todos los empleados almacenados en la base de datos. La ruta de
acceso a la API es "/api/v1/empleados". Al llamar a esta ruta, se ejecuta el
método listarTodosLosEmpleados() que devuelve la lista de empleados obtenida
del repositorio.*/

package com.gestion.empleados.controlador;

import com.gestion.empleados.modelo.Empleado;
import com.gestion.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Se define la clase EmpleadoControlador como un controlador REST utilizando la
anotación @RestController. La anotación @RequestMapping establece la URL base
para todas las rutas de este controlador, en este caso, "/api/v1/".*/
@RestController // API REST
@RequestMapping("/api/v1/")
/*La anotación @CrossOrigin se utiliza en el controlador de un proyecto en
Spring Boot para habilitar el acceso a recursos desde un origen diferente al
servidor que está sirviendo la aplicación.
VER MÁS INFO ABAJO*/
@CrossOrigin(origins = "http://localhost:4200/") //URL del frontend
public class EmpleadoControlador {

    // Inyecto una instancia de la clase EmpleadoRepositorio
    @Autowired
    private EmpleadoRepositorio repositorio;

    // Devuelve el listado de empleados
    /* Se ejecutará cuando se realice una solicitud GET a la ruta /empleados
    O sea, cuando se ejecute el método obtenerListaDeEmpleados() de
    empleado.service.ts */
    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados(){
        /*Llamo al método findAll() del repositorio de empleados, que devuelve
        una lista de todos los empleados en la base de datos*/
        return repositorio.findAll();
    }

    // Guarda un nuevo empleado
    /* Se ejecutará cuando se realice una solicitud POST a la ruta /empleados
    O sea, cuando se ejecute el método registrarEmpleado(empleado : Empleado)
    de empleado.service.ts */
    @PostMapping("/empleados")
    /* La anotación @RequestBody indica que el cuerpo de la solicitud HTTP se
    debe deserializar en un objeto Empleado y asignarlo al parámetro empleado.*/
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        /* El método save() es proporcionado por el repositorio de Spring Data
        JPA y se encarga de persistir o actualizar el objeto en la base de datos.*/
        return repositorio.save(empleado);
    }
}

/*
--------------------------- CROSSORIGIN---------------------------------

Cuando desarrollas una aplicación web con Angular en el frontend y
Spring Boot en el backend, ambos se ejecutan en diferentes servidores, el
frontend en el servidor de desarrollo de Angular (por ejemplo, en
http://localhost:4200) y el backend en el servidor de Spring Boot (por ejemplo,
en http://localhost:8080).

Por defecto, los navegadores aplican una política de seguridad llamada Same
Origin Policy (SOP), que restringe las solicitudes realizadas desde un origen
a otro. Esto significa que, por ejemplo, si tienes una aplicación Angular que
se ejecuta en http://localhost:4200, no podrás realizar solicitudes HTTP al
servidor de Spring Boot en http://localhost:8080 debido a las restricciones
de SOP.

La anotación @CrossOrigin resuelve este problema al permitir que el servidor
de Spring Boot envíe las cabeceras de Control de Acceso HTTP (CORS) necesarias
para habilitar el acceso desde el origen especificado. En este caso, el origen
especificado es http://localhost:4200.*/