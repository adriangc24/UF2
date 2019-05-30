package practica1;

import java.util.Arrays;

public class Exercici3 {
	public static void main(String[] args) {
		int[] vector = new int[10];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = (int) (Math.random() * 15);
		}
		System.out.println("Sumarem totes les posicions del vector: " + Arrays.toString(vector));
		System.out.println("Resultat: " + sumaElements(vector, vector.length - 1));
	}

	public static int sumaElements(int[] vector, int pos) {
		int sumatori = 0;
		if (pos >= 0) {
			sumatori = vector[pos] + sumaElements(vector, pos - 1);
		}
		return sumatori;
	}
}
