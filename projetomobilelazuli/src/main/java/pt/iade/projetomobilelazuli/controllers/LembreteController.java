package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.Lembrete;
import pt.iade.projetomobilelazuli.repositories.LembreteRepository;

import java.util.List;

@RestController
public class LembreteController {

    @Autowired
    private LembreteRepository lembreteRepository;

    private Lembrete lembrete;

    @GetMapping("/lembrete/get")
    public List<Lembrete> getAllLembretes(){
        return (List<Lembrete>) lembreteRepository.findAll();
    }

    @GetMapping("/lembrete/get/{id}")
    public ResponseEntity<Lembrete> getLembreteById(@PathVariable int id){
        Lembrete lembrete = lembreteRepository.findById(id);

        if(lembrete != null){
            return ResponseEntity.ok(lembrete);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/lembrete/save")
    public void save(@RequestBody Lembrete lembrete){
        lembreteRepository.save(lembrete);
    }

    @PutMapping("/lembrete/update/{id}")
    public void update(@PathVariable int id, @RequestBody Lembrete updateLembrete){
        Lembrete existingLembrete = lembreteRepository.findById(id);

        existingLembrete.setName(updateLembrete.getName());
        existingLembrete.setDate(updateLembrete.getDate());
        existingLembrete.setTime(updateLembrete.getTime());
        existingLembrete.setDesc(updateLembrete.getDesc());
        existingLembrete.setFinished(updateLembrete.isFinished());
        existingLembrete.setAgenda(updateLembrete.getAgenda());
        lembreteRepository.save(existingLembrete);
    }

    @DeleteMapping("/lembrete/update/{id}")
    public void delete(@PathVariable int id){
        lembreteRepository.deleteById(id);
    }

}
