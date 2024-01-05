package pt.iade.projetomobilelazuli.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.Agenda;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Integer> {

    Agenda findById(int id);

}
