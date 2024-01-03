package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.projetomobilelazuli.models.curso.Curso;
import pt.iade.projetomobilelazuli.models.curso.CursoDao;
import pt.iade.projetomobilelazuli.models.curso.CursoRepository;

import java.util.List;


@RestController
public class CursoController {
    @Autowired
    private CursoDao cursoDao;
    @Autowired
    private CursoRepository cursoRepository;
    private Curso curso;

    @GetMapping("/cour/get-all")
    public List<Curso> getAllCursos() {

        return (List<Curso>) cursoRepository.findAll();
    }

    @PostMapping("/cour/save")
    public void save(@RequestBody Curso curso){

        cursoRepository.save(curso);

    }

}
