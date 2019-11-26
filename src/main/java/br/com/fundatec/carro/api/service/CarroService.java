package br.com.fundatec.carro.api.service;

import br.com.fundatec.carro.Repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }
    public List<String> listaCarros(String nome){


        return carroRepository.listaCarros(nome);
    }
}
