package pt.iade.projetomobilelazuli.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.Curso;
import pt.iade.projetomobilelazuli.repositories.CursoRepository;
import pt.iade.projetomobilelazuli.repositories.UCRepository;
import pt.iade.projetomobilelazuli.models.Utilizador;
import pt.iade.projetomobilelazuli.repositories.UtilizadorRepository;

import java.util.List;

@RestController
public class UtilizadorController {
    @Autowired
    private UtilizadorRepository utilizadorRepository;

    private Curso curso;

    @GetMapping("/user/get")
    public List<Utilizador> getAllUsers(){

        return (List<Utilizador>) utilizadorRepository.findAll();
    }

    @GetMapping("/user/get/{id}")
    public ResponseEntity<Utilizador> getUserById(@PathVariable int id) {
        Utilizador utilizador = utilizadorRepository.findById(id);

        if (utilizador != null) {
            return ResponseEntity.ok(utilizador);
        } else {
            return ResponseEntity.notFound().build();
        }
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