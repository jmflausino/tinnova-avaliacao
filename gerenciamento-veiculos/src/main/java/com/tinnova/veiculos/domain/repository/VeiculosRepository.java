package com.tinnova.veiculos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinnova.veiculos.domain.model.Veiculo;

public interface VeiculosRepository extends JpaRepository<Veiculo, Long>{

}
