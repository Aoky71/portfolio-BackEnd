
package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public List<Proyecto> getProyectos ();
    
    public void saveProyecto (Proyecto pro);
    
    public void deleteProyecto (Long id);
    
    public Proyecto findProyecto (Long id);
    
}
