package pt.iade.projetomobilelazuli.models.contacto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Integer> {

    Contacto findById(int id);
}
