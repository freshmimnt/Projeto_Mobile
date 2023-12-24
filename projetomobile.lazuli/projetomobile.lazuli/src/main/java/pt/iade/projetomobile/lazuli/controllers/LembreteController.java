package pt.iade.projetomobile.lazuli.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.projetomobile.lazuli.models.lembrete.Lembrete;
import pt.iade.projetomobile.lazuli.models.lembrete.LembreteDao;


import java.util.List;

@RestController
public class LembreteController {

    @Autowired
    private LembreteDao lembreteDao;

    @GetMapping("/lemb/get")
    public List<Lembrete> getAllLembs(){
        return lembreteDao.getAllLembs();
    }

}
