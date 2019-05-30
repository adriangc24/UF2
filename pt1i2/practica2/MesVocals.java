package practica2;

import java.util.Scanner;

public class MesVocals {
	public static void main(String[] args) {
		MesVocals programa = new MesVocals();
		programa.inici();
	}

	public void inici() {
		Scanner sc = new Scanner(System.in);
		String frase;
		System.out.println("Introdueix una frase i et diré la paraula amb més vocals:");
		frase = sc.nextLine();
		sc.close();
		frase = frase.toLowerCase();
		String[] paraules = frase.split(" ");
		int[] contador = comptaVocals(paraules);
		int posMesVocals = mostraMesA(contador);
		System.out.println("La paraula amb més vocals és \"" + paraules[posMesVocals]+"\"");
	}

	public int[] comptaVocals(String[] paraules) {
		int[] contador = new int[paraules.length];
		for (int i = 0; i < paraules.length; i++) {
			for (int j = 0; j < paraules[i].length(); j++) {
				if (paraules[i].charAt(j) == 'a' || paraules[i].charAt(j) == 'e' || paraules[i].charAt(j) == 'i'
						|| paraules[i].charAt(j) == 'o' || paraules[i].charAt(j) == 'u') {
					contador[i]++;
				}
			}
		}
		return contador;
	}

	public int mostraMesA(int[] contador) {
		int posMesVocals = 0;
		for (int i = 0; i < contador.length; i++) {
			if (i == 0) {
				posMesVocals = i;
			}
			if (contador[posMesVocals] < contador[i]) {
				posMesVocals = i;
			}
		}
		return posMesVocals;
	}

}
