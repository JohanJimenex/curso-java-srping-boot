package com.cursojava.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private long id;

    @Getter
    @Setter
    @Column(name = "titulo")
    private String titulo;

    @Getter
    @Setter
    @Column(name = "hora")
    private String hora;

    @Getter
    @Setter
    @Column(name = "categoria")
    private String categoria;

    @Getter
    @Setter
    @Column(name = "image")
    private String image;

    @Getter
    @Setter
    @Column(name = "cupos_disponibles")
    private int cupos_disponibles;

    @Getter
    @Setter
    @Column(name = "tickets_comprados")
    private int tickets_comprados;

    @Getter
    @Setter
    @Column(name = "precio")
    private float precio;

    @Getter
    @Setter
    @Column(name = "pais")
    private String pais;

    @Getter
    @Setter
    @Column(name = "ciudad")
    private String ciudad;

    @Getter
    @Setter
    @Column(name = "sector")
    private String sector;

    @Getter
    @Setter
    @Column(name = "calle")
    private String calle;

    @Getter
    @Setter
    @Column(name = "referencia")
    private String referencia;

    @Getter
    @Setter
    @Column(name = "tipo_de_evento")
    private String tipo_de_evento;

}
