package pt.iade.projetomobilelazuli.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.UC;

@Repository
public interface UCRepository extends CrudRepository<UC, Integer> {

    UC findById(int id);

}
