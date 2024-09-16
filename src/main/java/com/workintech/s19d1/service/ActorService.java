package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<Actor> findAll();

    Actor findById(Long id);

    Actor save(Actor actor);

    Actor update(Long id, Actor actor);

    void delete(Actor actor);
}