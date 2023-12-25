package pt.iade.projetomobilelazuli.models.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDao {

    @Autowired
    private AgendaRepository agendaRepository;

    public void save(Agenda agenda){
        agendaRepository.save(agenda);
    }

}
