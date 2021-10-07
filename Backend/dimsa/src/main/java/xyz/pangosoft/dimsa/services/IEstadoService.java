package xyz.pangosoft.dimsa.services;

import xyz.pangosoft.dimsa.models.Estado;

import java.util.List;

public interface IEstadoService {

    public List<Estado> findAll();

    public Estado findById(Integer idestado);

    public Estado findByEstado(String estado);

    public Estado save(Estado estado);

    public void delete(Integer idestado);

}
