package br.com.fundatec.carro.Repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class CarroRepository {
    public List<String> listaCarros(String nome){
        List<String> carros = Arrays.asList("Mustang","Fusca","Fumbica","Celta","Uno com Escada");
        String filtrado ="";

        List<String>listaResultado = new ArrayList<>();
        for(String carro : carros){
            if(carro.toLowerCase().contains(nome.toLowerCase())){
                listaResultado.add(carro);
            }
        }
        return listaResultado;



    }
}
