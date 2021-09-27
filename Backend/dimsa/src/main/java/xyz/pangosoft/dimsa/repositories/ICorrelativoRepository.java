package xyz.pangosoft.dimsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pangosoft.dimsa.models.Correlativo;
import xyz.pangosoft.dimsa.models.Estado;
import xyz.pangosoft.dimsa.models.Usuario;

import java.util.Optional;

public interface ICorrelativoRepository extends JpaRepository<Correlativo, Long> {

    // Buscar el correlativo del usuario logueado en el sistema
    public Optional<Correlativo> findByUsuarioAndEstado(Usuario usuario, Estado estado);
}
