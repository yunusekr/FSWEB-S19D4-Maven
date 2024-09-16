package com.workintech.s19d1.controller;


import com.workintech.s19d1.dto.ActorResponse;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.entity.Actor;

import com.workintech.s19d1.util.Converter;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Long id) {
        Actor finded = actorService.findById(id);;
        if(finded != null) {
            return finded;
        }
        throw new RuntimeException("actor is not found with id: " + finded);
    }

    @PostMapping
    public Actor save(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public ActorResponse update(@RequestBody Actor actor, @PathVariable Long id) {
        Actor foundActor = actorService.findById(id);
        actor.setMovies(foundActor.getMovies());
        actor.setId(foundActor.getId());
        actorService.save(actor);
        return Converter.actorResponseConvert(actor);
    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable long id) {
        Actor foundActor = actorService.findById(id);
        actorService.delete(foundActor);
        return Converter.actorResponseConvert(foundActor);
    }
}