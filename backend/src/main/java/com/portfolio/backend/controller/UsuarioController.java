
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.service.IUsuarioService;
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
public class UsuarioController {
    
    @Autowired
    private IUsuarioService interUsuario;
    
    @GetMapping("/usuarios/traer")
    public List<Usuario> getUsuarios() {
        
        return interUsuario.getUsuarios();
    }
    
    @PostMapping("/usuario/crear")
    public String createUsuario(@RequestBody Usuario user){
        
        interUsuario.saveUsuario(user);
        return "El usuario se creo correctamente";
    }
    
    @DeleteMapping("/usuario/eliminar/{id}")
    public String deleteUsuario (@PathVariable Long id) {
        
        interUsuario.deleteUsuario(id);
        return "El usaurio se elimino correctamente";
    }
    
    
    @PutMapping("/usuario/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id,
                                @RequestParam ("Nuevo nombre de usuario") String nuevoNombre,
                                @RequestParam ("Nueva contraseña") String nuevaContraseña) {
        
        Usuario user = interUsuario.findUsuario(id);
        
        user.setNombreUsuario(nuevoNombre);
        user.setContraseña(nuevaContraseña);
        
        interUsuario.saveUsuario(user);
        return user;
    }
}
