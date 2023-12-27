package pt.iade.projetomobilelazuli.models.horario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioDao {

    @Autowired
    private HorarioRepository horarioRepository;
    public void save(Horario horario){
        horarioRepository.save(horario);
    }

}
