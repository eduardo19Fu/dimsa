package xyz.pangosoft.dimsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pangosoft.dimsa.models.Estado;

import java.util.Optional;

public interface IEstadoRepository extends JpaRepository<Estado, Integer> {

    Optional<Estado> findByEstado(String estado);
}
