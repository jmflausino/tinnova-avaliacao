package exercicio1.calculadora;

public class CalculadoraNulos extends CalculadoraEstatisticas {

	public CalculadoraNulos(int totalEleitores, int votos) {
		super(totalEleitores, votos);
	}

	@Override
	public String print() {
		return String.format("O Percentual de votos nulos é %1$,.2f %%", this.calcularPercentual());
	}

}
