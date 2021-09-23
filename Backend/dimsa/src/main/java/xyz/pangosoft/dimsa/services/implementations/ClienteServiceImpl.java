package xyz.pangosoft.dimsa.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.pangosoft.dimsa.models.Cliente;
import xyz.pangosoft.dimsa.repositories.IClienteRepository;
import xyz.pangosoft.dimsa.services.IClienteService;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository repoCliente;

    @Override
    public List<Cliente> findAll() {
        return repoCliente.findAll(Sort.by(Sort.Direction.ASC, "idCliente"));
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return repoCliente.findAll(pageable);
    }

    @Override
    public Cliente findById(Integer idcliente) {
        return repoCliente.findById(idcliente).orElse(null);
    }

    @Override
    public List<Cliente> findByName(String nombre) {
        return repoCliente.findByNombre(nombre);
    }

    @Override
    public Cliente findByNit(String nit) {
        return repoCliente.findByNit(nit).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repoCliente.save(cliente);
    }

    @Override
    public void delete(Integer idcliente) {
        repoCliente.deleteById(idcliente);
    }
}
