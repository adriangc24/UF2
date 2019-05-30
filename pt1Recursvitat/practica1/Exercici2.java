package practica1;

import java.util.Scanner;

public class Exercici2 {
	public static void main(String[] args) {
		int num;
		System.out.println("Introdueix un número i sumarem les seves xifres:");
		num = validacio(true);
		System.out.println("Resultat: " + sumaXifres(num));
	}

	public static int sumaXifres(int num) {
		int numSuma = num % 10;
		int result = 0;
		if (num / 10 == 0) {
			return num;
		} else {
			result = numSuma + sumaXifres(num / 10);
			return result;
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
