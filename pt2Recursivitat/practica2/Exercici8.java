package practica2;

import java.util.Arrays;

public class Exercici8 {
	public static final int TAM = 10;
	public static final int POSINICIAL = -1;
	public static final int RANDOM = 10;

	public static void main(String[] args) {
		int[] array = new int[TAM];
		for (int i = 0; i < TAM; i++) {
			array[i] = (int) ((Math.random() * RANDOM) + 1);
		}
		System.out.println(
				"Multiplicarem la suma de tots els multiples de 3 per la suma de tots els multiples de 2 de l'array:");
		System.out.println(Arrays.toString(array));
		System.out.println("Resultat: " + multiplicaSumes(array, POSINICIAL, 0));
	}

	public static int multiplicaSumes(int[] array, int pos, int modul) {
		if (pos == -1) {
			return multiplicaSumes(array, pos + 1, 2) * multiplicaSumes(array, pos + 1, 3);
		} else {
			if (pos == array.length) {
				return 0;
			} else {
				if (array[pos] % modul == 0) {
					return array[pos] + multiplicaSumes(array, pos + 1, modul);
				} else {
					return multiplicaSumes(array, pos + 1, modul);
				}
			}
		}
	}
}
