package pt.iade.projetomobilelazuli.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.Horario;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Integer> {

    Horario findById(int id);

}