package practica1;

public class GenerarHistograma {
	public static final int TIRADES = (int) ((Math.random()*100) + 50);
	public static void main(String[] args) {
		int[] numeros = new int[11];
		for(int j = 2; j < numeros.length + 2; j++) {
			numeros[j-2] = j;
		}
		
		int maximNum = GeneraHistograma(numeros);
		System.out.printf("\nEl máxim és: %02d", maximNum);
	}
	public static int GeneraHistograma(int[] numeros) {
		int dau1, dau2, resultat, maximPos = 0, maximNum = 0;
		int[] posibilitats = new int[11];

		for(int i = 0; i < TIRADES; i++) {
			dau1 = (int) ((Math.random() * 6) + 1);
			dau2 = (int) ((Math.random() * 6) + 1);
			resultat = dau1 + dau2;
			posibilitats[resultat - 2]++;
		}
		for(int k = 0; k < numeros.length; k++) {
			System.out.printf("%02d: ", numeros[k]);
			if(maximPos < posibilitats[k]) {
				maximPos = posibilitats[k];
				maximNum = k+2;
			}
			for(int l = 0; l < posibilitats[k]; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		return maximNum;	
	}
}
