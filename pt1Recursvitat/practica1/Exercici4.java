package practica1;

public class Exercici4 {
	public static void main(String[] args) {
		/*
		 * Algorisme sense demanar 'n' a l'usuari
		 * L'algorisme que es demana 'n' a l'usuari és l'Exercici4b.java
		 */
		System.out.println("Resultat mètode Wallis: " + wallis(2, 1));
	}

	public static float wallis(float num, float div) {
		float pi = 2;
		if (num <= 2000) {
			if (num > div) {
				pi = num / div * wallis(num, div + 2);
			} else {
				pi = num / div * wallis(num + 2, div);
			}
		}

		return pi;
	}
}
