package pe.edu.upc.semana9.services;

import pe.edu.upc.semana9.dtos.MensajeDTO;
import pe.edu.upc.semana9.dtos.MensajeEnviadoDTO;
import pe.edu.upc.semana9.entities.Author;
import pe.edu.upc.semana9.entities.Mensaje;

import java.util.List;

public interface IMensajeService {
    public void insert(Mensaje mensaje);
    List<Mensaje> list();
    public void delete(int idMensaje);
    public Mensaje listId(int idMensaje);
    List<Mensaje> find(Integer id);


    //Reportes

    //
    public List<MensajeEnviadoDTO> reporte01(String username);

    public List<MensajeEnviadoDTO> reporte03(String username);
    public int reporte02();
}
