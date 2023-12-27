package pt.iade.projetomobilelazuli.models.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoDao {

    @Autowired
    private EstadoRepository estadoRepository;

    public void save(Estado estado) {estadoRepository.save(estado);}

}