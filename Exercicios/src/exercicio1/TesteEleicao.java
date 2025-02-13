package exercicio1;

import exercicio1.calculadora.CalculadoraEmBranco;
import exercicio1.calculadora.CalculadoraEstatisticas;
import exercicio1.calculadora.CalculadoraNulos;
import exercicio1.calculadora.CalculadoraValidos;

public class TesteEleicao {

	public static void main(String[] args) {
		
		CalculadoraEstatisticas calculadoraValidos = new CalculadoraValidos(1000, 800);
		CalculadoraEstatisticas calculadoraEmBranco = new CalculadoraEmBranco(1000, 150);
		CalculadoraEstatisticas calculadoraNulos = new CalculadoraNulos(1000, 50);

		System.out.println("====================== Relatório Eleição =======================");
		
		System.out.println(calculadoraValidos.print());		
		System.out.println(calculadoraEmBranco.print());
		System.out.println(calculadoraNulos.print());
	}

}
