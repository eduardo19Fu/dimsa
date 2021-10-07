package xyz.pangosoft.dimsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pangosoft.dimsa.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    // Busqueda de cliente por nombre
    // Consulta = 'Select * from Cliente where nombre = /*parametro dado*/
    List<Cliente> findByNombre(String nombre);

    // Búsqueda de cliente por nit
    // Consulta = 'Select * from Cliente where nit = /*parametro dado*/
    Optional<Cliente> findByNit(String nit);
}
