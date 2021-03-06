package xyz.pangosoft.dimsa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.pangosoft.dimsa.models.MarcaProducto;
import xyz.pangosoft.dimsa.repositories.IMarcaProductoRepository;
import xyz.pangosoft.dimsa.services.IMarcaProductoService;

import java.util.List;

@Service
public class MarcaProductoServiceImpl implements IMarcaProductoService {

    @Autowired
    private IMarcaProductoRepository marcaProductoRepo;

    @Override
    public List<MarcaProducto> findAll() {
        return marcaProductoRepo.findAll(Sort.by(Sort.Direction.ASC, "idMarcaProducto"));
    }

    @Override
    public Page<MarcaProducto> findAll(Pageable pageable) {
        return marcaProductoRepo.findAll(pageable);
    }

    @Override
    public MarcaProducto findById(Integer idMarca) {
        return marcaProductoRepo.findById(idMarca).orElse(null);
    }

    @Override
    public List<MarcaProducto> findByMarca(String marca) {
        return marcaProductoRepo.findByMarca(marca);
    }

    @Override
    public MarcaProducto save(MarcaProducto marca) {
        return marcaProductoRepo.save(marca);
    }

    @Override
    public void deleteMarca(Integer idMarca) {
        marcaProductoRepo.deleteById(idMarca);
    }
}
