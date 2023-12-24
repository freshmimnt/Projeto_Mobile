package pt.iade.projetomobile.lazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobile.lazuli.models.curso.Curso;
import pt.iade.projetomobile.lazuli.models.curso.CursoDao;

import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoDao cursoDao;

    @GetMapping("/curso/get")
    public List<Curso> getAllCursos(){
        return  cursoDao.getAllCursos();
    }



}

