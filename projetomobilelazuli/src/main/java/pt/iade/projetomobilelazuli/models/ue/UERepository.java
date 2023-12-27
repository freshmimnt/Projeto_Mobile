package pt.iade.projetomobilelazuli.models.ue;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UERepository extends CrudRepository<UE, Integer> {

    UE findById(int id);

}
