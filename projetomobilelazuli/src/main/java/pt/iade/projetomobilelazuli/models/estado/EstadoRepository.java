package pt.iade.projetomobilelazuli.models.estado;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer> {

    Estado findById(int id);

}