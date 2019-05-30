import java.util.Arrays;
import java.util.Scanner;

public class cercaLinealRecursiva {
	public static final int TAM = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[TAM];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		System.out.println("Introdueix el número a buscar:");
		int num = sc.nextInt();
		sc.close();
		System.out.println("Trobat a la posició:" + cercaNum(array, num, array.length - 1));
		System.out.println(Arrays.toString(array));
	}

	public static int cercaNum(int[] array, int num, int pos) {
		if (pos < 0) {
			return -1;
		} else {
			if (array[pos] == num) {
				return pos;
			} else {
				
				return cercaNum(array, num, pos - 1);
			}
		}
	}

}
