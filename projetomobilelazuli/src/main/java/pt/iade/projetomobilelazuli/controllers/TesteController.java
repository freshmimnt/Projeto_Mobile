package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.teste.Teste;
import pt.iade.projetomobilelazuli.models.teste.TesteRepository;

import java.util.List;

@RestController
public class TesteController {

    @Autowired
    private TesteRepository testeRepository;

    @GetMapping("/teste/get")
    public List<Teste> getAllTeste() {
        return (List<Teste>) testeRepository.findAll();
    }

    @PostMapping("/teste/save")
    public void save(@RequestBody Teste teste) {
        testeRepository.save(teste);
    }

    @PutMapping("/teste/update/{id}")
    public void update(@PathVariable int id, @RequestBody Teste updateTeste) {
        Teste existingTeste = testeRepository.findById(id);

        existingTeste.setName(updateTeste.getName());
        existingTeste.setDate(updateTeste.getDate());
        existingTeste.setTime(updateTeste.getTime());
        existingTeste.setNota(updateTeste.getNota());
        existingTeste.setDesc(updateTeste.getDesc());
        existingTeste.setFinished(updateTeste.isFinished());
        existingTeste.setUc(updateTeste.getUc());
        existingTeste.setAgenda(updateTeste.getAgenda());
        testeRepository.save(existingTeste);

    }

    @DeleteMapping("/teste/delete/{id}")
        public void delete(@PathVariable int id){
            testeRepository.deleteById(id);
        }
}