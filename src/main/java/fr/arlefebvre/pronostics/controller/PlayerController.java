package fr.arlefebvre.pronostics.controller;

import fr.arlefebvre.pronostics.model.Player;
import fr.arlefebvre.pronostics.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alefebvre on 25/05/2016.
 */
@RestController
public class PlayerController {

    @Autowired
    PlayerRepository repo;

    @RequestMapping("/admin/players")
    public List<Player> players() {
        return repo.findAll();
    }
}
