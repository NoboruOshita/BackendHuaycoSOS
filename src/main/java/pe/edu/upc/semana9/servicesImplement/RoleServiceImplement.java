package pe.edu.upc.semana9.servicesImplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.semana9.dtos.MensajesByRolDTO;
import pe.edu.upc.semana9.entities.Role;
import pe.edu.upc.semana9.entities.TipoDeCaso;
import pe.edu.upc.semana9.repositories.IRoleRepository;
import pe.edu.upc.semana9.services.IRoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public void delete(Long idRole) {
        rR.deleteById(idRole);
    }

    @Override
    public List<Role> list() {
        // TODO Auto-generated method stub
        return rR.findAll();
    }

    @Override
    public Role listId(Long id) {
        return rR.findById(id).orElse(new Role());
    }

    @Override
    public List<MensajesByRolDTO> reporte01() {
        List<String[]> countBookByAuthor = rR.getCountMensajesByRole();
        List<MensajesByRolDTO> bookAuthorDTOs = new ArrayList<>();

        for (String[] data : countBookByAuthor) {
            MensajesByRolDTO dto = new MensajesByRolDTO();
            dto.setRole(data[0]);
            dto.setMensajesCount(Integer.parseInt(data[1]));
            bookAuthorDTOs.add(dto);
        }

        return bookAuthorDTOs;
    }
}
