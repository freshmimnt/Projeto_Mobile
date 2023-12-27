package pt.iade.projetomobilelazuli.models.horario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Integer> {

    Horario findById(int id);

}