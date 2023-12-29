package pt.iade.projetomobilelazuli.models.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer> {

    Utilizador findById(int id);

    Utilizador deleteUtilizadorById(int id);

}
