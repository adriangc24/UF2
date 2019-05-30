package practica2;

import java.util.Scanner;

public class NumeroPrimer {
	public static void main(String[] args) {
		NumeroPrimer primer = new NumeroPrimer();
		boolean sortir = false;
		int num = 0;
		Scanner sc = new Scanner(System.in);
		while (!sortir) {
			System.out.println("Introdueix un n�mero(m�s gran que 1) i et dir� si �s primer; -1 per sortir:");
			if (!sc.hasNextInt()) {
				System.out.println("No �s un n�mero!");
				sc.next();
			} else {
				num = sc.nextInt();
				if (num == -1) {
					sortir = true;
					System.out.println("Fins aviat!");
				} else if (num <= 1) {
					System.out.println("El n�mero ha de ser m�s gran que 1!");
				} else {
					System.out.print("El n�mero " + num + " �s primer? ");
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
