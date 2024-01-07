package pt.iade.projetomobilelazuli.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import pt.iade.projetomobilelazuli.models.Agenda;
import pt.iade.projetomobilelazuli.repositories.AgendaRepository;

import java.util.List;

@RestController
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

     @PostMapping("/agenda/save")
    public void save(@RequestBody Agenda agenda){
         agendaRepository.save(agenda);
     }

     @PostMapping("/agenda/update/{id}")
    public void update(@PathVariable int id, @RequestBody Agenda existingAgenda){
         Agenda updateAgenda = agendaRepository.findById(id);

         updateAgenda.setName(existingAgenda.getName());
         updateAgenda.setUtilizador(existingAgenda.getUtilizador());

     }

}
