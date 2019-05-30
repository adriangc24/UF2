import java.util.Scanner;

public class TrianguloPascal {
	public static int calculPascal(int n, int[][] matriz, int pos) {
		if (n == 0 || pos == 0 || pos == n) {
			matriz[n][pos] = 1;
			return 1;
		}else
		if (pos < n) {
			matriz[n][pos] = calculPascal(n - 1, matriz, pos) + calculPascal(n - 1, matriz, pos - 1);
			calculPascal(n, matriz, pos - 1);
			return matriz[n][pos];
		}
		return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix el número 'n' triangle Pascal:");
		int n = sc.nextInt();
		int[][] matriz = new int[n + 1][n + 1];
		calculPascal(n, matriz, n - 1);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				//if (matriz[i][j] != 0) {
					System.out.printf("%03d %2s", matriz[i][j], " ");
				//}
			}
			System.out.println();
		}
	}
}
