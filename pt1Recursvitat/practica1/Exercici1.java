package practica1;

import java.util.Scanner;

public class Exercici1 {

	public static void main(String[] args) {
		int res = 0;
		System.out.println("Introdueix dividend:");
		int dividend = validacio(false);
		System.out.println("Introdueix divisor:");
		int divisor = validacio(true);
		res = divisio(dividend, divisor);
		System.out.println(res);
	}

	public static int divisio(int dividend, int divisor) {
		int res = 0;
		if (dividend >= divisor) {
			res = 1 + divisio(dividend - divisor, divisor);
			return res;
		} else {
			return 0;
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
				if (tancar == true && num == 0) {
					System.out.println("El divisor no pot ser 0. Torna a provar:");
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
