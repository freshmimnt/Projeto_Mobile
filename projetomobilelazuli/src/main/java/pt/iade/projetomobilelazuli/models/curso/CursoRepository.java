package pt.iade.projetomobilelazuli.models.curso;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {

    Curso findById(int id);

}
