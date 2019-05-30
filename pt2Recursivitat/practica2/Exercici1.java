package practica2;

import java.util.Arrays;

public class Exercici1 {
	public static final int TAM = 5;
	public static void main(String[] args) {
		int[] array = new int[TAM];
		for (int i = 0; i < TAM; i++) {
			array[i] = (int) ((Math.random() * 10) + 1);
		}
		System.out.println("Multiplicarem els valors: "+Arrays.toString(array));
		Exercici1 obj = new Exercici1();
		int result = obj.multiplicacioArray(array, TAM - 1);
		System.out.println("Resultat: "+result);
		
	}

	public int multiplicacioArray(int[] array, int pos) {
		if(pos<0) {
			return 1;
		}else {
			return array[pos] * multiplicacioArray(array, pos -1);
		}
	}
}
