package com.tinnova.veiculos.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tinnova.veiculos.domain.exception.VeiculoNaoEncontadoException;
import com.tinnova.veiculos.domain.model.Veiculo;
import com.tinnova.veiculos.domain.repository.VeiculosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastroVeiculoService {
	
	private final VeiculosRepository veiculosRepository;
	
	public List<Veiculo> listarVeiculos() {
		return this.veiculosRepository.findAll();
	}
	
	public Veiculo buscarOuFalhar(Long veiculoId) {
		return this.veiculosRepository.findById(veiculoId)
				.orElseThrow(() -> new VeiculoNaoEncontadoException(veiculoId));
	}
	
	@Transactional
	public Veiculo salvar(Veiculo veiculo) {
		return this.veiculosRepository.save(veiculo);
	}
	
	@Transactional
	public void excluir(Long veiculoId) {
		try {
			this.veiculosRepository.deleteById(veiculoId);
			this.veiculosRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new VeiculoNaoEncontadoException(veiculoId);
	    }
	}
}
