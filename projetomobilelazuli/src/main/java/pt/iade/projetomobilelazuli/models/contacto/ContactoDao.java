package pt.iade.projetomobilelazuli.models.contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ContactoDao {

    @Autowired
    private ContactoRepository contactoRepository;

    public void save(Contacto contacto) {contactoRepository.save(contacto);}

}
