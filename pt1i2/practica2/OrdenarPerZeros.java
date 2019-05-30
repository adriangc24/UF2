package practica2;

import java.util.Arrays;

public class OrdenarPerZeros {
	public static void main(String[] args) {
		int[] array = { 100, 2014, 12, 30, 302, 40020, 7009, 500000, 0 };
		inici(array);
	}

	public static void inici(int[] array) {
		System.out.println("L'array desordenada és: ");
		System.out.println(Arrays.toString(array));
		int[] contador = comptaZeros(array);
		int[] arrayOrdenada = ordenacio(contador, array);
		System.out.println("\nL'array ordenada és: ");
		System.out.println(Arrays.toString(arrayOrdenada));
	}

	public static int[] comptaZeros(int[] array) {
		int[] contador = new int[array.length];
		int aux;
		for (int i = 0; i < array.length; i++) {
			aux = array[i];
			if (aux == 0) {
				contador[i]++;
			} else {
				while (aux > 10) {
					if (aux % 10 == 0) {
						contador[i]++;
					}
					aux = aux / 10;
				}
			}
		}
		return contador;
	}

	public static int[] ordenacio(int[] contador, int[] array) {
		int aux;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (contador[j] < contador[j + 1]) {
					aux = contador[j];
					contador[j] = contador[j + 1];
					contador[j + 1] = aux;
					aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
			}
		}
		return array;
	}
}
