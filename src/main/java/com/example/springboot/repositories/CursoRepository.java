package com.example.springboot.repositories;

import com.example.springboot.models.Curso;
import com.example.springboot.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}