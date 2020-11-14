package exercicio1.calculadora;

public abstract class CalculadoraEstatisticas {
	
	private int totalEleitores;
	private int votos;
	
	public CalculadoraEstatisticas(int totalEleitores, int votos ) {
		this.votos = votos;
		this.totalEleitores = totalEleitores;
	}
	
	double calcularPercentual() {
		return (double) votos / totalEleitores;
	};
	
	abstract public String print();
	
}
