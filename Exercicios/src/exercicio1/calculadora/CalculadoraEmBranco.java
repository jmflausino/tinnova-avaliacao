package exercicio1.calculadora;

public class CalculadoraEmBranco extends CalculadoraEstatisticas {
	
	public CalculadoraEmBranco(int totalEleitores, int votos) {
		super(totalEleitores, votos);
	}

	@Override
	public String print() {
		return String.format("O Percentual de votos em branco é %1$,.2f %%", this.calcularPercentual());
	}
}
