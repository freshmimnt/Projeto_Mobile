package pt.iade.projetomobile.lazuli.models.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesteDao {

    @Autowired
    private TesteRepository testeRepository;

    public void save(Teste teste){
        testeRepository.save(teste);
    }

}
