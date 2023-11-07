package com.textoscuanticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.textoscuanticos.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombre(String nombre);

    Usuario findByCorreoElectronico(String correoElectronico);

    Usuario findByNombreAndCorreoElectronico(String nombre, String correoElectronico);

    List<Usuario> findByNombreContaining(String parteDelNombre);

    Long countByCorreoElectronico(String correoElectronico);

    // Ejemplo de consulta JPQL personalizada
    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombreParam")
    List<Usuario> findUsuariosByNombrePersonalizado(@Param("nombreParam") String nombre);
}
