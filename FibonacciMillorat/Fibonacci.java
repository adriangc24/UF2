import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("Introdueix un numero 'x' per a la serie Fibonacci:");
		int x = validacio(true);
		int[] array = new int[x + 1];
		Fibonacci obj = new Fibonacci();
		System.out.println("Posició " + x + " de Fibonacci: " + obj.fibonacci(array, x));
	}

	public int fibonacci(int[] array, int x) {
		if (x < 2) {
			array[x] = x;
			return x;
		} else {
			array[x] = fibonacci(array, x - 1) + array[x - 2];
			return array[x];
		}
	}

	public static int validacio(boolean tancar) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean valid = false;
		while (!valid) {
			if (!sc.hasNextInt()) {
				System.out.println("No es un numero! Torna a provar:");
				sc.next();
			} else {
				num = sc.nextInt();
				if (num < 0) {
					System.out.println("La posicio ha de ser 0 o positiva! Torna a provar:");
				} else {
					valid = true;
				}

			}
		}
		if (tancar) {
			sc.close();
		}
		return num;

	}

}