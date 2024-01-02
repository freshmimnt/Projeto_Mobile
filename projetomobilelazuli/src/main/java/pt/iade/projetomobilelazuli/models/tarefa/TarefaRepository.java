package pt.iade.projetomobilelazuli.models.tarefa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Integer> {

    Tarefa findById(int id);

}
