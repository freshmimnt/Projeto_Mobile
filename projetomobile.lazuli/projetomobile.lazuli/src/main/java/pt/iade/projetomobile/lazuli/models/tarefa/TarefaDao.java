package pt.iade.projetomobile.lazuli.models.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaDao {

    @Autowired
    private TarefaRepository tarefaRepository;

    public void save(Tarefa tarefa){
        tarefaRepository.save(tarefa);
    }

}
