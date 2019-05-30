package practica2;
import java.util.Scanner;
public class MitjanaTresMaxims {
	public static final int TAM = 10;
	public static final int NOMBRESMITJA = 3;
	public static void main(String[] args) {
		int[] array = new int[TAM];
		MitjanaTresMaxims programa = new MitjanaTresMaxims();
		programa.inici(array);
		
	}
	public void inici(int[] array) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < TAM; i++) {
			System.out.println("Introdueix el valor "+i+"/"+TAM+"de l'array:");
			if(!sc.hasNextInt()) {
				System.out.println("No has introduït un enter!");
				sc.next();
				i--;
			}else {
				array[i] = sc.nextInt();
			}
			
		}
		sc.close();
		ordenacio(array);
		System.out.println("La mitjana dels tres valors més grans és " + ferMitjana(array));
		
	}
	public void ordenacio(int[] array) {
		int aux;
		for(int i = 0; i < TAM; i++) {
			for(int j = 0; j < TAM - i - 1; j++) {
				if(array[j] > array[j+1]) {
					aux = array[j];
					array[j] = array[j+1];
					array[j+1] = aux;
				}
			}
		}
	}
	
	public int ferMitjana(int[] array) {
		int resultat = 0;
		for(int i = 0; i < NOMBRESMITJA; i++) {
			resultat = resultat + array[TAM - i - 1];
		}
		resultat = resultat / NOMBRESMITJA;
		return resultat;
	}

}
