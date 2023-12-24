package pt.iade.projetomobile.lazuli.models.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaDao {

    @Autowired
    private AgendaRepository  agendaRepository;

    public void save(Agenda agenda){
        agendaRepository.save(agenda);
    }

    public List<Agenda> getAllAgendas(){
        List<Agenda> agendas = new ArrayList<>();
        Streamable.of(agendaRepository.findAll())
                .forEach(agendas::add);
        return agendas;
    }
}
