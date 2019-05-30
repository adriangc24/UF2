import java.util.Scanner;

public class FactorialRecursiva {
	public static void main(String[] args) {
		inici();
	}

	public static void inici() {
		System.out.println("Introdueix un número enter positiu i et diré el factorial:");
		double num = validacio();
		int contador = 1;
		double res = num;
		double result = factorial(num, contador, res);
		System.out.println(result);
	}

	public static double validacio() {
		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		double num = 0;
		while (!valid) {
			if (!sc.hasNextInt()) {
				System.out.println("Has d'introduïr un enter!");
				sc.next();
			} else {
				num = sc.nextInt();
				if (num == 1 || num == 0) {
					System.out.println("El factorial de " + num + " és 1.");
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

	public static double factorial(double num, int contador, double res) {
		res = res * contador;
		contador++;
		if (contador < num) {
			res = factorial(num, contador, res);

		}
		return res;

	}
}
