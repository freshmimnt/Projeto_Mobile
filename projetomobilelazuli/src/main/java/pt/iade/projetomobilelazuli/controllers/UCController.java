package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.Curso;
import pt.iade.projetomobilelazuli.repositories.CursoRepository;
import pt.iade.projetomobilelazuli.models.UC;

import pt.iade.projetomobilelazuli.repositories.UCRepository;
import pt.iade.projetomobilelazuli.models.User;
import pt.iade.projetomobilelazuli.repositories.UtilizadorRepository;

import java.util.List;

@RestController
public class UCController {


    @Autowired
    private UCRepository ucRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    private Curso curso;

    private User user;

    @GetMapping("/uc/get")
    public List<UC> getAllUCs(){

        return (List<UC>) ucRepository.findAll();
    }

    @GetMapping("/uc/get/{id}")
    public ResponseEntity<UC> getUserById(@PathVariable int id){
        UC uc = ucRepository.findById(id);

        if(uc != null ){
            return ResponseEntity.ok(uc);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/uc/save")
    public void save(@RequestBody UC uc){

        ucRepository.save(uc);
    }

    @PostMapping("/uc/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody UC updatedUC) {
        UC existingUC = ucRepository.findById(id);
        existingUC.setName(updatedUC.getName());
        existingUC.setSala(updatedUC.getSala());
        existingUC.setProf(updatedUC.getProf());
        existingUC.setDesc(updatedUC.getDesc());
        ucRepository.save(existingUC);
    }

    @DeleteMapping("/uc/delete/{id}")
    public void delete(@PathVariable int id){
        ucRepository.deleteById(id);
    }

}