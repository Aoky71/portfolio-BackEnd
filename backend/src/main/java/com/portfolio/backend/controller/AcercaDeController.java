
package com.portfolio.backend.controller;

import com.portfolio.backend.model.AcercaDe;
import com.portfolio.backend.service.IAcercaDeService;
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
public class AcercaDeController {
    
    @Autowired
    private IAcercaDeService interAcercaDe;
    
    @GetMapping("/acercade/traer")
    public List <AcercaDe> getAcerca() {
        
        return interAcercaDe.getAcercaDe();
    }
    
    @PostMapping("/acercade/crear")
    public String createAcerca(@RequestBody AcercaDe acerca){
        
        interAcercaDe.saveAcercaDe(acerca);
        return "La seccion 'acerca de' fue creada correctamente";
    }
    
    @DeleteMapping("/acerca/borrar/{id}")
    public String deleteAcerca (@PathVariable Long id){
        
        interAcercaDe.deleteAcercaDe(id);
        return "La seccion 'acerca de' fue elimanada correctamente";
    }
    
    @PutMapping("/acerca/editar/{id}")
    public AcercaDe editAcerca (@PathVariable Long id,
                                @RequestParam ("descripcion personal")String nuevaDescripcion,
                                @RequestParam ("foto de perfil") String nuevaFoto) {
        
        AcercaDe acerca = interAcercaDe.findAcercaDe(id);
        
        acerca.setDescripcionPersonal(nuevaDescripcion);
        acerca.setImagePerfil(nuevaFoto);
        
        interAcercaDe.saveAcercaDe(acerca);
        return acerca;
        
    }
    
    
}
