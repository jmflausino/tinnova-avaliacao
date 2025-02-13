package com.tinnova.veiculos.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso","Entidade em uso"), 
	ERRO_DE_NEGOCIO("/erro-de-negocio","Violação na regra de negócio"), 
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel","Mensagem Incompreensível"), 
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"), 
	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"), 
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
	ACESSO_NEGADO("/acesso-negado", "Acesso negado");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) {
		this.title = title;
		this.uri = "http://gerenciador-veiculos.com.br" + path;
	}
}
