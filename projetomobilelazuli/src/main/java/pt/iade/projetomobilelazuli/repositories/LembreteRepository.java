package pt.iade.projetomobilelazuli.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.projetomobilelazuli.models.Lembrete;

@Repository
public interface LembreteRepository extends CrudRepository<Lembrete, Integer> {

    Lembrete findById(int id);

}
