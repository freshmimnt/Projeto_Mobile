package pt.iade.projetomobilelazuli.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.Teste;

@Repository
public interface TesteRepository extends CrudRepository<Teste, Integer>{
    Teste findById(int id);

}
