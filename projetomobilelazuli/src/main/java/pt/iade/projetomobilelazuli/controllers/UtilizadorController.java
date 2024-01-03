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
    private UtilizadorRepository utilizadorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UCRepository ucRepository;

    private Curso curso;

    @GetMapping("/user/get")
    public List<Utilizador> getAllUsers(){

        return (List<Utilizador>) utilizadorRepository.findAll();
    }

    @PostMapping("/user/save")
    public Utilizador save(@RequestBody Utilizador utilizador) {

        utilizadorRepository.save(utilizador);

        return utilizador;
    }

    @PutMapping("/user/update/{id}")
    public void update(@PathVariable int id, @RequestBody Utilizador updatedUser) {
        Utilizador existingUser = utilizadorRepository.findById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setTurma(updatedUser.getTurma());
        existingUser.setSemestre(updatedUser.getSemestre());
        existingUser.setCurso(updatedUser.getCurso());
        utilizadorRepository.save(existingUser);
    }

    @DeleteMapping("/user/delete/{id}")
    public void delete(@PathVariable int id){
        utilizadorRepository.deleteById(id);
    }

}