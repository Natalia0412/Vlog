package com.example.teste.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    public int soma(int n1,int n2){
        return n1+n2;
    }

    public int subtracao(int n1,int n2){
        return n1-n2;
    }
    public int multi(int n1,int n2){
        return n1*n2;
    }

    public int quadrado(int n1){
        return n1*n1;
    }

    public double raiz(int n1){
        return Math.sqrt(n1);
    }


}
