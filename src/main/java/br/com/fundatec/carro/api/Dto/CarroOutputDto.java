package br.com.fundatec.carro.api.Dto;

import java.time.LocalDate;

public class CarroOutputDto {
    private Long id;
    private String nome;
    private String marca;
    private LocalDate dataFabricacao;
    private LocalDate dataModele;
    private String placa;

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

    public LocalDate getDataModele() {
        return dataModele;
    }

    public void setDataModele(LocalDate dataModele) {
        this.dataModele = dataModele;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
