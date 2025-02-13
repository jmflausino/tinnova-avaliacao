package exercicio1.calculadora;

public class CalculadoraValidos extends CalculadoraEstatisticas {
	
	public CalculadoraValidos(int totalEleitores, int votos) {
		super(totalEleitores, votos);
	}

	@Override
	public String print() {
		return String.format("O Percentual de votos válidos é %1$,.2f %%", this.calcularPercentual());
	}
}
