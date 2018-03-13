package com.geodis.rt.controller;

import com.geodis.rt.service.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerA {

    private final ServiceA serviceA;

    @Autowired
    public ControllerA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @GetMapping(value = "/a")
    public String simple() {
        return serviceA.getAString();
    }
}
