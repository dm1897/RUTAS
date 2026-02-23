package com.example.rutasuio.controller;

import com.example.rutasuio.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {
    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        return usuarioRepository
                .findByUsernameAndPassword(username, password)
                .isPresent()
                ? "Login correcto"
                : "Usuario o contraseña incorrectos";
    }
}
