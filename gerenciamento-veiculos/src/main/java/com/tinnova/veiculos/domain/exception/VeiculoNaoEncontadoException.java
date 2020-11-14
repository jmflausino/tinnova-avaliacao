package com.tinnova.veiculos.domain.exception;

public class VeiculoNaoEncontadoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public VeiculoNaoEncontadoException(String mensagem) {
		super(mensagem);
	}

	public VeiculoNaoEncontadoException(Long veiculoId) {
		this(String.format("Não existe veículo cadastrado com o id: %d ", veiculoId));
	}

}