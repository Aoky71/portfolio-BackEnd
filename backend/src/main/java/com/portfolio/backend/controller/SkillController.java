
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Skill;
import com.portfolio.backend.service.ISkillService;
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
public class SkillController {
    
    @Autowired
    private ISkillService interSkill;
    
    @GetMapping("/skills/traer")
    public List<Skill> getSkills(){
        
        return interSkill.getSkills();
    }
    
    @PostMapping("/skill/crear")
    public String createSkill(@RequestBody Skill skl){
        
        interSkill.saveSkill(skl);
        return "La seccion 'skill' fue creada correctamente";
    }
    
    @DeleteMapping("/skill/borrar/{id}")
    public String deleteSkill (@PathVariable Long id){
        
        interSkill.deleteSkill(id);
        return "La skill fue elimanada correctamente";
    }
    
    @PutMapping("/skill/editar/{id}")
    public Skill editSkill (@PathVariable Long id,
                            @RequestParam ("nombre de la skill") String nuevoNombre,
                            @RequestParam ("Grado de la skill") int nuevoGrado){
        
        Skill skl = interSkill.findSkill(id);
        
        skl.setNombreSkill(nuevoNombre);
        skl.setGradoSkill(0);
        
        interSkill.saveSkill(skl);
        return skl;
    }
    
}
