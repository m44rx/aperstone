package com.example.demo.entity;

import com.example.demo.entity.enums.GradoAcademico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Persona")
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 60)
    private String nombre;

    @Column(length = 100)
    private String email;

    private GradoAcademico gradoAcademico;
    
    @Transient
    private String personaRespuesta;

    public String getPersonaRespuesta() {
        return "Esta persona " + this.nombre + ", " + this.email;
    }

}
