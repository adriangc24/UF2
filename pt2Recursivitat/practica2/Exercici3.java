package practica2;

import java.util.Scanner;

public class Exercici3 {
	public static void main(String[] args) {
		System.out.println("Introdueix un numero N i li canviarem l'ordre de les xifres.");
		int n = validacio(true);
		System.out.println("Resultat: " + canviaOrdre(n));
	}

	public static String canviaOrdre(int n) {
		if( n / 10 == 0) {
			return String.valueOf(n);
		}else {
		return String.valueOf(n % 10) + canviaOrdre(n / 10);
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
