package pt.iade.projetomobilelazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.evento.Evento;
import pt.iade.projetomobilelazuli.models.evento.EventoDao;
import pt.iade.projetomobilelazuli.models.evento.EventoRepository;
import pt.iade.projetomobilelazuli.models.user.Utilizador;
import pt.iade.projetomobilelazuli.models.user.UtilizadorDao;
import pt.iade.projetomobilelazuli.models.user.UtilizadorRepository;

import java.util.List;

@RestController
public class EventoController {
    @Autowired
    private EventoDao eventoDao;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @Autowired
    private UtilizadorDao utilizadorDao;

    private Utilizador utilizador;

    @GetMapping("/even/get")
    public List<Evento> getAllEventos(){

        return eventoDao.getAllEventos();
    }

    @PostMapping("/even/save")
    public void save(@RequestBody Evento evento){

        eventoDao.save(evento);
    }

    @PutMapping("/even/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Evento updatedEven) {
        Evento existingEven = eventoRepository.findById(id);
        existingEven.setName(updatedEven.getName());
        existingEven.setDate(updatedEven.getDate());
        existingEven.setTime(updatedEven.getTime());
        existingEven.setParti(updatedEven.getParti());
        existingEven.setDesc(updatedEven.getDesc());
        existingEven.setUtilizador(updatedEven.getUtilizador());
        eventoRepository.save(existingEven);
    }
}