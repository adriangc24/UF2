package practica2;

import java.util.Scanner;

public class Exercici7 {
	public static void main(String[] args) {
		System.out.println("Introdueix un número i calcularem la formula:\n"
				+ "f(x) = x*2 + (x − 1)*2 + (x − 2)*2 + . . . + 2*2 + 1*2");
		int x = validacio(true);
		System.out.println(formula(x));

	}

	public static int formula(int x) {
		if(x == 1) {
			return 2;
		}
		return x * 2 + formula(x - 1);
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
