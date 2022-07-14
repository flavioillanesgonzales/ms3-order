package com.ms3.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.ms3.order.repository.repository;
import com.ms3.order.model.order;
import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ms-/order")
public class orderC {


    private repository orderR;


    private LoadBalancerClient loadBalancerClient;

    @Autowired
    public orderC(repository orderR) {
        this.orderR = orderR;
    }

    @GetMapping("/all")
    Iterable<order> all() {
        return orderR.findAll();
    }

    @GetMapping("/info")
    public List info() {
        // 1. La primera forma, usar directamente. Desventajas: es necesario especificar la dirección URL, es inflexible y no se puede adaptar a varias direcciones.
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9090/ms-/user/all", List.class);
    }
}


