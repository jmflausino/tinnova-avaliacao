package exercicio3;

public class TesteFatorial {
	
	public static void main(String[] args) {
			
		CalculadoraFatorial fatorial4 = new CalculadoraFatorial(4);
		CalculadoraFatorial fatorial5 = new CalculadoraFatorial(5);
		
		System.out.println(fatorial4.getNumero() + " fatorial é igual a: " + fatorial4.fatorial());
		System.out.println(fatorial5.getNumero() + " fatorial é igual a: " + fatorial5.fatorial());
	}
}
