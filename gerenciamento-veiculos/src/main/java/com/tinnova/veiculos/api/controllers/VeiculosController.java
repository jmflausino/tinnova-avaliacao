package com.tinnova.veiculos.api.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinnova.veiculos.api.controllers.model.assembler.VeiculoInputDisassembler;
import com.tinnova.veiculos.api.controllers.model.assembler.VeiculosOuputAssembler;
import com.tinnova.veiculos.api.controllers.model.input.VeiculoInput;
import com.tinnova.veiculos.api.controllers.model.output.VeiculoOutput;
import com.tinnova.veiculos.api.controllers.swagger.VeiculosSwagger;
import com.tinnova.veiculos.domain.model.Veiculo;
import com.tinnova.veiculos.domain.service.CadastroVeiculoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculosController implements VeiculosSwagger {
	
	private final CadastroVeiculoService service;
	private final VeiculoInputDisassembler disassembler;
	private final VeiculosOuputAssembler assembler;
	
	@Override
	@GetMapping("/{veiculoId}")
	public VeiculoOutput buscar(@PathVariable Long veiculoId) {
		return this.assembler.toOutput(this.service.buscarOuFalhar(veiculoId));
	}
	
	@Override
	public List<VeiculoOutput>  pesquisar() {
		return null;
	}
	
	@Override
	@GetMapping
	public List<VeiculoOutput> listar() {
		return this.assembler.toCollectionOuput(this.service.listarVeiculos());
	}
	
	@Override
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public VeiculoOutput adicionar(@RequestBody @Valid VeiculoInput input) {
		Veiculo veiculoAdicionado = this.service.salvar(this.disassembler.toDomainObject(input));
		
		return this.assembler.toOutput(veiculoAdicionado);
	}
	
	@Override
	@PutMapping("/{veiculoId}")
	public VeiculoOutput atualizar(@PathVariable Long veiculoId, @RequestBody  @Valid VeiculoInput input) {
		Veiculo veiculoAtual = this.service.buscarOuFalhar(veiculoId);
		this.disassembler.copyToDomainObject(input, veiculoAtual);
		
		return this.assembler.toOutput(this.service.salvar(veiculoAtual));
	}
	
	@Override
	@PatchMapping("/{veiculoId}")
	public VeiculoOutput atualizarParcial(@PathVariable Long veiculoId, 
			@RequestBody Map<String, Object> campos, HttpServletRequest servletRequest) {
		
		Veiculo veiculoAtual = this.service.buscarOuFalhar(veiculoId);
		
		merge(campos, veiculoAtual, servletRequest);

		return this.assembler.toOutput(this.service.salvar(veiculoAtual));
	}

	private void merge(Map<String, Object> dadosOrigem, Veiculo veiculoDestino, HttpServletRequest servletRequest) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

			Veiculo restauranteOrigem = objectMapper.convertValue(dadosOrigem, Veiculo.class);

			dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
				Field field = ReflectionUtils.findField(Veiculo.class, nomePropriedade);
				field.setAccessible(true);

				Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
				ReflectionUtils.setField(field, veiculoDestino, novoValor);
			});
		} catch (IllegalArgumentException e) {
			Throwable rootCause = e.getCause();
			ServletServerHttpRequest serverHttpRequest = new ServletServerHttpRequest(servletRequest);
			
			throw new HttpMessageNotReadableException(e.getMessage(), rootCause, serverHttpRequest);
		}
	}
	
	@Override
	@DeleteMapping("/{veiculoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long veiculoId) {
		this.service.excluir(veiculoId);
	}
}
