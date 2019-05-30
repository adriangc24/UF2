package practica2;

import java.util.Scanner;

public class Exercici4 {
	public static void main(String[] args) {
		System.out.println("Introdueix un numero 'n' i et sumaré els parells més petits fins a 2:");
		int n = validacio(true);
		if (n % 2 != 0)
			n--;
		System.out.println("Resultat: " + sumaParells(n));
	}

	public static int sumaParells(int n) {
		if (n == 2) {
			return n;
		} else {
			return n + sumaParells(n - 2);
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
