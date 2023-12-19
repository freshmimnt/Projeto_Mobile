package pt.iade.projetomobile.lazuli.models.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilizadorDao {
    @Autowired
    private UtilizadorRepository repository;

    public void save(Utilizador utilizador){
        repository.save(utilizador);
    }

    public List<Utilizador> getAllUsers(){
        List<Utilizador> utilizadores = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(utilizadores::add);
        return utilizadores;
    }

    public void delete(Utilizador utilizador){
        repository.delete(utilizador);
    }

}
