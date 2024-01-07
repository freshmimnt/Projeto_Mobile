package pt.iade.projetomobilelazuli.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.Curso;
import pt.iade.projetomobilelazuli.models.User;
import pt.iade.projetomobilelazuli.repositories.UtilizadorRepository;

import java.util.List;
import java.util.Map;

@RestController
public class UtilizadorController {
    @Autowired
    private UtilizadorRepository utilizadorRepository;

    private Curso curso;

    @GetMapping("/user/get")
    public List<User> getAllUsers(){

        return (List<User>) utilizadorRepository.findAll();
    }

    @GetMapping("/user/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = utilizadorRepository.findById(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user/save")
    public User save(@RequestBody User user) {

        utilizadorRepository.save(user);

        return user;
    }

    @PostMapping("/user/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        System.out.println("Received email: " + email);
        System.out.println("Received password: " + password);

        User user = utilizadorRepository.findByEmailAndPassword(email, password);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @PostMapping("/user/update/{id}")
    public void update(@PathVariable int id, @RequestBody User updatedUser) {
        User existingUser = utilizadorRepository.findById(id);
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