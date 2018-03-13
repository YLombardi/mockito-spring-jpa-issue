package com.geodis.rt.controller;

import com.geodis.rt.repo.JpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerB {

    private final JpaRepo jpaRepo;

    @Autowired
    public ControllerB(JpaRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @GetMapping(value = "/b")
    public String simple() {
        return jpaRepo.findStringById("id");
    }
}
