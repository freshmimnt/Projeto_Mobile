package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.Horario;
import pt.iade.projetomobilelazuli.repositories.HorarioRepository;
import pt.iade.projetomobilelazuli.models.UC;
import pt.iade.projetomobilelazuli.repositories.UCRepository;

import java.util.List;

@RestController
public class HorarioController {
    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private UCRepository ucRepository;

    private UC uc;

    @GetMapping("/hor/get")
    public List<Horario> getAllHorarios(){

        return (List<Horario>) horarioRepository.findAll();
    }

    @GetMapping("/hor/get/{id}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable int id){
        Horario horario = horarioRepository.findById(id);

        if(horario != null){
            return ResponseEntity.ok(horario);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/hor/save")
    public void save(@RequestBody Horario horario){

        horarioRepository.save(horario);
    }

    @PutMapping("/hor/update/{id}")
    public void update(@PathVariable int id, @RequestBody Horario updatedHor) {
        Horario existingHor = horarioRepository.findById(id);
        existingHor.setDate(updatedHor.getDate());
        existingHor.setTime1(updatedHor.getTime1());
        existingHor.setTime2(updatedHor.getTime2());
        existingHor.setDesc(updatedHor.getDesc());
        existingHor.setUc(updatedHor.getUC());
        horarioRepository.save(existingHor);
    }

    @DeleteMapping("hor/delete/{id}")
    public void delete(@PathVariable int id){
        horarioRepository.deleteById(id);
    }
}
