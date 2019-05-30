import java.util.Arrays;

public class SumaArrayRecursivitatMod3i4 {
	public static void main(String[] args) {
		int[] array = new int[10];
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)((Math.random() * 30) +1);
		}
		System.out.println("Sumarem les posicions múltiples de 3 i 4 del array:\n"
				+ Arrays.toString(array));
		System.out.println(sumaArray(array, 0));
	}
	
	public static int sumaArray(int[] array, int pos) {
		int result = 0;
		if(pos == array.length) {
			return 0;
		}else {
			if(array[pos] % 4 == 0 || array[pos] % 3 == 0) {
				result = array[pos] + sumaArray(array, pos + 1);
				return result;
			}else {
				return sumaArray(array, pos + 1);
			}
		}
	}
}
