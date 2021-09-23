package xyz.pangosoft.dimsa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.pangosoft.dimsa.models.Cliente;
import xyz.pangosoft.dimsa.services.IClienteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"https://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class ClienteApiController {

    @Autowired
    private IClienteService serviceCliente;

    @GetMapping(value = "/clientes")
    public List<Cliente> index() {
        return serviceCliente.findAll();
    }

    @GetMapping(value = "/clientes/page/{page}")
    public Page<Cliente> index(@PathVariable("page") Integer page) {
        return serviceCliente.findAll(PageRequest.of(page, 5));
    }

    @GetMapping(value = "/clientes/nombre/{name}")
    public List<Cliente> findByName(@PathVariable("name") String name) {
        return serviceCliente.findByName(name);
    }

    @GetMapping(value = "/clientes/nit/{nit}")
    public ResponseEntity<?> findByNit(@PathVariable("nit") String nit){

        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cliente = serviceCliente.findByNit(nit);
        } catch (DataAccessException e) {
            response.put("mensaje", "¡Error en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(cliente == null) {
            response.put("mensaje", "¡El cliente no se encuentra registrado en la base de datos!");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @GetMapping(value = "/clientes/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {

        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cliente = serviceCliente.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "¡Ha ocurrido un error en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente == null) {
            response.put("mensaje", "¡El cliente con ID: ".concat(id.toString()).concat(" no se encuentra registrado en la base de datos!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping(value = "/clientes")
    public ResponseEntity<?> create(@RequestBody Cliente cliente) {

        Cliente newCliente = null;
        Map<String, Object> response = new HashMap<>();

        try {
            newCliente = serviceCliente.save(cliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "¡Ha ocurrido un error en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(newCliente == null) {
            response.put("mensaje", "¡No se ha podido registrar el nuevo cliente!");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "¡Cliente registrado con éxito!");
        response.put("cliente", newCliente);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/clientes")
    public ResponseEntity<?> update(@RequestBody Cliente cliente) {

        Cliente clienteUpdated = null;
        Map<String, Object> response = new HashMap<>();

        if(cliente == null) {
            response.put("mensaje", "¡El cliente con ID: ".concat(cliente.getIdCliente().toString())
                    .concat(" no existe en la base de datos!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            clienteUpdated = serviceCliente.save(cliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "¡Ha ocurrido un error en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "¡El cliente ha sido actualizado con éxito!");
        response.put("cliente", clienteUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer idcliente) {

        Map<String, Object> response = new HashMap<>();

        try {
            serviceCliente.delete(idcliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "¡Ha ocurrido un error en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "¡El cliente ha sido eliminado con éxito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}
