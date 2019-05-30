package practica2;

import java.util.Scanner;

public class Exercici6 {
	public static void main(String[] args) {
		System.out.println("Introdueix un numero 'n' i et mostraré els numeros anteriors:");
		int n = validacio(true);
		System.out.print("Resultat: ");
		comptaNums(n, 1);
	}

	public static void comptaNums(int n, int pos) {
		if (pos == n) {
			System.out.println(n);
		} else {
			System.out.print(pos + ", ");
			comptaNums(n, pos + 1);
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
