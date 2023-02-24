package com.portfolio.backend.controller;

import com.portfolio.backend.model.User;
import com.portfolio.backend.service.IUserService;
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
public class UserController {
    @Autowired
    private IUserService interUser;

    @GetMapping("/api/user/traer")
    public List<User> getUser() {
        return interUser.getUser();
    }

    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return interUser.findUser(id);
    }

    @PostMapping("/api/user/crear")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        interUser.saveUser(user);
        return new ResponseEntity<>(new Result("El usuario fue creado"), HttpStatus.OK);
    }

    @DeleteMapping("/api/user/borrar/{id}")
    public String deleteUser(@PathVariable Long id) {

        interUser.deleteUser(id);
        return "El usuario fue eliminado correctamente";
    }

    @PutMapping("/api/user/editar/{id}")
    public User editUser(@PathVariable Long id,
            @RequestParam("nombreUsuario") String nombreUsuario,
            @RequestParam("contraseña") String contraseña) {
        User user = interUser.findUser(id);
        user.setNombreUsuario(nombreUsuario);
        user.setContraseña(contraseña);
        interUser.saveUser(user);
        return user;

    }

}
