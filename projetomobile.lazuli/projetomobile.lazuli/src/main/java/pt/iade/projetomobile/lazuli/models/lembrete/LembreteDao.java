package pt.iade.projetomobile.lazuli.models.lembrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LembreteDao {

    @Autowired
    private LembreteRepository lembreteRepository;

    public void save(Lembrete lembrete){
        lembreteRepository.save(lembrete);
    }

    public List<Lembrete> getAllLembs(){
        List<Lembrete> lembretes = new ArrayList<>();
        Streamable.of(lembreteRepository.findAll())
                .forEach(lembretes::add);
        return lembretes;
    }
}
