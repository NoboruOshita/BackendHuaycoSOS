package pe.edu.upc.semana9.servicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.semana9.dtos.TipoDeCasoxCasosDTO;
import pe.edu.upc.semana9.dtos.UsuarioByDonacionDTO;
import pe.edu.upc.semana9.entities.TipoDeCaso;
import pe.edu.upc.semana9.repositories.ITipoDeCasoRepository;
import pe.edu.upc.semana9.services.ITipoDeCasoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoDeCasoServiceImplement implements ITipoDeCasoService {
    @Autowired
    private ITipoDeCasoRepository tcR;

    @Override
    public void insert(TipoDeCaso tipoDeCaso) {
        tcR.save(tipoDeCaso);
    }

    @Override
    public List<TipoDeCaso> list() {
        return tcR.findAll();
    }

    @Override
    public void delete(int idTipoDeCaso) {
        tcR.deleteById(idTipoDeCaso);
    }

    @Override
    public TipoDeCaso listId(int idTipoDeCaso) {
        return tcR.findById(idTipoDeCaso).orElse(new TipoDeCaso());
    }

    @Override
    public List<TipoDeCasoxCasosDTO> reporte01() {
        List<String[]> countBookByAuthor = tcR.getTiposDeCasoConcurrencias();
        List<TipoDeCasoxCasosDTO> listaDTOs = new ArrayList<>();

        for (String[] data : countBookByAuthor) {
            TipoDeCasoxCasosDTO dto = new TipoDeCasoxCasosDTO();
            dto.setNombre((data[0]));
            dto.setContador(Integer.parseInt(data[1]));
            listaDTOs.add(dto);
        }

        return listaDTOs;
    }
}
