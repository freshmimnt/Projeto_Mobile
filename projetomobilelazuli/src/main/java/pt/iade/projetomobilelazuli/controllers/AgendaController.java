package pt.iade.projetomobilelazuli.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;
import pt.iade.projetomobilelazuli.models.agenda.AgendaRepository;

import java.util.List;

@RestController
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

     @GetMapping("/agenda/get")
    public List<Agenda> getAllAgendas(){
         return (List<Agenda>) agendaRepository.findAll();


     }

     @PostMapping("/agenda/save")
    public void save(@RequestBody Agenda agenda){
         agendaRepository.save(agenda);
     }

}
