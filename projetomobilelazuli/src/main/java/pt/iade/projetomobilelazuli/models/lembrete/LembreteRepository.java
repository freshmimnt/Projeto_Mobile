package pt.iade.projetomobilelazuli.models.lembrete;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends CrudRepository<Lembrete, Integer> {

    Lembrete findById(int id);

}
