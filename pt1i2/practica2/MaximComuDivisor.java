package practica2;

import java.util.Scanner;

//Un programa que calcula l'MCD de dos números
public class MaximComuDivisor {
	public static void main(String[] args) {
		MaximComuDivisor programa = new MaximComuDivisor();
		programa.inici();
	}

	public void inici() {
		System.out.print("Escriu el valor a: ");
		int a = llegirEnterTeclat();
		System.out.print("Escriu el valor b: ");
		int b = llegirEnterTeclat();
		// Recordar que un mètode s'avalua com una expressió
		System.out.println("L'MCD de " + a + " i " + b + " és " + mcd(a, b));
	}

	public int llegirEnterTeclat() {
		Scanner lector = new Scanner(System.in);
		int enterLlegit = 0;
		boolean llegit = false;
		while (!llegit) {
			llegit = lector.hasNextInt();
			if (llegit) {
				enterLlegit = lector.nextInt();
			} else {
				System.out.println("Això no és un enter.");
				lector.next();
			}
		}
		lector.nextLine();
		return enterLlegit;
	}

	public int mcd(int a, int b) {
		int aux;
		int operador = 0;
		if (a < b) {
			aux = a;
			a = b;
			b = aux;
		}
		
		while (b != 0) {
			operador = a % b;
			a = b;
			b = operador;
		}
		return a;
	}
}