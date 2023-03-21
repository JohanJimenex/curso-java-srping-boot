package com.cursojava.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.demo.dao.EventoDao;
import com.cursojava.demo.models.Evento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class EventoController {

    @Autowired
    private EventoDao eventoDao;

    @GetMapping(value = "/eventos")
    public List<Evento> getEventos() {

        return eventoDao.getEventos();
    }

}
