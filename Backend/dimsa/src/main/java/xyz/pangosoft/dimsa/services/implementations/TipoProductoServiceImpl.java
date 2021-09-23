package xyz.pangosoft.dimsa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.pangosoft.dimsa.models.TipoProducto;
import xyz.pangosoft.dimsa.repositories.ITipoProductoRepository;
import xyz.pangosoft.dimsa.services.ITipoProductoService;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

    @Autowired
    private ITipoProductoRepository repoTipo;

    @Override
    public List<TipoProducto> findAll() {
        return repoTipo.findAll(Sort.by(Sort.Direction.ASC, "idTipoProducto"));
    }

    @Override
    public Page<TipoProducto> findAll(Pageable pageable) {
        return repoTipo.findAll(pageable);
    }

    @Override
    public List<TipoProducto> findByTipo(String tipo) {
        return repoTipo.findByTipoProducto(tipo);
    }

    @Override
    public TipoProducto findById(Integer id) {
        return repoTipo.findById(id).orElse(null);
    }

    @Override
    public TipoProducto save(TipoProducto tipo) {
        return repoTipo.save(tipo);
    }

    @Override
    public void delete(Integer idtipo) {
        repoTipo.deleteById(idtipo);
    }
}
