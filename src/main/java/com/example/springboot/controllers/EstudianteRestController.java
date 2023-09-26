package com.example.springboot.controllers;

import com.example.springboot.models.Estudiante;
import com.example.springboot.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller que sigue patron REST
@RestController
@RequestMapping("/api")//la tura base
public class EstudianteRestController {

    @Autowired
    EstudianteServiceImpl estudianteService;


    @GetMapping ("/lista")
    public List<Estudiante> listaEstudiante(){
        List<Estudiante> listaMostrar = estudianteService.listaDeEstudiantes();
        return listaMostrar;
    }

    @GetMapping("/estudiante/{id}")
    public  Estudiante estudiantePorId(@PathVariable Long id){
        Estudiante estudianteMostrar = estudianteService.buscarEstudiantePorId(id);
        return estudianteMostrar;
    }
    //crear nuevo estudiantee
    @PostMapping("/estudiante/nuevo")
    public Estudiante guardarNuevoEstudiante(@RequestBody Estudiante estudianteNuevo) { //Nos permite enviar un objeto en JSON
    Estudiante estudianteParaGuardar = estudianteService.guardarEstudiante(estudianteNuevo);
    return estudianteParaGuardar;
    }

    //para borrar un registro
    @DeleteMapping("/estudiante/borrar")//localhost:8080/api/estudiante/borrar?id=2
    public String borrarEstudiantePorId(@RequestParam Long id ){
         estudianteService.borrarEstudiante(id);
        return "el estudiante ha sido borrado";
    }

    //para editar
    @PutMapping("/estudiante/editar/{id}")
    public Estudiante editarEstudiantePorId(@PathVariable Long id,@RequestBody Estudiante estudianteActualizado ){
        Estudiante estudianteEditado = estudianteService.editarEstudiantePorId(id, estudianteActualizado);
        return estudianteEditado;
    }
}
