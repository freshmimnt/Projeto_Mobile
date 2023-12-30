package pt.iade.projetomobilelazuli.models.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoDao {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllcursos(){
        List<Curso> cursos = new ArrayList<>();
        Streamable.of(cursoRepository.findAll())
                .forEach(cursos::add);
        return cursos;
    }

}


