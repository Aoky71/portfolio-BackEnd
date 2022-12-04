
package com.portfolio.backend.service;

import com.portfolio.backend.model.Usuario;
import java.util.List;


public interface IUsuarioService {
    
    public List<Usuario> getUsuarios();
    
    public void saveUsuario (Usuario user);
    
    public void deleteUsuario (Long id);
    
    public Usuario findUsuario (Long id);
    
}
