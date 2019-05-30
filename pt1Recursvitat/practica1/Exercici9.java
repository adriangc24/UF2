package practica1;

import java.util.Scanner;

public class Exercici9 {
	public static void main(String[] args) {
		System.out.println("Calcularem 'n' sobre 'k' (números combinatoris).\n" + "Introdueix 'n':");
		int n = validacio(false);
		System.out.println("Introdueix 'k'");
		int k = validacio(true);
		System.out.print("TENIM:\n| " + n + " |\n" + "| " + k + " |");
		int result = numeroComb(n, k);
		System.out.println("Resultat: " + result);
	}
	
	public static int numeroComb(int n, int k) {
		if(k > n) {
			return 0;
		}else if(k == 0 || k == n) {
			return 1;
		}else {
			int result = numeroComb(n - 1, k - 1) + numeroComb(n - 1, k);
			return result;
		}
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
				if (num < 0) {
					System.out.println("El número ha de ser 0 o positiu! Torna a provar:");
				} else {
					valid = true;
				}

			}
		}
		if (tancar) {
			sc.close();
		}
		return num;

	}

}
