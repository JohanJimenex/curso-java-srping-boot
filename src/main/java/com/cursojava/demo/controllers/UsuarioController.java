package com.cursojava.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cursojava.demo.dao.UsuarioDao;
import com.cursojava.demo.models.Usuario;
import com.cursojava.demo.utils.JWTUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    // injection de dependencia como los servicios de angular comparte la misma
    // instancia en todo los lados
    // no es necesario instanciar el objeto con NEW ya que lo hace automatico
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping(value = "/usuarios")
    public List<Usuario> buscarUsuarios() {

        return usuarioDao.getUsuarios();
    }

    @DeleteMapping(value = "/usuario/{id}")
    public Object eliminarUsuario(@RequestHeader(value = "Authorization") String token, @PathVariable String id) {

        Boolean tokenValido = jwtUtil.verificarToken(token);

        System.out.println(token);
        System.out.println(tokenValido);

        Object usuarioEliminado = usuarioDao.eliminarUsuario(id);

        return usuarioEliminado;
    }

    // se convieerte automatico a un objeto Usuario
    @PostMapping(value = "/usuario")
    public Object crearUsuario(@RequestBody Usuario usuario) {

        // usuario.setId(1l);
        // usuario.setEvento_id(1l);
        Object usuarioDB = usuarioDao.crearUsuario(usuario);

        return usuarioDB;
    }

    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable String id) {

        Usuario usuario = new Usuario();

        return usuario;
    }

    @PutMapping(value = "/usuario")
    public Usuario editUsuario() {

        Usuario usuario = new Usuario();

        return usuario;
    }

}
