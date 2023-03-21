package com.cursojava.demo.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @Column(name = "role")
    private String role;

    @Getter
    @Setter
    @Column(name = "evento_id")
    @OneToMany(mappedBy = "id")
    private List<Evento> evento_id;

}
