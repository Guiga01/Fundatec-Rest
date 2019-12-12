package br.com.fundatec.carro.service;

import br.com.fundatec.carro.Repository.CarroRepsitory;
import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {

    private final CarroRepsitory carroRepsitory;

    public CarroService(CarroRepsitory carroRepositoryFake, CarroRepsitory carroRepsitory) {
        this.carroRepsitory = carroRepsitory;
    }

    public List<Carro> listaCarros(String nome) {
        return carroRepsitory.findByNomeContainingIgnoreCase(nome);
    }

    public Carro consultar(Long id) {
        return carroRepsitory.findById(id).orElse(null);
    }

    public Carro incluir(Carro carro) {
        validar(carro);
        return carroRepsitory.save(carro);
    }

    private void validar(Carro carro) {
        List<String>marcaValidas = Arrays.asList("Fiat","Ford","Voklwagem");
        if(!marcaValidas.contains(carro.getMarca())){
            throw new RuntimeException("A marca "+ carro.getMarca() + " é invalida");
        }
        if (carro.getDataModelo().isBefore(carro.getDataFabricacao())) {
            throw new RuntimeException("Data de Fabricação deve ser menor que data modelo");

        }

    }


    public List<Carro> listaCarros(LocalDate dataInicio, LocalDate dataFim) {
        return carroRepsitory.findByDataFabricacaoBetween(dataInicio,dataFim);
    }
    public Carro atualizar(Long idCarro,Carro carroParaAtualizacao){
        Carro carro = consultar(idCarro);
        if(carro != null ){
            carro.setNome(carroParaAtualizacao.getNome());
            carro.setDataModelo(carroParaAtualizacao.getDataModelo());
            carro.setMarca(carroParaAtualizacao.getMarca());
            carro.setPlaca(carroParaAtualizacao.getPlaca());
            carro.setDataFabricacao(carroParaAtualizacao.getDataFabricacao());
            carro = carroRepsitory.save(carro);
        }
        return carro;
    }
}
