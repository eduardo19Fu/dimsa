package xyz.pangosoft.dimsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.pangosoft.dimsa.models.MarcaProducto;

import java.util.List;

public interface IMarcaProductoRepository extends JpaRepository<MarcaProducto, Integer> {

    // Consulta que permite buscar marca por nombre
    @Query("Select m from MarcaProducto m where m.marca = :param1")
    List<MarcaProducto> findByMarca(@Param("param1") String marca);
}
