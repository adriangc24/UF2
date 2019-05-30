package practica2;

import java.util.Scanner;

public class NumeroPrimer {
	public static void main(String[] args) {
		NumeroPrimer primer = new NumeroPrimer();
		boolean sortir = false;
		int num = 0;
		Scanner sc = new Scanner(System.in);
		while (!sortir) {
			System.out.println("Introdueix un número(més gran que 1) i et diré si és primer; -1 per sortir:");
			if (!sc.hasNextInt()) {
				System.out.println("No és un número!");
				sc.next();
			} else {
				num = sc.nextInt();
				if (num == -1) {
					sortir = true;
					System.out.println("Fins aviat!");
				} else if (num <= 1) {
					System.out.println("El número ha de ser més gran que 1!");
				} else {
					System.out.print("El número " + num + " és primer? ");
					System.out.println(primer.esPrimer(num));
				}

			}
		}
		sc.close();
	}

	public boolean esPrimer(int num) {
		boolean esPrimer = false;
		int contador =0;
		for(int i = 1; i < num / 2; i++) {
			if(num % i == 0) {
				contador++;
			}
		}
		if(contador <= 2) {
			esPrimer = true;
		}
		return esPrimer;
	}
}
