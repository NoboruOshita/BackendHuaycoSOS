package pe.edu.upc.semana9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.semana9.entities.Role;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r.rol, COUNT(m.idMensaje) \n" +
            "FROM Role r \n" +
            "JOIN Mensaje m on r.user.idUsuario=m.usuario1.idUsuario\n" +
            " group by r.rol")
    List<String[]> getCountMensajesByRole();
}
