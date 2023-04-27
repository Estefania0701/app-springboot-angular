package com.gestion.empleados.repositorio;

import com.gestion.empleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// le paso la entidad (Empleado) y el tipo de id de esa entidad (Long)
@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
