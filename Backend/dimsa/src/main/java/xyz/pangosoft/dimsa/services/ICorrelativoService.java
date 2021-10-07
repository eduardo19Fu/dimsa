package xyz.pangosoft.dimsa.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.pangosoft.dimsa.models.Correlativo;
import xyz.pangosoft.dimsa.models.Estado;
import xyz.pangosoft.dimsa.models.Usuario;

import java.util.List;

public interface ICorrelativoService {

    public List<Correlativo> findAll();

    public Page<Correlativo> findAll(Pageable pageable);

    public Correlativo findById(Long idcorrelativo);

    public Correlativo findByUsuario(Usuario usuario, Estado estado);

    public Correlativo save(Correlativo correlativo);

    public void delete(Long id);
}
