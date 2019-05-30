package practica1;

import java.util.Scanner;

public class FraseAmbMesA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean fi = false;
		String fraseMesA = "";
		String frase;
		int contadorMesA = 0;
		int contador;
		while (!fi) {
			System.out.println("Introdueix una frase:");
			frase = sc.nextLine();
			if (frase.equalsIgnoreCase("fi")) {
				fi = true;
			} else {
				contador = contaA(frase, fraseMesA);
				contadorMesA = resolucio(contador, contadorMesA, frase, fraseMesA);
			}
		}
		sc.close();
	}

	public static int contaA(String frase, String fraseMesA) {
		int contador = 0;
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == 'a' || frase.charAt(i) == 'A') {
				contador++;
			}
		}
		return contador;
	}

	public static int resolucio(int contador, int contadorMesA, String frase, String fraseMesA) {
		if (contador > contadorMesA) {
			contadorMesA = contador;
			fraseMesA = frase;
			System.out.println("Aquesta frase t� m�s 'a' amb " + contadorMesA);
		} else if (contador < contadorMesA) {
			System.out.println("L'�ltima frase t� " + contador + " 'a'.");
			System.out.println("Encara que no �s la que t� m�s 'a', que t� " + contadorMesA + " 'a'.");
		} else {
			System.out.println("Tenen les mateixes 'a', amb " + contadorMesA);
		}
		return contadorMesA;
	}

}
