package pt.iade.projetomobilelazuli.models.pamizade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PAmizadeDao {
    @Autowired
    private PAmizadeRepository PAmizadeRepository;
    public void save(PAmizade pAmizade){
        PAmizadeRepository.save(pAmizade);
    }
}
