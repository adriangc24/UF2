
public class DobleForIterativo {
	public static void dobleForIterativo(int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println("i = " + i + " / j = " + j);
			}
		}
	}

	public static void dobleForRecursivo(int n, int m, int i, int j) {
		if (i < n) {
			if (j < m) {
				System.out.println("i = " + i + " / j = " + j);
				dobleForRecursivo(n, m, i, j + 1);
			}
			if (j == m) {
				dobleForRecursivo(n, m, i + 1, 0);
			}
		}
	}

	public static void main(String[] args) {
		int n = (int) ((Math.random() * 10) + 1), m = (int) ((Math.random() * 10) + 1);
		System.out.println("Per a n(i) = " + n + " / Per a m(j) = " + m);
		dobleForIterativo(n, m);
		System.out.println("\n------------------------------------------------\n");
		dobleForRecursivo(n, m, 0, 0);
	}

}
