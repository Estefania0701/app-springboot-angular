/* Este código define un controlador REST que proporciona una API para obtener
una lista de todos los empleados almacenados en la base de datos. La ruta de
acceso a la API es "/api/v1/empleados". Al llamar a esta ruta, se ejecuta el
método listarTodosLosEmpleados() que devuelve la lista de empleados obtenida
del repositorio.*/

package com.gestion.empleados.controlador;

import com.gestion.empleados.modelo.Empleado;
import com.gestion.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*Se define la clase EmpleadoControlador como un controlador REST utilizando la
anotación @RestController. La anotación @RequestMapping establece la URL base
para todas las rutas de este controlador, en este caso, "/api/v1/".*/
@RestController // API REST
@RequestMapping("/api/v1/")
public class EmpleadoControlador {

    // Inyecto una instancia de la clase EmpleadoRepositorio
    @Autowired
    private EmpleadoRepositorio repositorio;

    // Se ejecutará cuando se realice una solicitud GET a la ruta /empleados
    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados(){
        /*Llamo al método findAll() del repositorio de empleados, que devuelve
        una lista de todos los empleados en la base de datos*/
        return repositorio.findAll();
    }
}
