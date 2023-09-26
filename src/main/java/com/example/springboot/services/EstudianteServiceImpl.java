package com.example.springboot.services;

//Clase encargada de implementar los métodos de EstudianteService

import com.example.springboot.models.Estudiante;
import com.example.springboot.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Acá definimos una lógica de negocio

@Service
public class EstudianteServiceImpl implements EstudianteService {

    //Inyección de dependencias: permite la comunicación con otras capas
    @Autowired //esta notacion le dice a springboot que se inyecte dentro de esta capa en la que estamos, y le deja el control
    //de las dependencias
            //dependencia: conjunto de código adicional que ayuda a realizar alguna tarea específica.
    EstudianteRepository estudianteRepository;

    //Método para traer una lista de todos los registros
    @Override
    public List <Estudiante> listaDeEstudiantes () {
        return estudianteRepository.findAll();
    }
@Override
public Estudiante buscarEstudiantePorId(Long id){
        Boolean existe = estudianteRepository.existsById(id);

        if (existe){
            Estudiante estudianteEscojido = estudianteRepository.findById(id).get();
            return estudianteEscojido;
        }else {
            System.out.println("El id es invalido o no existe");
            return null;
        }
}
    //método para guardar un estudiante
    @Override
    public Estudiante guardarEstudiante(Estudiante estudianteNuevo){

        //Verificar si es que el estudiante ya existe
        //if (estudianteRepository.existsById(estudianteNuevo.getEstudianteId())) {
           // System.out.println("El estudiante ya existe");
           // return null;
        //} else {
            if (estudianteNuevo.getEstudianteEdad() < 18) {
                System.out.println("El estudiante debe ser mayor de edad");
                return null;
            } else {
                return estudianteRepository.save(estudianteNuevo);
            }
        }
//Método para borrar según id, va a llamar al repository
@Override
    public void borrarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
}

@Override
    public Estudiante editarEstudiantePorId(Long id, Estudiante estudianteActualizado){
        Boolean existe = estudianteRepository.existsById(id);
        if (existe){
            Estudiante estudianteSeleccionado = estudianteRepository.findById(id).get();
            estudianteSeleccionado.setEstudianteEdad(estudianteActualizado.getEstudianteEdad());
            estudianteSeleccionado.setEstudianteNombre(estudianteActualizado.getEstudianteNombre());
            estudianteSeleccionado.setEmail(estudianteActualizado.getEmail());
            System.out.println("El estudiante ha sido actualizado");
            return estudianteRepository.save(estudianteSeleccionado);
        }else {
            System.out.println("el estudiantev no existe o el id es invalido");
            return null;
        }
}

    }
//}


