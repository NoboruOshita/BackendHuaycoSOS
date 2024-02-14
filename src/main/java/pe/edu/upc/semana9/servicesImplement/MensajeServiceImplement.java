package pe.edu.upc.semana9.servicesImplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.semana9.dtos.MensajeDTO;
import pe.edu.upc.semana9.dtos.MensajeEnviadoDTO;
import pe.edu.upc.semana9.entities.Mensaje;
import pe.edu.upc.semana9.repositories.IMensajeRepository;
import pe.edu.upc.semana9.services.IMensajeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MensajeServiceImplement implements IMensajeService {
    @Autowired
    private IMensajeRepository mR;

    @Override
    public void insert(Mensaje mensaje) {
        mR.save(mensaje);
    }

    @Override
    public List<Mensaje> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int idMensaje) {

            mR.deleteById(idMensaje);

    }

    @Override
    public Mensaje listId(int idMensaje) {
        return mR.findById(idMensaje).orElse(new Mensaje());
    }

    @Override
    public List<Mensaje> find(Integer id) {
        return mR.buscarMensajePorIdDamnificado(id);
    }


    @Override
    public List<MensajeEnviadoDTO> reporte01(String username) {
        List<String[]> countBookByYearrr = mR.GET_MENSAJES_ENVIADOS(username);
        List<MensajeEnviadoDTO> bookyearDTOs = new ArrayList<>();

        for (String[] data : countBookByYearrr) {
            MensajeEnviadoDTO dto = new MensajeEnviadoDTO();
            dto.setNombre_receptor(data[0]);
            dto.setDescripcion(data[1] );
            bookyearDTOs.add(dto);
        }

        return bookyearDTOs;
    }

    @Override
    public List<MensajeEnviadoDTO> reporte03(String username) {
        List<String[]> countBookByYearrr = mR.GET_MENSAJES_Recibidos(username);
        List<MensajeEnviadoDTO> bookyearDTOs = new ArrayList<>();

        for (String[] data : countBookByYearrr) {
            MensajeEnviadoDTO dto = new MensajeEnviadoDTO();
            dto.setNombre_receptor(data[0]);
            dto.setDescripcion(data[1] );
            bookyearDTOs.add(dto);
        }

        return bookyearDTOs;
    }

    @Override
    public int reporte02() {
        return mR.gettotalmensajes();
    }


}
