package pt.iade.projetomobile.lazuli.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobile.lazuli.models.user.Utilizador;
import pt.iade.projetomobile.lazuli.models.user.UtilizadorDao;

import java.util.List;


@RestController
public class UtilizadorController {
    @Autowired
    private UtilizadorDao utilizadorDao;

    @GetMapping("/user/get")
    public List<Utilizador> getAllUsers(){
        return utilizadorDao.getAllUsers();
    }

    @PostMapping("/user/save")
    public void save(@RequestBody Utilizador utilizador){
        utilizadorDao.save(utilizador);
    }


}
