package exercicio2;

public class BubleSort {

	public int[] ordenar(int... numeros) {
		int i, j, temp;
		boolean trocou;
		
		for (i = 0; i < numeros.length - 1; i++) {
			trocou = false;
			for (j = 0; j < numeros.length - i - 1; j++) {
				if (numeros[j] > numeros[j + 1]) {
					temp = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = temp;
					trocou = true;
				}
			}

			if (trocou == false)
				break;
		}
		
		return numeros;
	}
}
