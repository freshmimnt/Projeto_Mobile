package pt.iade.projetomobilelazuli.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.Utilizador;

@Repository
public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer> {

    Utilizador findById(int id);

}
