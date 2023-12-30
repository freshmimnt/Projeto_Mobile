package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.projetomobilelazuli.models.curso.Curso;
import pt.iade.projetomobilelazuli.models.curso.CursoDao;
import pt.iade.projetomobilelazuli.models.curso.CursoRepository;

import java.util.List;

/* Somente o Get */
@RestController
public class CursoController {
    @Autowired
    private CursoDao cursoDao;
    @Autowired
    private CursoRepository cursoRepository;
    private Curso curso;

    @GetMapping("/cour/get-all")
    public List<Curso> getAllCursos() {

        return cursoDao.getAllcursos();
    }
}
