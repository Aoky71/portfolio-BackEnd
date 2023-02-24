
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProyectoController {
    
    @Autowired
    private IProyectoService interProyecto;
    
    
    @GetMapping("/api/proyecto/traer")
    public List<Proyecto> getProyecto() {
    return interProyecto.getProyecto();
    }
    
    @GetMapping("/api/proyecto/{id}")
    public Proyecto getProyectoById(@PathVariable Long id) {
       return interProyecto.findProyecto(id);
    }
    
    @PostMapping("/api/proyecto/crear")
    public ResponseEntity<Object> createProyecto(@RequestBody Proyecto pro){
        
        interProyecto.saveProyecto(pro);
        return new ResponseEntity<>(new Result("La seccion 'proyecto' fue creada correctamente"),HttpStatus.OK);
    }
    
    @DeleteMapping("/api/proyecto/borrar/{id}")
    public String deleteProyecto (@PathVariable Long id){
        
        interProyecto.deleteProyecto(id);
        return "La seccion 'proyecto' fue eliminada correctamente";
    }
    
    @PutMapping("/api/proyecto/editar/{id}")
    public Proyecto editProyecto (@PathVariable Long id,
                                  @RequestParam("nombre del proyecto") String nombreProyecto,
                                  @RequestParam("Descripcion del proyecto") String descripcionProyecto,
                                  @RequestParam("URL del proyecto") String urlProyecto,
                                  @RequestParam("fecha del Proyecto")String fechaProyecto,
                                  @RequestParam("url de la imagen")String urlImagen){
        
        Proyecto pro = interProyecto.findProyecto(id);
        
        pro.setDescripcionProyecto(descripcionProyecto);
        pro.setNombreProyecto(nombreProyecto);
        pro.setUrlProyecto(urlProyecto);
        pro.setFechaProyecto(fechaProyecto);
        pro.setUrlImagen(urlImagen);
        
        interProyecto.saveProyecto(pro);
        return pro;
    }
    
}
