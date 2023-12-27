package pt.iade.projetomobilelazuli.models.ue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UEDao {
    @Autowired
    private UERepository ueRepository;

    public void save(UE ue){
        ueRepository.save(ue);
    }

    public List<UE> getAllUsers(){
        List<UE> ue = new ArrayList<>();
        Streamable.of(ueRepository.findAll())
                .forEach(ue::add);
        return ue;
    }

    public void delete(UE ue){

        ueRepository.delete(ue);
    }
}
