package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.tarefa.Tarefa;
import pt.iade.projetomobilelazuli.models.tarefa.TarefaRepository;

import java.util.List;

@RestController
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    private Tarefa tarefa;

    @GetMapping("tarefa/get")
    public List<Tarefa> getAllTarefas(){

    return (List<Tarefa>) tarefaRepository.findAll();
    }

    @PostMapping("/tarefa/save")
    public void save(@RequestBody Tarefa tarefa){

        tarefaRepository.save(tarefa);

    }

    @PutMapping("/tarefa/update/{id}")
    public void update(@PathVariable int id, @RequestBody Tarefa updateTarefa){
        Tarefa existingTarefa = tarefaRepository.findById(id);

        existingTarefa.setName(updateTarefa.getName());
        existingTarefa.setDate(updateTarefa.getDate());
        existingTarefa.setTime(updateTarefa.getTime());
        existingTarefa.setNota(updateTarefa.getNota());
        existingTarefa.setDesc(updateTarefa.getDesc());
        existingTarefa.setFinished(updateTarefa.isFinished());
        existingTarefa.setUc(updateTarefa.getUc());
        existingTarefa.setAgenda(updateTarefa.getAgenda());
        tarefaRepository.save(existingTarefa);

    }

    @DeleteMapping("/tarefa/delete/{id}")
    public void delete(@PathVariable int id){
        tarefaRepository.deleteById(id);
    }


}
