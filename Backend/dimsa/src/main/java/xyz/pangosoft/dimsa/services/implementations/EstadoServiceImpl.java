package xyz.pangosoft.dimsa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.pangosoft.dimsa.models.Estado;
import xyz.pangosoft.dimsa.repositories.IEstadoRepository;
import xyz.pangosoft.dimsa.services.IEstadoService;

import java.util.List;

@Service
public class EstadoServiceImpl implements IEstadoService {

    @Autowired
    private IEstadoRepository repoEstado;

    @Override
    public List<Estado> findAll() {
        return repoEstado.findAll(Sort.by(Sort.Direction.ASC, "idEstado"));
    }

    @Override
    public Estado findById(Integer idestado) {
        return repoEstado.findById(idestado).orElse(null);
    }

    @Override
    public Estado findByEstado(String estado) {
        return repoEstado.findByEstado(estado).orElse(null);
    }

    @Override
    public Estado save(Estado estado) {
        return repoEstado.save(estado);
    }

    @Override
    public void delete(Integer idestado) {
        repoEstado.deleteById(idestado);
    }
}
