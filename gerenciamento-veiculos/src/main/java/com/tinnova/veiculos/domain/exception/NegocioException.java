package com.tinnova.veiculos.domain.exception;

public class NegocioException extends RuntimeException { 
	
	private static final long serialVersionUID = 1L;
	
	public NegocioException(String mensagem, Throwable e) {
		super (mensagem, e);
	}
	
	public NegocioException(String mensagem) {
		super (mensagem);
	}

}