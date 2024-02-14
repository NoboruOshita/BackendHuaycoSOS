package pe.edu.upc.semana9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.semana9.entities.Caso;

import java.util.List;

@Repository
public interface ICasoRepository extends JpaRepository<Caso,Integer> {
    //Reporte Casos según departamento
    @Query("SELECT c.idUbicacion.departamento, COUNT(c.idCaso) " +
            "FROM Caso c " +
            "GROUP BY c.idUbicacion.departamento ")
    List<String[]> getDepartamentosConMasCasos();
}
