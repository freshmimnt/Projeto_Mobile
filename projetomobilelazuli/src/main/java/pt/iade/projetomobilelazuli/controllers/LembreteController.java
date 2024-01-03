package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.lembrete.Lembrete;
import pt.iade.projetomobilelazuli.models.lembrete.LembreteRepository;

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
        existingLembrete.setUc(updateLembrete.getUc());
        existingLembrete.setAgenda(updateLembrete.getAgenda());
        lembreteRepository.save(existingLembrete);
    }

    @DeleteMapping("/lembrete/update/{id}")
    public void delete(@PathVariable int id){
        lembreteRepository.deleteById(id);
    }

}
