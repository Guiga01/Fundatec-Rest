package br.com.fundatec.carro.mapper;

import br.com.fundatec.carro.api.Dto.CarroImputDto;
import br.com.fundatec.carro.api.Dto.CarroOutputDto;
import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarroMapper {
    public CarroOutputDto mapear (Carro carro){
        CarroOutputDto carroOutputDto = new CarroOutputDto();
        carroOutputDto.setId(carro.getId());
        carroOutputDto.setNome(carro.getNome());
        carroOutputDto.setPlaca((carro.getPlaca()));
        carroOutputDto.setDataFabricacao(carro.getDataFabricacao());
        carroOutputDto.setDataModele(carro.getDataModelo());
        carroOutputDto.setMarca(carro.getMarca());
        return carroOutputDto;
    }
    public List<CarroOutputDto>mapear(List<Carro> carros){
        List<CarroOutputDto> carroOutputDtos = new ArrayList<>();
        for (Carro carro : carros){
            carroOutputDtos.add(mapear(carro));
        }
        return carroOutputDtos;
    }
    public Carro mapear(CarroImputDto carroImputDto){
        Carro carro = new Carro();
        carro.setNome(carroImputDto.getNome());
        carro.setPlaca(carroImputDto.getPlaca());
        carro.setDataFabricacao(carroImputDto.getDataFabricacao());
        carro.setDataModelo(carroImputDto.getDataModelo());
        carro.setMarca(carroImputDto.getMarca());
        return carro;
    }


}
