
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProyectoController {
    
    @Autowired
    private IProyectoService interProyecto;
    
    
    @GetMapping("/proyectos/traer")
    public List<Proyecto> getProyectos() {
    
    return interProyecto.getProyectos();
    }
    
    @PostMapping("/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto pro){
        
        interProyecto.saveProyecto(pro);
        return "La seccion 'proyecto' fue creada correctamente";
    }
    
    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto (@PathVariable Long id){
        
        interProyecto.deleteProyecto(id);
        return "La seccion 'proyecto' fue eliminada correctamente";
    }
    
    @PutMapping("/proyecto/editar/{id}")
    public Proyecto editProyecto (@PathVariable Long id,
                                  @RequestParam("nombre del proyecto") String nuevoNombre,
                                  @RequestParam("Descripcion del proyecto") String nuevaDescripcion,
                                  @RequestParam("URL del proyecto") String nuevaUrl){
        
        Proyecto pro = interProyecto.findProyecto(id);
        
        pro.setDescripcionProyecto(nuevaDescripcion);
        pro.setNombreProyecto(nuevaUrl);
        pro.setUrlProyecto(nuevoNombre);
        
        interProyecto.saveProyecto(pro);
        return pro;
    }
    
}
