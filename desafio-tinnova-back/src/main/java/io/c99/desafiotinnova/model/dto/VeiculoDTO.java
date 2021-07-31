package io.c99.desafiotinnova.model.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.c99.desafiotinnova.model.Veiculo;

public class VeiculoDTO {
    long id;
    String veiculo;
    String marca;
    int ano;
    String descricao;
    boolean vendido;
    String created;
    String updated;

    public static Veiculo fromDTO(VeiculoDTO v) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Veiculo veiculo = new Veiculo();
        veiculo.setVeiculo(v.veiculo);
        veiculo.setMarca(v.marca);
        veiculo.setAno(v.ano);
        veiculo.setDescricao(v.descricao);
        veiculo.setVendido(v.vendido);
        veiculo.setCreated(format.parse(v.created));
        veiculo.setUpdated(new Date());
        return veiculo;
    }

    public void toDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.veiculo = veiculo.getVeiculo();
        this.marca = veiculo.getMarca();
        this.ano = veiculo.getAno();
        this.descricao = veiculo.getDescricao();
        this.vendido = veiculo.isVendido();
        this.created = veiculo.getCreated().toString();
        this.updated = veiculo.getUpdated().toString();
    }
}
