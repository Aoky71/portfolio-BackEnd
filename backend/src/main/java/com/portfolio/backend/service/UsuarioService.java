
package com.portfolio.backend.service;

import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public List<Usuario> getUsuarios() {
        
        List<Usuario> listaUsuarios = userRepository.findAll();
        return listaUsuarios; 
    }

    @Override
    public void saveUsuario(Usuario user) {
        
        userRepository.save(user);
    }

    @Override
    public void deleteUsuario(Long id) {
        
        userRepository.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        
        Usuario user = userRepository.findById(id).orElse(null);
        return user;
    }
    
}
