package exercicio4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalculadoraMultiplos {

	private int numero;

	public CalculadoraMultiplos(int numero) {
		this.numero = numero;
	}

	public int getSomaMultiplos() {
		return IntStream.range(0, this.getNumero())
				.filter(n -> n % 3 == 0 || n % 5 == 0)
				.boxed().collect(Collectors.summingInt(Integer::intValue));

	}

	public int getNumero() {
		return this.numero;
	}

}
