package br.com.fundatec.carro.Repository;

import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarroRepository {
    public List<Carro> listaCarros(String nome){
        List<Carro>listaResultado = new ArrayList<>();
        for(Carro carro : getlistaCarros){
            if(carro.getNome().toLowerCase().contains(nome.toLowerCase())){
                listaResultado.add(carro);
            }
        }
        return listaResultado;



    }
    public Carro consultar(Long id){
        for (Carro carro : getlistaCarros) {
            if (carro.getId().equals(id)){
                return carro;
            }
        }
        return null;
    }

    private static List<Carro> getlistaCarros () {
       if (listaCarros == null){
        (new Carro(1l, "Mustang", "MAX1000"),
                new Carro(2l, "Uno Com Escada", "ABCS1234"),
                new Carro(3l, "Chevette", "QWER7894"));
    }
    public Carro incluir(Carro carro) {
        carro.setId(new Long (getlistaCarros.size() + 1l));
        listaCarros.add(carro);
        return carro;
    }
}
