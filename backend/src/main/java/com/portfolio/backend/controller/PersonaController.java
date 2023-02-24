package com.portfolio.backend.controller;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
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
public class PersonaController {
    
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping("/api/persona/traer")
    public List <Persona> getPersona() {
        return interPersona.getPersona();
    }
    
    @GetMapping("/api/persona/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return interPersona.findPersona(id);
    }

    @PostMapping("/api/persona/crear")
    public ResponseEntity<Object> createEducacion(@RequestBody Persona perso) {
        interPersona.savePersona(perso);
        return new ResponseEntity<>(new Result("La persona fue creada"), HttpStatus.OK);
    }

    @DeleteMapping("/api/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {

        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/api/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("ocupacion") String ocupacion,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("telefono")String telefono,
            @RequestParam("email") String email,
            @RequestParam("urlImagenPerfil")String urlImagenPerfil,
            @RequestParam("urlImagenBanner")String urlImagenBanner,
            @RequestParam("urlGit")String urlGit,
            @RequestParam("urlCv")String urlCv) {
        
        Persona perso = interPersona.findPersona(id);
        perso.setNombre(nombre);
        perso.setOcupacion(ocupacion);
        perso.setUbicacion(ubicacion);
        perso.setTelefono(telefono);
        perso.setEmail(email);
        perso.setUrlImagenPerfil(urlImagenPerfil);
        perso.setUrlImagenBanner(urlImagenBanner);
        perso.setUrlGit(urlGit);
        perso.setUrlCv(urlCv);
        
        interPersona.savePersona(perso);
        return perso;

    }
}
