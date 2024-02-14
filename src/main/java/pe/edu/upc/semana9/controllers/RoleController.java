package pe.edu.upc.semana9.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.upc.semana9.dtos.MensajeDTO;
import pe.edu.upc.semana9.dtos.MensajesByRolDTO;
import pe.edu.upc.semana9.dtos.RoleDTO;
import pe.edu.upc.semana9.entities.Mensaje;
import pe.edu.upc.semana9.entities.Role;
import pe.edu.upc.semana9.services.IRoleService;
import pe.edu.upc.semana9.services.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IUsuarioService uService;
    @Autowired
    private IRoleService rService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insert(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role b = m.map(dto, Role.class);
        rService.insert(b);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> list() {
        return rService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id")Long id){
        rService.delete(id);
    }

    @GetMapping("/{id}")
    public RoleDTO listId(@PathVariable("id")Long id){
        ModelMapper m=new ModelMapper();
        RoleDTO dto=m.map(rService.listId(id),RoleDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void goUpdate(@RequestBody RoleDTO dto){
        ModelMapper m=new ModelMapper();
        Role a=m.map(dto,Role.class);
        rService.insert(a);
    }

    @GetMapping("/mensajes-por-rol-count")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<MensajesByRolDTO> getBookCountByAuthor() {
        List<MensajesByRolDTO> _mensajesbyrolDTOs = rService.reporte01();
        return _mensajesbyrolDTOs;
    }
}
