package com.example.springboot.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "estudiantes_cyberpunk")
public class Empleos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleoId;

    @Column (name = "nombre")
    @NotNull
    private String empleoNombre;

    @Column(name = "sueldo")
    @Min(value = 1)
    @NotNull
    private Float empleoSueldo;

    //Constructor vacío
    public Empleos() {
    }

    //Constructor Lleno

    public Empleos(Long empleoId, String empleoNombre, Float empleoSueldo) {
        this.empleoNombre = empleoNombre;
        this.empleoSueldo = empleoSueldo;
    }

    //Getter y setter

    public Long getEmpleoId() {
        return empleoId;
    }


    public String getEmpleoNombre() {
        return empleoNombre;
    }

    public void setEmpleoNombre(String empleoNombre) {
        this.empleoNombre = empleoNombre;
    }

    public Float getEmpleoSueldo() {
        return empleoSueldo;
    }

    public void setEmpleoSueldo(Float empleoSueldo) {
        this.empleoSueldo = empleoSueldo;
    }


    //Poner alumno FK



}

//id, nombre, sueldo, alumno(fk)