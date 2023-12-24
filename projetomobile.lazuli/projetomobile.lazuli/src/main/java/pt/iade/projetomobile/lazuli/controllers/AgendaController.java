package pt.iade.projetomobile.lazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobile.lazuli.models.agenda.Agenda;
import pt.iade.projetomobile.lazuli.models.agenda.AgendaDao;

import java.util.List;

@RestController
public class AgendaController {

    @Autowired
    private AgendaDao agendaDao;

    @GetMapping("/agenda/get")
    public List<Agenda> getAllAgendas(){
        return agendaDao.getAllAgendas();
    }

}
