package com.cursojava.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cursojava.demo.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public Object verificarCredenciales(Usuario usuario) {

        String query = "FROM Usuario WHERE correo=:correo";

        List<Usuario> DBResponse = entityManager.createQuery(query, Usuario.class)
                .setParameter("correo", usuario.getCorreo())
                .getResultList();

        if (DBResponse.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error de credenciales, favor verificar");
        }

        Argon2 argon2 = Argon2Factory.create();

        boolean claveEsCorrecta = argon2.verify(DBResponse.get(0).getClave(), usuario.getClave().toCharArray());

        if (!claveEsCorrecta) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error de credenciales, favor verificar");
        }

        return true;
    }

    @Override
    @Transactional // revierte cualqueir cambio en la BD si algo falla
    public List<Usuario> getUsuarios() {

        String query = "FROM Usuario";
        List<Usuario> usuarios = entityManager.createQuery(query, Usuario.class).getResultList();

        return usuarios;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object eliminarUsuario( String id) {

        // String query = "FROM Usuario WHERE id=" + id;
        // Object resultadoDB = entityManager.createQuery(query).getSingleResult();
        // List<Usuario> usuario = entityManager.createQuery(query,
        // Usuario.class).getResultList();

        Usuario usuarioDB = entityManager.find(Usuario.class, id);

        if (usuarioDB == null) {
            return new ResponseEntity<>(new Object(), HttpStatus.BAD_REQUEST);
        }

        entityManager.remove(usuarioDB);

        return usuarioDB;

    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public Object crearUsuario(Usuario usuario) {

        String query = "FROM Usuario WHERE correo=:correo";

        List<Usuario> DBResponse = entityManager.createQuery(query, Usuario.class)
                .setParameter("correo", usuario.getCorreo())
                .getResultList();

        if (!DBResponse.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Este correo ya tiene una cuenta registrada");
        }

        // Argon2 argon2 = Argon2Factory.create();
        Argon2 argon2 = Argon2Factory.create();

        String claveEncriptada = argon2.hash(1, 1024, 1, usuario.getClave().toCharArray());

        usuario.setClave(claveEncriptada);

        Usuario usuarioDB = entityManager.merge(usuario);
        return usuarioDB;
    }

}
