package exercicio2;

import java.util.Arrays;

public class TesteBubleSort {

	public static void main(String args[]) {
		BubleSort sort = new BubleSort();
		int[] valoresOrdenados = sort.ordenar(83, 12, 25, 9, 88, 102, 53);
		
		System.out.println(Arrays.toString(valoresOrdenados));
	}
}
