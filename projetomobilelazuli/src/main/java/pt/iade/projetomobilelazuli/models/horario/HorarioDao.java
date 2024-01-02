package pt.iade.projetomobilelazuli.models.horario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioDao {

    @Autowired
    private HorarioRepository horarioRepository;
    public void save(Horario horario){
        horarioRepository.save(horario);
    }

    public List<Horario> getAllHorarios() {
        List<Horario> horarios =  new ArrayList<>();
        Streamable.of(horarioRepository.findAll())
                .forEach(horarios::add);
        return horarios;

    }
}
