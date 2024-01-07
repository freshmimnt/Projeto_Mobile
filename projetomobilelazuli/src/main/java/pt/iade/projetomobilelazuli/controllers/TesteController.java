package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.Teste;
import pt.iade.projetomobilelazuli.repositories.TesteRepository;

import java.util.List;

@RestController
public class TesteController {

    @Autowired
    private TesteRepository testeRepository;

    @GetMapping("/teste/get")
    public List<Teste> getAllTeste() {
        return (List<Teste>) testeRepository.findAll();
    }

    @GetMapping("/teste/get/{id}")
    public ResponseEntity<Teste> getTesteById(@PathVariable int id){
        Teste teste = testeRepository.findById(id);

        if(teste != null){
            return ResponseEntity.ok(teste);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/teste/save")
    public void save(@RequestBody Teste teste) {
        testeRepository.save(teste);
    }

    @PostMapping("/teste/update/{id}")
    public void update(@PathVariable int id, @RequestBody Teste updateTeste) {
        Teste existingTeste = testeRepository.findById(id);

        existingTeste.setName(updateTeste.getName());
        existingTeste.setDate(updateTeste.getDate());
        existingTeste.setTime(updateTeste.getTime());
        existingTeste.setDesc(updateTeste.getDesc());
        existingTeste.setFinished(updateTeste.isFinished());
        existingTeste.setAgenda(updateTeste.getAgenda());
        testeRepository.save(existingTeste);

    }

    @DeleteMapping("/teste/delete/{id}")
        public void delete(@PathVariable int id){
            testeRepository.deleteById(id);
        }
}