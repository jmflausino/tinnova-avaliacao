package com.tinnova.veiculos.api.controllers.model.output;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoOutput {
	
	@ApiModelProperty("identificador do veículo")
	private Long id;
	
	@ApiModelProperty("Nome do veículo")
	private String veiculo;
	
	@ApiModelProperty("Marca do veículo")
	private String marca;
	
	@ApiModelProperty("Ano do veículo")
	private Integer ano;
	
	@ApiModelProperty("Descrição do veículo")
	private String descricao;
	
	@ApiModelProperty("Campos que geraram erros")	
	private Boolean vendido;
	
	@ApiModelProperty("Data de criação do veículo")
	private OffsetDateTime created;
	
	@ApiModelProperty("Data de atualização do veículo")
	private OffsetDateTime updated;
}
