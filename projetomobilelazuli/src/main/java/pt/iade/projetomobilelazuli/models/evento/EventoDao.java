package pt.iade.projetomobilelazuli.models.evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoDao {

    @Autowired
    private EventoRepository eventoRepository;

    public void save(Evento evento){
        eventoRepository.save(evento);
    }

}
