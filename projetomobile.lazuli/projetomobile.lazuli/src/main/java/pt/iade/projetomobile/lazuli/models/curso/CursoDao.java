package pt.iade.projetomobile.lazuli.models.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoDao {

    @Autowired
    private  CursoRepository cursoRepository;

    public void save(Curso curso){
        cursoRepository.save(curso);
    }

    public List<Curso> getAllCursos(){
        List<Curso> cursos = new ArrayList<>();
        Streamable.of(cursoRepository.findAll())
                .forEach(cursos::add);
        return cursos;
    }

    public void delete(Curso curso){
        cursoRepository.delete(curso);
    }

}
