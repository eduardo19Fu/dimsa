package xyz.pangosoft.dimsa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.pangosoft.dimsa.models.Correlativo;
import xyz.pangosoft.dimsa.models.Estado;
import xyz.pangosoft.dimsa.models.Usuario;
import xyz.pangosoft.dimsa.repositories.ICorrelativoRepository;
import xyz.pangosoft.dimsa.services.ICorrelativoService;

import java.util.List;

@Service
public class CorrelativoServiceImpl implements ICorrelativoService {

    @Autowired
    private ICorrelativoRepository repoCorrelativo;

    @Override
    public List<Correlativo> findAll() {
        return repoCorrelativo.findAll(Sort.by(Sort.Direction.ASC, "idCorrelativo"));
    }

    @Override
    public Page<Correlativo> findAll(Pageable pageable) {
        return repoCorrelativo.findAll(pageable);
    }

    @Override
    public Correlativo findById(Long idcorrelativo) {
        return repoCorrelativo.findById(idcorrelativo).orElse(null);
    }

    @Override
    public Correlativo save(Correlativo correlativo) {
        return repoCorrelativo.save(correlativo);
    }

    @Override
    public void delete(Long id) {
        repoCorrelativo.deleteById(id);
    }

    @Override
    public Correlativo findByUsuario(Usuario usuario, Estado estado) {
        return repoCorrelativo.findByUsuarioAndEstado(usuario, estado).orElse(null);
    }
}
