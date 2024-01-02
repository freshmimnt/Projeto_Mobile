package pt.iade.projetomobilelazuli.models.teste;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteRepository extends CrudRepository<Teste, Integer>{
    Teste findBydId(int id);

}
