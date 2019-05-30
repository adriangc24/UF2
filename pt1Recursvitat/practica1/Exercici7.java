package practica1;

import java.util.Scanner;

public class Exercici7 {
	public static void main(String[] args) {
		System.out.println("Introdueix el número multplicat:");
		int num1 = validacio(false);
		System.out.println("Introdueix el número que multiplica:");
		int num2 = validacio(true);
		int result = sumaMultiplicacio(num1, num2);
		System.out.println("El resultat és: " + result);
	}
	
	public static int sumaMultiplicacio(int a, int b) {
		int result = 0;
		if(a == 0 || b == 0) {
			return 0;
		}else {
			result = a + sumaMultiplicacio(a, b - 1);
		}
		return result;
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
				valid = true;
			}
		}
		if (tancar) {
			sc.close();
		}
		return num;

	}
}
