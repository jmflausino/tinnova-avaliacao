package com.tinnova.veiculos.core.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
		ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { MontadorasPermitidasValidator.class })
public @interface MontadorasPermitidas {

	String message() default "montadora inválida";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String[] allowed();

}