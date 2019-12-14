package br.com.fundatec.carro.api;

import br.com.fundatec.carro.api.Dto.CarroImputDto;
import br.com.fundatec.carro.api.Dto.CarroOutputDto;
import br.com.fundatec.carro.api.Dto.ErroDto;
import br.com.fundatec.carro.mapper.CarroMapper;
import br.com.fundatec.carro.model.Carro;
import br.com.fundatec.carro.service.CarroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class CarroApi {

    private final CarroService carroService;
    private final CarroMapper carroMapper;

    public CarroApi(CarroService carroService, CarroMapper carroMapper) {
        this.carroService = carroService;
        this.carroMapper = carroMapper;
    }


    @GetMapping("carros")
    public ResponseEntity<List<CarroOutputDto>> getCarros(@RequestParam(required = false, defaultValue = "") String nome) {
        List<Carro> carros = carroService.listaCarros(nome);
        return getListResponseEntityCarroOutputDto(carros);

    }

    @GetMapping("/carros/{id}")
    public ResponseEntity<CarroOutputDto> getCarro(@PathVariable Long id) {
        Carro carro = carroService.consultar(id);
        if (carro != null) {

            CarroOutputDto carroOutputDto = carroMapper.mapear(carro);
            return ResponseEntity.ok(carroOutputDto);
        }

        return ResponseEntity.noContent().build();

    }

    @PostMapping("/carros")
    @ApiOperation(value = "Faz a inclusão de um carro no banco de dados",
            notes = "Valida se os campos obrigatório, valida se a data fabricação é no passado .. . voltaremos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Carro incluido com sucesso", response =CarroOutputDto.class ),
    })

    public ResponseEntity<?> incluir(@Valid @RequestBody CarroImputDto carroImputDto) {
        Carro carro = carroMapper.mapear(carroImputDto);
        try {
            carro = carroService.incluir(carro);
            CarroOutputDto carroOutputDto = carroMapper.mapear(carro);
            return ResponseEntity.status(HttpStatus.CREATED).body(carroOutputDto);
        } catch (RuntimeException e) {
            ErroDto erroDto = new ErroDto();
            erroDto.setMensagem(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(erroDto);

        }

    }

    @GetMapping("/carros/datas")
    @ApiOperation(value = "Lista todos os carros contidos no banco",
            notes = "lista carros, filtra por data de fabricaçõa menores que de modelo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Conculta realizada com sucesso", response =CarroOutputDto.class ),
    })
    public ResponseEntity<List<CarroOutputDto>> listar(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        List<Carro> carros = carroService.listaCarros(dataInicio, dataFim);
        return getListResponseEntityCarroOutputDto(carros);
    }

    private ResponseEntity<List<CarroOutputDto>> getListResponseEntityCarroOutputDto(List<Carro> carros) {
        if (carros.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        List<CarroOutputDto> carrosOutputDtos = carroMapper.mapear(carros);
        return ResponseEntity.ok(carrosOutputDtos);
    }

    @PutMapping("/carros/{id}")
    public ResponseEntity<?> atualizarCarro(@PathVariable Long id, @RequestBody CarroImputDto carroImputDto) {
        Carro carro = carroMapper.mapear(carroImputDto);
        carro = carroService.atualizar(id, carro);
        if (carro == null) {
            return ResponseEntity.noContent().build();
        }
        CarroOutputDto carroOutputDto = carroMapper.mapear(carro);
        return ResponseEntity.ok(carroOutputDto);


    }
    @DeleteMapping ("/carros/{id}")
    public ResponseEntity<?> excluirCarro(@PathVariable Long id){
        carroService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
