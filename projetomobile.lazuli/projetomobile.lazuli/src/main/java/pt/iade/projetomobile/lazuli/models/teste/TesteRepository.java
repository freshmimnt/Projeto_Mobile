package pt.iade.projetomobile.lazuli.models.teste;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteRepository extends CrudRepository<Teste, Integer>{
}
