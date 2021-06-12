package com.techprimers.db.resource;

import com.techprimers.db.model.Player;
import com.techprimers.db.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/rest/players")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping(value = "/all")
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Player> persist(@RequestBody final Player player) {
    	playerRepository.save(player);
        return playerRepository.findAll();
    }
    @GetMapping("/{name}")
    public List<Player> getUser(@PathVariable("name") final String name) {
        return playerRepository.findByName(name);

    }
    @GetMapping("/id/{id}")
    public Optional<Player> getId(@PathVariable("id") final Integer id) {
        return playerRepository.findById(id);
    }

   /*@GetMapping("/update/{id}/{name}")
    public Player update(@PathVariable("id") final Integer id, @PathVariable("name")
                         final String name) {


    	Player player = getId(id);
    	player.setName(name);

        return playerRepository.save(player);
    }*/
    

}
