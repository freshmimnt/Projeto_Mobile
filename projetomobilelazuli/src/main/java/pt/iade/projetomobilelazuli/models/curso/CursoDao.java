package pt.iade.projetomobilelazuli.models.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoDao {

    @Autowired
    private CursoRepository cursoRepository;

    public void save(Curso curso){
        cursoRepository.save(curso);
    }

    public void delete(Curso curso){
        cursoRepository.delete(curso);
    }

}


