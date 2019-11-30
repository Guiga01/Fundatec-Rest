package br.com.fundatec.carro.service;

import br.com.fundatec.carro.Repository.CarroRepository;
import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }
    public List<Carro> listaCarros(String nome){


        return carroRepository.listaCarros(nome);
    }
    public Carro consultar(Long id){
        return carroRepository.consultar(id);
    }
}
