package br.com.fundatec.carro.api;

import br.com.fundatec.carro.api.service.CarroService;
import br.com.fundatec.carro.model.Carro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarroApi {

    private  final CarroService carroService;
    public CarroApi(CarroService carroService){
        this.carroService = carroService;
    }


    @GetMapping("carros")
    public ResponseEntity <List<Carro>> getCarros(@RequestParam (required = false, defaultValue = "") String nome){
        List<Carro> carros = carroService.listaCarros(nome);
        if(carros.size() == 0 ){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body((carros));
        }
        return ResponseEntity.ok(carros);

    }
    @GetMapping("/carros/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable Long id){
        Carro carro = carroService.consultar(id);
        if (carro == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body((carro));
        }
        return ResponseEntity.ok(carro);

    }
}
