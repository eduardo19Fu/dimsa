package xyz.pangosoft.dimsa.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.pangosoft.dimsa.models.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public Cliente findById(Integer idcliente);

    public List<Cliente> findByName(String nombre);

    public Cliente findByNit(String nit);

    public Cliente save(Cliente cliente);

    public void delete(Integer idcliente);
}
