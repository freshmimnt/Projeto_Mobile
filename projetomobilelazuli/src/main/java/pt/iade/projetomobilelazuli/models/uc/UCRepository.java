package pt.iade.projetomobilelazuli.models.uc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UCRepository extends CrudRepository<UC, Integer> {

    UC findById(int id);
    UC deleteByUserId(int UC_user_id);

}
