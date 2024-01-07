package pt.iade.projetomobilelazuli.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {

    Curso findById(int id);

}
