package practica1;

import java.util.Scanner;

public class Exercici8 {

	public static void main(String[] args) {
		System.out.println("Introdueix un número 'x' per a la serie Fibonacci:");
		int x = validacio(true);
		Exercici8 obj = new Exercici8();
		int result = obj.fibonacci(x);
		System.out.println("Resultat: " + result);
	}
	
	public int fibonacci(int x) {
		int result;
		if(x < 2) {
		return x;
		}else {
			result = fibonacci(x-1) + fibonacci(x-2);
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
					System.out.println("La posició ha de ser 0 o positiva! Torna a provar:");
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
