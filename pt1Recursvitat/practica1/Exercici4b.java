package practica1;

import java.util.Scanner;

public class Exercici4b {
	public static void main(String[] args) {
		/*
		 * Algoritme de Wallis demanant n vegades que farem Wallis.
		 */
		System.out.println("Introdueix 'n' vegades que farem Wallis:");
		int n = validacio(true);
		System.out.println(wallis(n));
	}

	public static float wallis(int n) {
		if (n == 0) {
			return 2f;
		} else {
			return ((2f * n) / (2f * n - 1f)) * ((2f * n) / (2f * n + 1f)) * wallis(n - 1);
		}
	}
	
	public static int validacio(boolean tancar) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean valid = false;
		while (!valid) {
			if (!sc.hasNextInt()) {
				System.out.println("No �s un n�mero! Torna a provar:");
				sc.next();
			} else {
				num = sc.nextInt();
				if (num <= 0) {
					System.out.println("La posici� ha de ser positiva! Torna a provar:");
				} else {
					valid = true;
				}

			}
		}
		if(tancar) {
			sc.close();
		}
		return num;

	}
}
