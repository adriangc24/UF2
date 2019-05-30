import java.util.Scanner;

public class Fibonacci2 {
	public static int calculFibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if(n == 1){
			return 1;
		}else {
			return calculFibonacci(n - 1) + calculFibonacci(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero n");
		int n = sc.nextInt();
		System.out.println(calculFibonacci(n));
	}
}
