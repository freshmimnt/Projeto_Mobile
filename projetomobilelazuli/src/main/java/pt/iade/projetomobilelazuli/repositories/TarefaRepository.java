package pt.iade.projetomobilelazuli.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Integer> {

    Tarefa findById(int id);

}
