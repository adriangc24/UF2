import java.util.Scanner;

public class diagonales {
	public static int matrizDiag(int[][] matriz, int i, int j) {
		if (i == 0) {
			matriz[i][matriz[i].length - 1] = 1;
			return matriz[i][j];
		} else if (j == matriz[i].length - i - 1) {
			matriz[i][j] = 1;
			matrizDiag(matriz, i - 1, matriz[i].length - 1);
			return matriz[i][j];
		} else if (j >= 0) {
			matriz[i][j] = matrizDiag(matriz, i - 1, j) + 1;
			matrizDiag(matriz, i, j - 1);
			return matriz[i][j];
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("Introduce tamaño matriz:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[][] matriz = new int[n][n];
		matrizDiag(matriz, n - 1, n - 1);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%02d %3s", matriz[i][j], " ");
			}
			System.out.println();
		}
	}
}
