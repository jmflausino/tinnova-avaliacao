package com.tinnova.veiculos.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel("Problema")
@Getter
@Builder
@JsonInclude(value = Include.NON_NULL)
public class Problem {
	
	@ApiModelProperty(example = "400")
	private Integer status;
	
	@ApiModelProperty(example = "https://tinnova-teste.com.br/dados-invalidos")
	private String type;
	
	@ApiModelProperty(example = "Dados Inválidos")
	private String title;
	
	@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
	private String detail;
	
	private String userMessage;
	
	@ApiModelProperty(example = "2020-08-18T19:51:00")
	private OffsetDateTime timestamp;
	
	@ApiModelProperty("Campos que geraram erros")
	private List<Field> fields;
	
	@Builder
	@Getter
	public static class Field {
		@ApiModelProperty(example = "ano")
		private String name;
		
		@ApiModelProperty(example = "O ano é obrigatório")
		private String userMessage;
	}
}
