package pe.edu.upc.semana9.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.semana9.dtos.CasoDTO;
import pe.edu.upc.semana9.dtos.CasosXDepartamentoDTO;
import pe.edu.upc.semana9.dtos.UsuarioByDonacionDTO;
import pe.edu.upc.semana9.entities.Caso;
import pe.edu.upc.semana9.services.ICasoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/caso")
public class CasoController {
    @Autowired
    private ICasoService cS;

    @PostMapping
    public void insert(@RequestBody CasoDTO dto) {

        ModelMapper m = new ModelMapper();
        Caso c = m.map(dto, Caso.class);
        cS.insert(c);
    }

    @GetMapping
    public List<CasoDTO> list() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CasoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @GetMapping("/{id}")
    public CasoDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CasoDTO dto = m.map(cS.listId(id), CasoDTO.class);
        return dto;
    }

    @PutMapping
    public void goUpdate(@RequestBody CasoDTO dto) {
        ModelMapper m = new ModelMapper();
        Caso u = m.map(dto, Caso.class);
        cS.insert(u);
    }

    @GetMapping("/Casos_segun_departamento")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<CasosXDepartamentoDTO> getUsersByDonations() {
        List<CasosXDepartamentoDTO> _usuarios = cS.reporte01();
        return _usuarios;
    }
}