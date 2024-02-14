package pe.edu.upc.semana9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.semana9.entities.TipoDeCaso;

import java.util.List;

@Repository
public interface ITipoDeCasoRepository extends JpaRepository<TipoDeCaso,Integer> {
    //Reporte contador segun tipo de casos
    @Query("SELECT c.idTipoDeCaso.nombre, COUNT(c.idCaso) " +
            "FROM Caso c " +
            "GROUP BY c.idTipoDeCaso.nombre")
    List<String[]> getTiposDeCasoConcurrencias();
}