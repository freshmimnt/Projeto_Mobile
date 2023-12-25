package pt.iade.projetomobilelazuli.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobilelazuli.models.user.Utilizador;
import pt.iade.projetomobilelazuli.models.user.UtilizadorDao;
import pt.iade.projetomobilelazuli.models.user.UtilizadorRepository;

import java.util.List;

@RestController
public class UtilizadorController {
    @Autowired
    private UtilizadorDao utilizadorDao;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @GetMapping("/user/get")
    public List<Utilizador> getAllUsers(){
        return utilizadorDao.getAllUsers();
    }

    @PostMapping("/user/save")
    public void save(@RequestBody Utilizador utilizador){

        utilizadorDao.save(utilizador);
    }

    @DeleteMapping("/user/deleteid{id}")
    public void delete(@PathVariable("id") int id){

        utilizadorDao.delete(utilizadorRepository.findById(id));
    }

}