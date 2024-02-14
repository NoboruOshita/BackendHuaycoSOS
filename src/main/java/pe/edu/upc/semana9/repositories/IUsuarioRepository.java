package pe.edu.upc.semana9.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.semana9.entities.Usuario;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByUsername(String username);

    //BUSCAR POR NOMBRE
        @Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    //Reportes Usuarios que hicieron donaciones
    @Query("SELECT u.idUsuario, COUNT(d.idDonacion) \n" +
            "FROM Usuario   u \n" +
            "JOIN Donacion d on u.idUsuario=d.usuario.idUsuario\n" +
            " group by u.idUsuario")
    List<String[]> getUsuariosByDonaciones();



}
