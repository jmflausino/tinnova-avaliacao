package com.tinnova.veiculos.api.controllers.model.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tinnova.veiculos.api.controllers.model.input.VeiculoInput;
import com.tinnova.veiculos.domain.model.Veiculo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VeiculoInputDisassembler {

	private final ModelMapper mapper;
	
	public Veiculo toDomainObject(VeiculoInput input) {
		return mapper.map(input, Veiculo.class);
	}
	
	public void copyToDomainObject(VeiculoInput input, Veiculo veiculo) {
		mapper.map(input, veiculo);
	}

}
