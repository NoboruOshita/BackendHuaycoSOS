package pe.edu.upc.semana9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.semana9.entities.Donacion;

import java.util.List;

@Repository
public interface IDonacionRepository extends JpaRepository<Donacion,Integer> {

    //Reportes en que departamento se hacen mas doanciones
    @Query("SELECT c.idUbicacion.departamento, COUNT(d.idDonacion) " +
            "FROM Caso c " +
            "JOIN Donacion d on c.idCaso=d.caso.idCaso\n" +
            "GROUP BY c.idUbicacion.departamento " +
            "ORDER BY COUNT(d.idDonacion) DESC ")
    List<String[]> getDepartamentosConMasDonaciones();
}
