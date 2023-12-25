package pt.iade.projetomobilelazuli.models.user;
import pt.iade.projetomobilelazuli.models.user.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilizadorDao {

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    public void save(Utilizador utilizador){
        utilizadorRepository.save(utilizador);
    }

    public List<Utilizador> getAllUsers(){
        List<Utilizador> utilizadores = new ArrayList<>();
        Streamable.of(utilizadorRepository.findAll())
                .forEach(utilizadores::add);
        return utilizadores;
    }

    public void delete(Utilizador utilizador){
        utilizadorRepository.delete(utilizador);
    }

}
