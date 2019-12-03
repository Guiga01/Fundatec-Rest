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

    public List<Carro> listaCarros(String nome) {


        return carroRepository.listaCarros(nome);
    }

    public Carro consultar(Long id) {
        return carroRepository.consultar(id);
    }

    public Carro incluir(Carro carro) {
        return carroRepository.incluir(carro);
    }

    private void validar(Carro carro) {
        if (carro.getDataModelo().isBefore(carro.getDataFabricacao())) {
            throw new RuntimeException("Data de Fabricação deve ser menor que data modelo");

        }

    }


}
