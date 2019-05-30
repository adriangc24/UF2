//Modifiqueu el valor d'un paràmetre. Afecta a la variable original?
public class ModificaParametreCompost {
	public static void main(String[] args) {
		ModificaParametreCompost programa = new ModificaParametreCompost();
		programa.inici();
	}

	public void inici() {
		int[] i = { 1, 2, 3, 4, 5 };
		System.out.println("Abans de cridar el mètode \"i[3]\" val " + i[3]);
		modificarParametre(i);
		System.out.println("Després de cridar el mètode \"i[3]\" val " + i[3]);
	}

// Té un únic paràmetre d'entrada, de tipus enter
	public void modificarParametre(int[] a) {
		// Ara hi ha una variable "a" declarada.
		// El seu valor depèn de com s'ha invocat el mètode.
		a[3] = 0;
		System.out.println("Hem modificat el valor a " + a[3]);
	}
}