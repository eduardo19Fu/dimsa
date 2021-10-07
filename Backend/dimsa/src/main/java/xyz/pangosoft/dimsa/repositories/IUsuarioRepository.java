package xyz.pangosoft.dimsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.pangosoft.dimsa.models.Role;
import xyz.pangosoft.dimsa.models.Usuario;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByUsuario(String usuario);

    @Query("select u from Usuario u where u.usuario = ?1")
    public Usuario findByUsuario2(String usuario);


    @Query("from Role r")
    public List<Role> findRoles();

    @Query(value = "select u.*\r\n"
            + "from usuarios as u\r\n"
            + "inner join usuarios_roles as ur on ur.usuario_id = u.id_usuario\r\n"
            + "inner join roles as r on r.id_role = ur.role_id\r\n"
            + "where r.role = 'ROLE_COBRADOR' AND enabled = 1;",
            nativeQuery = true)
    public List<Usuario> findByRole();
}
