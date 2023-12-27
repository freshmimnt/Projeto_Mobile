package pt.iade.projetomobilelazuli.models.uc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UCRepository extends CrudRepository<UC, Integer> {
}
