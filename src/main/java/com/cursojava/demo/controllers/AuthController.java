package com.cursojava.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.cursojava.demo.dao.UsuarioDao;
import com.cursojava.demo.models.Usuario;
import com.cursojava.demo.utils.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    // @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/login")
    public Object login(@RequestBody Usuario usuario) {

        Object DBResponse = usuarioDao.verificarCredenciales(usuario);

        if (!DBResponse.equals(true)) {
            return DBResponse; // viene un mensaje de credenciales incorrectas
        }

        String jwtoken = jwtUtil.createToken(usuario.getCorreo(), usuario.getRole());

        return jwtoken;
    }

}