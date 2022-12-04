
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.service.IEducacionService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping("/educacion/traer")
    public List<Educacion> getEducacion() {
        return interEducacion.getEducacion();
     }
    
    @PostMapping("/educacion/crear")
    public String createEducacion(@RequestBody Educacion edu) {
        
        interEducacion.saveEducacion(edu);
        return "La institucion fue creada";
        
    }
    
    @DeleteMapping("/educacion/eliminar/{id}")
    public String deleteEducacion (@PathVariable Long id) {
        
        interEducacion.deleteEducacion(id);
        return "La institucion fue eliminada correctamente";
    }
    
    @PutMapping("/educacion/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id,
                                    @RequestParam ("Instituto")String nuevoNombre,
                                    @RequestParam ("Fecha de inicio")String nuevaFecha,
                                    @RequestParam ("Descripcion")String nuevaDescripcion) {
        
        Educacion edu = interEducacion.findEducacion(id);
        
        edu.setNombreInstituto(nuevaDescripcion);
        edu.setFechaInicio(nuevaFecha);
        edu.setDescripcionInstitucion(nuevaDescripcion);
        
        interEducacion.saveEducacion(edu);
        
        return edu;
    
    }
    
}
