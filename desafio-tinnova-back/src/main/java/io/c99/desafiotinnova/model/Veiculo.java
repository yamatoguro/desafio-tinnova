package io.c99.desafiotinnova.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "veiculo")
@ApiModel(description = "Veículos de qualquer tipo")
public class Veiculo {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "veiculo")
    @ApiModelProperty(notes = "Modelo do veículo", example = "A4")
    private String veiculo;

    @Column(name = "marca")
    @ApiModelProperty(notes = "Marca do veículo", example = "Audi")
    private String marca;

    @Column(name = "ano")
    @ApiModelProperty(notes = "Ano de fabricação do veículo", example = "2019")
    private int ano;

    @Column(name = "descricao")
    @ApiModelProperty(notes = "Descrição do veículo", example = "Veículo azul, semi-novo, com arranhões na lateral")
    private String descricao;

    @Column(name = "vendido")
    @ApiModelProperty(notes = "Veículo foi ou não vendido", example = "true")
    private boolean vendido;

    @Temporal(TemporalType.DATE)
    @Column(name = "created", nullable = false)
    @ApiModelProperty(notes = "Data e hora de cadastro do veículo", example = "2019-01-25 10:55:21")
    private Date created;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated", nullable = false)
    @ApiModelProperty(notes = "Data e hora da última atualização no cadastro do veículo", example = "2019-01-25 10:55:21")
    private Date updated;
}
