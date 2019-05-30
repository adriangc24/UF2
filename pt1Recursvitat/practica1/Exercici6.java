package practica1;

import java.util.Scanner;

public class Exercici6 {
	public static void main(String[] args) {
		System.out.println("Introdueix base:");
		int base = validacio(false);
		System.out.println("Introdueix exponent:");
		int exponent = validacio(true);
		int result = potencia(base, exponent);
		System.out.println("El resultat és: " + result);

	}

	public static int potencia(int a, int b) {
		int result = 0;
		if (b == 0) {
			return 1;
		} else {
			result = a * potencia(a, b - 1);
		}
		return result;
	}

	public static int validacio(boolean tancar) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean valid = false;
		while (!valid) {
			if (!sc.hasNextInt()) {
				System.out.println("No és un número! Torna a provar:");
				sc.next();
			} else {
				num = sc.nextInt();
				valid = true;
			}
		}
		if (tancar) {
			sc.close();
		}
		return num;

	}
}
