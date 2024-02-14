package pe.edu.upc.semana9.servicesImplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.semana9.dtos.CasosXDepartamentoDTO;
import pe.edu.upc.semana9.dtos.UsuarioByDonacionDTO;
import pe.edu.upc.semana9.entities.Caso;
import pe.edu.upc.semana9.repositories.ICasoRepository;
import pe.edu.upc.semana9.services.ICasoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasoServiceImplement implements ICasoService {

    @Autowired
    private ICasoRepository cR;

    @Override
    public void insert(Caso caso) {
        cR.save(caso);
    }

    @Override
    public List<Caso> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int idCaso) {
        cR.deleteById(idCaso);
    }

    @Override
    public Caso listId(int idCaso) {
        return cR.findById(idCaso).orElse(new Caso());
    }

    @Override
    public List<CasosXDepartamentoDTO> reporte01() {
        List<String[]> countBookByAuthor = cR.getDepartamentosConMasCasos();
        List<CasosXDepartamentoDTO> listaDTOs = new ArrayList<>();

        for (String[] data : countBookByAuthor) {
            CasosXDepartamentoDTO dto = new CasosXDepartamentoDTO();
            dto.setDepartamento((data[0]));
            dto.setContador(Integer.parseInt(data[1]));
            listaDTOs.add(dto);
        }

        return listaDTOs;
    }
}
