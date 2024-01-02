package pt.iade.projetomobilelazuli.models.uc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UCDao {
    @Autowired
    private UCRepository ucRepository;
    public void save(UC uc){
        ucRepository.save(uc);
    }

    public List<UC> getAllUCs() {
        return null;
    }
}
