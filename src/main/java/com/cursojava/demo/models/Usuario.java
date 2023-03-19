package com.cursojava.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuarios") // para referir el nombre de la abla en sql
@ToString // @EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name = "apellido")
    private String apellido;

    @Getter
    @Setter
    @Column(name = "correo")
    private String correo;

    @Getter
    @Setter
    @Column(name = "clave")
    private String clave;

    @Getter
    @Setter
    @Column(name = "evento_id")
    private Long evento_id;

    @Getter
    @Setter
    @Column(name = "role")
    private String role;

    // public List<Evento> getEventos() {
    // return eventos;
    // }

    // public void setEventos(List<Evento> eventos) {
    // this.eventos = eventos;
    // }

}
