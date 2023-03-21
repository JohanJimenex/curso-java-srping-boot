package com.cursojava.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cursojava.demo.models.Evento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EventoDaoImp implements EventoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Evento> getEventos() {

        String query = "FROM Evento";
        List<Evento> eventosDB = entityManager.createQuery(query, Evento.class).getResultList();

        return eventosDB;

    }

}
