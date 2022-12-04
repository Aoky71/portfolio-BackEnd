
package com.portfolio.backend.controller;

import com.portfolio.backend.model.ExperienciaLaboral;
import com.portfolio.backend.service.IExperienciaLaboralService;
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
public class ExperienciaLaboralController {
    
    
    @Autowired
    private IExperienciaLaboralService interExp;
    
    
    @GetMapping("/experiencia/traer")
    public List<ExperienciaLaboral> getExperiencia() {
        
        return interExp.getExperiencia();
    }
    
    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody ExperienciaLaboral exp) {
        
        interExp.saveExperiencia(exp);
        return "La seccion 'experiencia laboral' se creo correctamente";
    }   
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia (@PathVariable Long id) {
        
        interExp.deleteExperiencia(id);
        return "La seccion 'experiencia laboral' se elimino correctamente";
    }
    
    @PutMapping("/experiencia/editar/{id}")
    public ExperienciaLaboral editExperiencia (@PathVariable Long id,
                                               @RequestParam ("nombre de la empresa") String nuevoNombre,
                                               @RequestParam ("periodo dentro de la empresa") String nuevoPeriodo,
                                               @RequestParam ("Funcion dentro de la empresa") String nuevaFuncion) {
        
        ExperienciaLaboral exp = interExp.findExperiencia(id);
        
        exp.setNombreEmpresa(nuevoNombre);
        exp.setPeriodo(nuevoPeriodo);
        exp.setFuncion(nuevaFuncion);
        
        interExp.saveExperiencia(exp);
        return exp;
    }
}
