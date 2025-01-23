package com.example.ApiForo.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String categoria;

    private Boolean activo;

    public Curso(){

    }

    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.activo = true;
        this.nombre = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
    }

    public Long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }
}
