package practica2;

public class DiaSetmana {
	public static void main(String[] args) {
		DiaSetmana programa = new DiaSetmana();
		programa.inici();
	}

	public void inici() {
		String nom = diaDeLaSetmana(3);
		System.out.println("El tercer dia de la setmana és " + nom);
		nom = diaDeLaSetmana(5);
		System.out.println("El cinquè dia de la setmana és " + nom);
		nom = diaDeLaSetmana(15);
		System.out.println("El quinzè dia de la setmana és " + nom);
	}
	public String diaDeLaSetmana(int numDia) {
		String nom;
		switch (numDia) {
		case 1:
			nom = "dilluns";
			break;
		case 2:
			nom = "dimarts";
			break;
		case 3:
			nom = "dimecres";
			break;
		case 4:
			nom = "dijous";
			break;
		case 5:
			nom = "divendres";
			break;
		case 6:
			nom = "dissabte";
			break;
		case 7:
			nom = "diumenge";
			break;
		default:
			nom = "(No existeix aquest dia)";
			break;
		}
		return nom;

	}
}