package pe.edu.upc.semana9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.semana9.dtos.MensajeDTO;
import pe.edu.upc.semana9.entities.Book;
import pe.edu.upc.semana9.entities.Mensaje;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje,Integer> {

    @Query("from Mensaje b where b.usuario1.idUsuario=:id")
    List<Mensaje> buscarMensajePorIdDamnificado(@Param("id") Integer id);

    //IDK
    @Query(value = "SELECT b.usuario2.nombres, b.descripcion " +
            "FROM Mensaje b " +
            "WHERE b.usuario1.username = :username")
    List<String[]> GET_MENSAJES_ENVIADOS(@Param("username") String username);


    @Query(value = "SELECT b.usuario1.nombres, b.descripcion " +
            "FROM Mensaje b " +
            "WHERE b.usuario2.username = :username")
    List<String[]> GET_MENSAJES_Recibidos(@Param("username") String username);

    @Query(value = "SELECT COUNT(id_mensaje) FROM mensajes", nativeQuery = true)
    int gettotalmensajes();
}
