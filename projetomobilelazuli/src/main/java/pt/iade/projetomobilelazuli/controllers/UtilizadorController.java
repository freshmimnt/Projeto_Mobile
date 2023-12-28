package pt.iade.projetomobilelazuli.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.curso.Curso;
import pt.iade.projetomobilelazuli.models.curso.CursoRepository;
import pt.iade.projetomobilelazuli.models.uc.UCDao;
import pt.iade.projetomobilelazuli.models.uc.UCRepository;
import pt.iade.projetomobilelazuli.models.user.Utilizador;
import pt.iade.projetomobilelazuli.models.user.UtilizadorDao;
import pt.iade.projetomobilelazuli.models.user.UtilizadorRepository;

import java.util.List;

@RestController
public class UtilizadorController {
    @Autowired
    private UtilizadorDao utilizadorDao;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UCDao ucDao;

    @Autowired
    private UCRepository ucRepository;

    private Curso curso;

    @GetMapping("/user/get")
    public List<Utilizador> getAllUsers(){

        return utilizadorDao.getAllUsers();
    }

    @PostMapping("/user/save")
    public void save(@RequestBody Utilizador utilizador){

        utilizadorDao.save(utilizador);
    }

    @PutMapping("/user/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Utilizador updatedUser) {
        Utilizador existingUser = utilizadorRepository.findById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setTurma(updatedUser.getTurma());
        existingUser.setSemestre(updatedUser.getSemestre());
        curso = cursoRepository.findById(2);
        existingUser.setCurso(curso);
        utilizadorRepository.save(existingUser);
    }
}