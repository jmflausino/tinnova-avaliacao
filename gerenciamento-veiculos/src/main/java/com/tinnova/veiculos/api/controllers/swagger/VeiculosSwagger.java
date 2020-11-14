package com.tinnova.veiculos.api.controllers.swagger;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tinnova.veiculos.api.controllers.model.input.VeiculoInput;
import com.tinnova.veiculos.api.controllers.model.output.VeiculoOutput;
import com.tinnova.veiculos.api.exceptionhandler.Problem;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Veiculos")
public interface VeiculosSwagger {

	@ApiOperation("Buscar um veiculo por id")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Id do veículo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Veículo Não encontrado", response = Problem.class) }
	)
	VeiculoOutput buscar(@ApiParam(value = "ID de um veiculo", example = "1") Long veiculoId);
	
	List<VeiculoOutput> pesquisar();
	

	@ApiOperation("Listar os veículos")
	List<VeiculoOutput> listar();
	

	@ApiOperation("Adicionar um veículo")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Id da Veículo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Veículo Não encontrado", response = Problem.class) }
	)
	VeiculoOutput adicionar(VeiculoInput input);


	@ApiOperation("Atualizar um veículo")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Id da Veículo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Veículo Não encontrado", response = Problem.class) }
	)
	VeiculoOutput atualizar(@ApiParam(value = "ID de um veiculo", example = "1") Long veiculoId, VeiculoInput input);

	
	@ApiOperation("Atualizar um veículo parcialmente")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Id da Veículo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Veículo Não encontrado", response = Problem.class) }
	)
	VeiculoOutput atualizarParcial(@ApiParam(value = "ID de um veiculo", example = "1") Long veiculoId, Map<String, Object> campos, HttpServletRequest servletRequest);

	
	

	@ApiOperation("Remover um veículo por id")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Id da Veículo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Veículo Não encontrado", response = Problem.class) }
	)
	void excluir(Long veiculoId);

}