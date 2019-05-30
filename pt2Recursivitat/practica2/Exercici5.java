package practica2;

import java.util.Scanner;

public class Exercici5 {
	public static void main(String[] args) {
		System.out.println("Cercarem el Maxim comu divisor de dos numeros:\n" + "Introdueix número 1:");
		int a = validacio(false);
		System.out.println("Introdueix numero 2:");
		int b = validacio(true);
		if (a > b) {
			System.out.println("Resultat: " + mcd(a, b));
		} else {
			System.out.println("Resultat: " + mcd(b, a));
		}

	}

	public static int mcd(int a, int b) {
		int r1;
		r1 = a % b;
		if (r1 == 0) {
			return b;
		} else {
			return mcd(b, r1);
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
				valid = true;
			}
		}
		if (tancar) {
			sc.close();
		}
		return num;

	}
}
