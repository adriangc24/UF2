import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		inici();
	}

	public static void inici() {
		System.out.println("Introdueix un número enter positiu i et diré el factorial:");
		double num = validacio();
		factorial(num);
	}

	public static double validacio() {
		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		double num = 0;
		while (!valid) {
			if (!sc.hasNextInt()) {
				System.out.println("Has d'introduïr un enter!");
			} else {
				num = sc.nextInt();
				if (num == 1) {
					System.out.println("El factorial de 1 és 1.");
					valid = true;
				} else if (num < 1) {
					System.out.println("Ha de ser un nombre positiu.");
				} else {
					valid = true;
				}
			}
		}
		sc.close();
		return num;
	}

	public static void factorial(double num) {
		if (num != 1) {
			double res = num;
			for (int i = 1; i < num; i++) {
				res = res * i;
			}
			System.out.println("El factorial de " + num + " és " + res + ".");
		}
	}
}
