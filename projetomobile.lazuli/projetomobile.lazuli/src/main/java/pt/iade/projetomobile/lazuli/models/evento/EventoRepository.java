package pt.iade.projetomobile.lazuli.models.evento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Integer>{

    Evento findById(int id);

}
