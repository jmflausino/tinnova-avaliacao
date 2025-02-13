package exercicio3;

import java.util.stream.IntStream;

public class CalculadoraFatorial {
	
	private int numero;

	public CalculadoraFatorial(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int fatorial() {
		return IntStream.rangeClosed(2, this.getNumero()).reduce(1, (x, y) -> x * y);
	}
}
