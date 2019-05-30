package practica2;

import java.util.Scanner;

public class Exercici2 {
	public static void main(String[] args) {
		System.out.println("Introdueix un número i sumarem les seves xifres:");
		int num = validacio(true);
		System.out.println("Resultat: " + sumaXifres(num));
	}

	public static int sumaXifres(int n) {
		if (n / 10 == 0) {
			return n;
		} else {
			return n % 10 + sumaXifres(n / 10);
		}
	}

	public static int validacio(boolean tancar) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean valid = false;
		while (!valid) {
			if (!sc.hasNextInt()) {
				System.out.println("No es un numero! Torna a provar:");
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
