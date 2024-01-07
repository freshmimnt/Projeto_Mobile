package pt.iade.projetomobilelazuli.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.User;

@Repository
public interface UtilizadorRepository extends CrudRepository<User, Integer> {

    User findById(int id);

    User findByEmailAndPassword(String email, String password);
}
