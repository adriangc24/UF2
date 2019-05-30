package practica1;

import java.util.Scanner;

public class Exercici5 {
	public static void main(String[] args) {
		System.out.println("Introdueix número 1:");
		int numA = validacio(false);
		System.out.println("Introdueix número 2:");
		int numB = validacio(true);
		int result = multiplicacioRusa(numA, numB);
		System.out.println("El resultat amb la multiplicació rusa és: " + result);
	}

	public static int multiplicacioRusa(int numA, int numB) {
		int result;
		if (numA == 0 || numB == 0) {
			return 0;
		} else {
			if (numA == 1) {
				return numB;
			}
			if (numA % 2 != 0) {
				result = numB + multiplicacioRusa(numA / 2, numB * 2);
				return result;
			} else {
				result = multiplicacioRusa(numA / 2, numB * 2);
				return result;
			}
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
					System.out.println("El número ha de ser positiu! Torna a provar:");
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
