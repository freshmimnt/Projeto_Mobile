package pt.iade.projetomobilelazuli.models.lembrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LembreteDao {

    @Autowired
    private LembreteRepository lembreteRepository;

    public void save(Lembrete lembrete){
        lembreteRepository.save(lembrete);
    }

}
