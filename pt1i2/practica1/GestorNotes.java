package practica1;

import java.util.Scanner;

public class GestorNotes {
	public static final int MAXIMNOTES = 5;

	public static void main(String[] args) {
		int contador = 0;
		float[] notes = new float[MAXIMNOTES];
		GestorNotes notesObj = new GestorNotes();
		boolean fi = false;
		notesObj.inici(fi, contador, notes);
	}

	public void inici(boolean fi, int contador, float[] notes) {
		Scanner sc = new Scanner(System.in);
		while (!fi && contador <= 40) {
			
			String opcio;
			System.out.println("Benvingut al gestor de notes");
			System.out.println("----------------------------");
			System.out.println("[RT] Registrar notes.");
			System.out.println("[MJ] Consultar nota mitjana.");
			System.out.println("[HT] Histograma de notes.");
			System.out.println("[FI] Sortir.");
			System.out.print("Opci�: ");
			opcio = sc.nextLine();
			opcio = opcio.toUpperCase();
			switch (opcio) {
			case "RT":
				contador = registrar(notes, contador);
				break;
			case "MJ":
				mitjana(contador, notes);
				break;
			case "HT":
				histograma(contador, notes);
				break;
			case "FI":
				fi = true;
				sc.close();
				break;
			default:
				System.out.println("La opci� escollida no �s a la llista.");
				break;
			}
		}
		sc.close();
	}

	public int registrar(float[] notes, int contador) {
		Scanner sc = new Scanner(System.in);
		boolean sortir = false;
		while (!sortir && contador < MAXIMNOTES) {
			System.out.println("Introdueix les notes:");
			if (!sc.hasNextFloat()) {
				System.out.println("S'ha d'introdu�r un n�mero!");
			} else {
				
				notes[contador] = sc.nextFloat();
				
				if (notes[contador] == -1) {
					sortir = true;
					System.out.println("Sortim.");
					contador--;
				} else if (notes[contador] < 0 || notes[contador] > 10) {
					System.out.println("Les notes nom�s poden ser de 0 a 10!");
					contador--;
				}
				contador++;
			}

		}
		return contador;
	}

	public void mitjana(int contador, float[] notes) {
		float mitjana = 0;
		for (int i = 0; i < contador; i++) {
			mitjana = mitjana + notes[i];
		}
		mitjana = mitjana / contador;
		System.out.println("La mitjana fins ara �s " + mitjana);
	}

	public void histograma(int contador, float[] notes) {
		String[] classificacions = new String[4];
		for (int j = 0; j < classificacions.length; j++) {
			classificacions[j] = "";
		}
		for (int i = 0; i < contador; i++) {
			if (notes[i] < 5) {
				classificacions[0] = classificacions[0] + "*";
			} else if (notes[i] < 6.5) {
				classificacions[1] = classificacions[1] + "*";
			} else if (notes[i] <= 8.5) {
				classificacions[2] = classificacions[2] + "*";
			} else if (notes[i] <= 10) {
				classificacions[3] = classificacions[3] + "*";
			}
		}
		System.out.println("Susp�s: " + classificacions[0]);
		System.out.println("Aprovat: " + classificacions[1]);
		System.out.println("Notable: " + classificacions[2]);
		System.out.println("Excel�lent: " + classificacions[3]);
	}
}
