package br.com.fundatec.carro.Repository;

import br.com.fundatec.carro.model.Carro;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarroRepsitory extends CrudRepository<Carro, Long> {
    List<Carro> findByNomeContainingIgnoreCase(String nome);
    List<Carro> findByDataFabricacaoBetween(LocalDate dataInicio,LocalDate dataFim);
    }
