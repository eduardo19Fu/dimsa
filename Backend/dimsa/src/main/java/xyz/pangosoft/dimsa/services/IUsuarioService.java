package xyz.pangosoft.dimsa.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.pangosoft.dimsa.models.Role;
import xyz.pangosoft.dimsa.models.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public Page<Usuario> findAll(Pageable pageable);

    public Usuario findById(Integer idusaurio);

    public Usuario save(Usuario usuario);

    public Usuario findByUsuario(String usuario);

    public void delete(Integer id);

    public List<Usuario> cajeros();

    // método encargado de recolectar los roles de la BD
    public List<Role> findRoles();

}
