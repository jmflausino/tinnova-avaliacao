package com.tinnova.veiculos.core.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MontadorasPermitidasValidator implements ConstraintValidator<MontadorasPermitidas, String> {

	private List<String> montadorasPermidas;
	
	@Override
	public void initialize(MontadorasPermitidas constraintAnnotation) {
		this.montadorasPermidas = Arrays.asList(constraintAnnotation.allowed());
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return montadorasPermidas == null || montadorasPermidas.contains(value.toUpperCase());
	}

}
