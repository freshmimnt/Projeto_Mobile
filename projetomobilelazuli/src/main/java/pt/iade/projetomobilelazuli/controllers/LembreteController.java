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

    @PostMapping("/lembrete/update/{id}")
    public void update(@PathVariable int id, @RequestBody Lembrete existingLembrete){
        Lembrete  updateLembrete= lembreteRepository.findById(id);
        updateLembrete.setName(existingLembrete.getName());
        updateLembrete.setDate(existingLembrete.getDate());
        updateLembrete.setTime(existingLembrete.getTime());
        updateLembrete.setDesc(existingLembrete.getDesc());
        updateLembrete.setFinished(existingLembrete.isFinished());
        updateLembrete.setAgenda(existingLembrete.getAgenda());
        lembreteRepository.save(existingLembrete);
    }

    @DeleteMapping("/lembrete/update/{id}")
    public void delete(@PathVariable int id){
        lembreteRepository.deleteById(id);
    }

}
