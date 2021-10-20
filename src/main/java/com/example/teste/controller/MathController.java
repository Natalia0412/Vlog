package com.example.teste.controller;

import com.example.teste.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/math")
public class MathController {
    @Autowired
    private MathService service;
    @GetMapping("/soma")
    public int soma(@RequestParam int n1,@RequestParam int n2) {
        return service.soma(n1,n2);
    }
    @GetMapping("/subtracao")
    public int subtracao(@RequestParam int n1,@RequestParam int n2){
        return service.subtracao(n1,n2);
    }

    @GetMapping("/multi")
    public int multi(@RequestParam int n1,@RequestParam int n2){
        return service.multi(n1,n2);
    }

    @GetMapping("/quadrado")
    public int quadrado(@RequestParam int n1){
        return service.quadrado(n1);
    }
    @GetMapping("/raiz")
    public double raiz(@RequestParam int n1){
        return service.raiz(n1);
    }
}
