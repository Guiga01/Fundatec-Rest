package br.com.fundatec.carro.api.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {
    public List<String> listaCarros(){
        List<String> carros = Arrays.asList("Mustang","Fusca","Fumbica","Celta","Uno com Escada");
        return carros;
    }
}
