package pt.iade.projetomobilelazuli.models.evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventoDao {

    @Autowired
    private EventoRepository eventoRepository;

    public void save(Evento evento){
        eventoRepository.save(evento);
    }

    public List<Evento> getAllEventos() {

        List<Evento> eventos = new ArrayList<>();
        Streamable.of(eventoRepository.findAll())
                .forEach(eventos::add);
        return eventos;

    }
}
