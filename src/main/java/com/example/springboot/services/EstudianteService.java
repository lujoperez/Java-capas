package com.example.springboot.services;

import com.example.springboot.models.Estudiante;

import java.util.List;

//interfaz para declarar métodos
public interface EstudianteService {

  List <Estudiante> listaDeEstudiantes();

  Estudiante buscarEstudiantePorId(Long id);
  Estudiante guardarEstudiante(Estudiante estudianteNuevo);

  void borrarEstudiante(Long id);

  Estudiante editarEstudiantePorId(Long id, Estudiante estudianteActualizado);

}
