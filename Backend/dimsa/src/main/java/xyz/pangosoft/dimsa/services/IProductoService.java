package xyz.pangosoft.dimsa.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.pangosoft.dimsa.models.Estado;
import xyz.pangosoft.dimsa.models.Producto;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

    public List<Producto> findAllByEstado(Estado estado);

    public Page<Producto> findAll(Pageable pageable);

    public Producto findById(Integer idproducto);

    public Producto save(Producto producto);

    public void delete(Integer idproducto);

    // Busqueda de Productos desde el frontend
    public List<Producto> findByName(String name);

    public Producto findByCodigo(String codigo);

    // Listado de productos caducados
    public List<Producto> findCaducados();

    // SERVICIOS DE REPORTES
    // public String reportExpired() throws JRException, FileNotFoundException, SQLException;
}
