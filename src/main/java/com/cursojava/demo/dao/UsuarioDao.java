package com.cursojava.demo.dao;

import java.util.List;

import com.cursojava.demo.models.Usuario;

public interface UsuarioDao {

    Object verificarCredenciales(Usuario usuario);

    List<Usuario> getUsuarios();

    Object eliminarUsuario(String id);

    Object crearUsuario(Usuario usuario);

}
