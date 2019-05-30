public class ModificarParametre {
	public static void main(String[] args) {
		ModificarParametre programa = new ModificarParametre();
		programa.inici();
	}
	/* No cambia los valores porque iguala la "a" a la "i"
	 * no dice que "i" sea "a" ahora
	 */
	public void inici() {
		int i = 10;
		System.out.println("Abans de cridar el mètode \"i\" val " + i);
		modificarParametre(i);
		System.out.println("Després de cridar el mètode \"i\" val " + i);
	}

// Té un únic paràmetre d'entrada, de tipus enter
	public void modificarParametre(int a) {
		a = 0;
		System.out.println("Heu modificat el valor a " + a);
	}
}