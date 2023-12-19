package pt.iade.projetomobile.lazuli.models.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer> {



}
