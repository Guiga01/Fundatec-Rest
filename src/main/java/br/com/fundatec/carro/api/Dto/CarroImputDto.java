package br.com.fundatec.carro.api.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CarroImputDto {
    @NotBlank(message = "campo é obrigatório")
    private String nome;
    @Pattern(regexp = "^[A-Z]{3}[0-9]{4}$", message = "placa invalida")
    @NotBlank(message = "campo é obrigatório")
    private String placa;
    @Past(message = "erro na data")
    @NotNull(message = "o campo esta vazio")
    private LocalDate dataFabricacao;
    @NotNull(message = "o campo esta vazio")
    private LocalDate dataModelo;
    @NotNull(message ="o campo esta vazio" )
    private String marca;
    private LocalDate dataInic;
    private LocalDate dataFim;

    public LocalDate getDataInic() {
        return dataInic;
    }

    public void setDataInic(LocalDate dataInic) {
        this.dataInic = dataInic;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataModelo() {
        return dataModelo;
    }

    public void setDataModelo(LocalDate dataModelo) {
        this.dataModelo = dataModelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
