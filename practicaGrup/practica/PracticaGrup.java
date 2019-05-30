package practica;

import java.util.Scanner;

public class PracticaGrup {
	public static final int MAXIMCLIENTS = 100;
/**
 * Aquest metode es el menu principal del programa; on es crida a totes les altres funcions
 * @param clients : se li passa l'array creada al main y no creada al metode per tal que no s'inicialitzi amb nuls cada cop que tornem al menu  
 * @return Retorna un boleà per saber si sortim del programa (el bucle que controla aixo es al main)
 */
	public boolean inici(String[] clients) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Benvingut al gestor del negoci. Opcions:\n" + "-------------------------------------------------\n"
						+ "\tAL - Alta d'un client.\n" + "\tVI - Visualitzacio d'un client.\n"
						+ "\tBA - Baixa d'un client.\n" + "\tRE - Recuperacio de dades d'un client.\n"
						+ "\tOR - Ordena els clients.\n" + "\tMO - Mostra tots els clients.\n" + "\tS - Sortir.\n"
						+ "-------------------------------------------------\n" + "Escull una opciï¿½: ");
		System.out.println("(Has d'escriure les lletres del principi de cada opcio; en minuscules o majuscules):");
		String opc = sc.next();
		if (opc.equalsIgnoreCase("al")) {
			nouClient(clients);
		} else if (opc.equalsIgnoreCase("vi")) {
			visualitzacio(clients);
		} else if (opc.equalsIgnoreCase("ba")) {
			baixaClient(clients);
		} else if (opc.equalsIgnoreCase("re")) {
			recuperacioClient(clients);
		} else if (opc.equalsIgnoreCase("or")) {
			ordenacioClients(clients);
		} else if (opc.equalsIgnoreCase("mo")) {
			mostraTotsClients(clients);
		} else if (opc.equalsIgnoreCase("s")) {
			System.out.println("Fins aviat!");
			return true;
		} else {
			System.out.println("La opcio no es a la llista!");
		}
		return false;
	}
	
	/**
	 * Aquesta funcio omple l'array de clients amb nous. Demana les dades NIF, nom complet i telefon, i omple automaticament la dada "esborrat" i "codi client".
	 * @param clients Li passem l'array per tal que pugui omplir-la
	 */

	public static void nouClient(String[] clients) {
		Scanner sc = new Scanner(System.in);
		String opcio;
		String[] clientInt;
		int posClient = 0, posB = 0;
		boolean posNula = false, fi = false, valid = false;
		String nif = new String();
		while (!fi) {
			while (!posNula && posB != clients.length) {
				if (clients[posB] == null) {
					posClient = posB;
					posNula = true;
				}
				posB++;
			}
			if (posNula) {
				valid = false;
				clients[posClient] = "false ; " + posClient + " ; ";
				System.out.println("Afegirem un nou client a la base de dades");
				while (!valid) {
					System.out.println(
							"Introdueix el NIF del client (Format: 00000000A (8 numeros i una lletra al final)): ");
					nif = sc.nextLine();
					valid = validarNif(clients, nif, posClient);
				}
				valid = false;
				clients[posClient] = clients[posClient] + nif + " ; ";
				System.out.println("Introdueix el nom complet del client: ");
				clients[posClient] = clients[posClient] + sc.nextLine() + " ; ";
				while (!valid) {
					System.out.println("Introdueix el telefon del client(sense espais!): ");
					System.out.println("Si introdueixes un espai, nomes s'agafaran els numeros fins a l'espai.");
					if (sc.hasNextInt()) {
						clients[posClient] = clients[posClient] + sc.next();
						valid = true;
					} else {
						System.out.println("Has introduit un caracter no numeric!");
						sc.next();
					}
				}
				valid = false;
				System.out.println("\nLes dades del client introduit son:");
				clientInt = clients[posClient].split(" ; ");
				System.out.println("NIF: " + clientInt[2]);
				System.out.println("Nom complet: " + clientInt[3]);
				System.out.println("telefon: " + clientInt[4]);

				while (!valid) {
					System.out.println("\nVols introduir un altre client? [s/n]");
					opcio = sc.next();
					if (opcio.equalsIgnoreCase("n")) {
						System.out.println("Tornem al menu inicial.");
						fi = true;
						valid = true;
					} else if (opcio.equalsIgnoreCase("s")) {
						posClient = 0;
						posB = 0;
						posNula = false;
						sc.nextLine();
						valid = true;
					} else {
						System.out.println("Has d'escriure una 's' o una 'n' minuscula o majuscula!");
					}
				}
				valid = false;
			} else {
				System.out.println("No queda espai per a mes clients...");
			}
		}
	}
	
	/**
	 * Aquesta funcio comprova que el NIF tingui el format de 8 numeros i una lletra sense cap altre caracter, i despres comprova que el NIF introduit no existeixi ja en cap altre client
	 * @param clients Li passem l'array per tal que comprovi amb les altres posicions
	 * @param nifF Li passem el nif introduit per l'usuari a la creacio del client per validar-ho
	 * @param posClient Passem la posClient actual perquè no ens la comprovi, ja que pot comportar falles al programa si ho comprova amb si mateixa
	 * @return Retorna un bolea, true si es tot correcte, false en cas contrari i farà que es torni a demanar el NIF
	 */
	public static boolean validarNif(String[] clients, String nifF, int posClient) {
		int l = 0, k = 0;
		String[] clientNif;
		boolean numeroCorrecte, formatValid = false;
		String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] lletres = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		int j = 0;

		if (nifF.length() == 9) {
			String numero, lletra = Character.toString(nifF.charAt(nifF.length() - 1));
			for (int i = 0; i < nifF.length() - 1; i++) {
				numero = Character.toString(nifF.charAt(i));
				numeroCorrecte = false;
				while (j < numeros.length && !numeroCorrecte) {
					if (numero.equals(numeros[j])) {
						numeroCorrecte = true;
					}
					j++;
				}
				if (numeroCorrecte == false) {
					System.out.println("El format no es valid! Torna a provar: ");
					return false;
				}
				j = 0;
			}
			while (!formatValid && k < lletres.length) {
				if (lletra.equalsIgnoreCase(lletres[k])) {
					formatValid = true;
				}
				k++;
			}

			if (!formatValid) {
				System.out.println("L'ultima posicio ha de ser una lletra!");
				return false;
			}

			while (clients[l] != null && l < posClient) {
				clientNif = clients[l].split(" ; ");
				if (clientNif[2].equalsIgnoreCase(nifF)) {
					System.out.println("El nif ja existeix!");
					return false;
				}
				l++;
			}
			return true;
		}
		System.out.println("El nif no compleix la longitud!");
		return false;

	}
	
	/**
	 * Mostra les dades d'un client en concret. L'usuari pot escollir els criteris de cerca, com el codi, el NIF, el nom o el telefon.
	 * En el cas del nom, la cerca es fa per tros, no ha d'introduir el nom exactament com esta escrit
	 * @param clients 
	 */

	public static void visualitzacio(String[] clients) {
		Scanner sc = new Scanner(System.in);
		boolean fi = false, valid = false, trobat = false;
		int i, j;
		String opcio;
		String[] clientSol;
		while (!fi) {
			i = 0;
			valid = false;
			while (!valid) {
				System.out.println("Introdueix una opcio de cerca d'un client:\n" + "C - Codi client\n"
						+ "N - Nif client\n" + "NO - Nom client\n" + "T - Telefon client\n" + "S - Tornar al menu\n"
						+ "Introdueix una opcio:");
				opcio = sc.next();
				sc.nextLine();
				if (opcio.equalsIgnoreCase("C")) {
					valid = true;
					System.out.println("Introdueix el codi del client a cercar:");
					opcio = sc.next();
					while (clients[i] != null && i < clients.length && !trobat) {
						clientSol = clients[i].split(" ; ");
						if (clientSol[1].equals(opcio)) {
							System.out.println("S'ha trobat el client, dades:");
							System.out.print("Esta esborrat? ");
							if (clientSol[0].equals("false")) {
								System.out.println("No.");
							} else {
								System.out.println("Si.");
							}
							System.out.println("Codi client: " + clientSol[1]);
							System.out.println("NIF: " + clientSol[2]);
							System.out.println("Nom Complet: " + clientSol[3]);
							System.out.println("Telefon: " + clientSol[4]);
							trobat = true;
						}
						i++;
					}
					if (trobat == false) {
						System.out.println("No s'ha trobat res...");
					}
				} else if (opcio.equalsIgnoreCase("NO")) {
					valid = true;
					System.out.println("Introdueix el Nom a cercar:");
					System.out.println("Pots buscar per el nom, cognom, o part del nom o del cognom:");
					System.out.println(
							"Per exemple, per Juan Garcia, pots buscar per 'Juan', 'Garcia', 'Ju' o 'Gar' si vols.");
					opcio = sc.nextLine();
					while (clients[i] != null && i < clients.length) {
						trobat = false;
						j = 0;
						clientSol = clients[i].split(" ; ");
						while (!trobat && j < clientSol[3].length()) {
							if (clientSol[3].regionMatches(true, j, opcio, 0, opcio.length())) {
								System.out.println(
										"----------------------\n" + "El nom coincideix amb aquest client, dades:");
								System.out.print("Esta esborrat? ");
								if (clientSol[0].equals("false")) {
									System.out.println("No.");
								} else {
									System.out.println("Si.");
								}
								System.out.println("Codi client: " + clientSol[1]);
								System.out.println("NIF: " + clientSol[2]);
								System.out.println("Nom Complet: " + clientSol[3]);
								System.out.println("Telefon: " + clientSol[4]);
								trobat = true;
							}
							j++;
						}
						i++;
					}
					if (trobat == false) {
						System.out.println("No s'ha trobat res...");
					}
				} else if (opcio.equalsIgnoreCase("N")) {
					valid = true;
					System.out.println("Introdueix el NIF a cercar:");
					opcio = sc.next();
					while (clients[i] != null && i < clients.length && !trobat) {
						clientSol = clients[i].split(" ; ");
						if (clientSol[2].equals(opcio)) {
							System.out.println("S'ha trobat el client, dades:");
							System.out.print("Esta esborrat? ");
							if (clientSol[0].equals("false")) {
								System.out.println("No.");
							} else {
								System.out.println("Si.");
							}
							System.out.println("Codi client: " + clientSol[1]);
							System.out.println("NIF: " + clientSol[2]);
							System.out.println("Nom Complet: " + clientSol[3]);
							System.out.println("Telefon: " + clientSol[4]);
							trobat = true;
						}
						i++;
					}
					if (trobat == false) {
						System.out.println("No s'ha trobat res...");
					}
				} else if (opcio.equalsIgnoreCase("T")) {
					valid = true;
					System.out.println("Introdueix el telefon a cercar:");
					opcio = sc.next();
					while (clients[i] != null && i < clients.length && !trobat) {
						clientSol = clients[i].split(" ; ");
						if (clientSol[4].equals(opcio)) {
							System.out.println("S'ha trobat el client, dades:");
							System.out.print("Esta esborrat? ");
							if (clientSol[0].equals("false")) {
								System.out.println("No.");
							} else {
								System.out.println("Si.");
							}
							System.out.println("Codi client: " + clientSol[1]);
							System.out.println("NIF: " + clientSol[2]);
							System.out.println("Nom Complet: " + clientSol[3]);
							System.out.println("Telefon: " + clientSol[4]);
							trobat = true;
						}
						i++;
					}
					if (trobat == false) {
						System.out.println("No s'ha trobat res...");
					}
				} else if (opcio.equalsIgnoreCase("S")) {
					System.out.println("Tornem al menu...");
					fi = true;
				} else {
					System.out.println("La opcio no Ã©s a la llista...");
				}
			}
			valid = false;
			while (!valid) {
				System.out.println("Vols cercar altre client [S/n]?");
				opcio = sc.next();
				if (opcio.equalsIgnoreCase("s")) {
					opcio = "";
					valid = true;
					trobat = false;
				} else if (opcio.equalsIgnoreCase("n")) {
					fi = true;
					valid = true;
				} else {
					System.out.println("Has d'introduir una 's' per a si o una 'n' per a no!");
				}
			}
		}

	}

	/**
	 * Aquest metode ens permet donar de baixa els clients, la cerca del client a donar de baixa es fa per NIF ja que es una dada unica per a cada client.
	 * @param clients
	 */
	public static void baixaClient(String[] clients) {
		int i = 0;
		boolean trobat, fi = false, valid = false;
		String nifF;
		String opcio;
		String[] clientSol = {};
		Scanner sc = new Scanner(System.in);
		while (!fi) {
			valid = false;
			trobat = false;
			System.out.println("Introdueix el nif del client a esborrar:");
			nifF = sc.next();
			while (clients[i] != null && !trobat && i < clients.length) {
				clientSol = clients[i].split(" ; ");
				if (clientSol[2].equals(nifF)) {
					trobat = true;
				}
				if (!trobat) {
					i++;
				}
			}
			if (trobat) {
				System.out.println("S'ha trobat el client:");
				System.out.println("Codi Client: " + clientSol[1]);
				System.out.println("NIF: " + clientSol[2]);
				System.out.println("Nom Complet: " + clientSol[3]);
				System.out.println("Telefon: " + clientSol[4]);
				if (clientSol[0].equals("true")) {
					System.out.println("Pero aquest client ja esta esborrat...");
				} else {
					while (!valid) {
						System.out.println("Segur que vols borrar aquest client? [s/n]");
						opcio = sc.next();
						if (opcio.equalsIgnoreCase("s")) {
							clients[i] = clients[i].replaceFirst("false", "true");
							valid = true;
						} else if (opcio.equalsIgnoreCase("n")) {
							valid = true;
						} else {
							System.out.println("Has de posar 's' per a si o 'n' per a no...");
						}
					}
				}
			} else {
				System.out.println("No s'ha trobat cap client amb aquest nif...");
			}
			valid = false;
			while (!valid) {
				System.out.println("Vols eliminar altre usuari? [s/n]");
				opcio = sc.next();
				if (opcio.equalsIgnoreCase("s")) {
					valid = true;
				} else if (opcio.equalsIgnoreCase("n")) {
					System.out.println("Tornem al menu...");
					fi = true;
					valid = true;
				} else {
					System.out.println("Has de posar 's' per a si o 'n' per a no...");
				}
			}
		}
	}
	
	/**
	 * Aquest metode permet recuperar les dades dels clients esborrats. Mostra per pantalla tots els clients que estan esborrats en aquest moment
	 * perque sigui mes facil trobar al que es vol recuperar
	 * @param clients
	 */

	public static void recuperacioClient(String[] clients) {
		int i;
		boolean fi = false, valid = false, recuperat = false, trobat = false;
		String opcio;
		String[] clientSol = {};
		Scanner sc = new Scanner(System.in);
		while (!fi) {
			valid = false;
			i = 0;
			System.out.println("Llista de clients esborrats:");
			while (clients[i] != null && i < clients.length) {
				clientSol = clients[i].split(" ; ");
				if (clientSol[0].equals("true")) {
					System.out.println("-----------------------------");
					System.out.println("Codi Client: " + clientSol[1]);
					System.out.println("NIF: " + clientSol[2]);
					System.out.println("Nom Complet: " + clientSol[3]);
					System.out.println("Telefon: " + clientSol[4]);
					System.out.println("-----------------------------");
				}
				i++;
			}
			i = 0;
			System.out.println("Introdueix el codi del client a recuperar:");
			opcio = sc.next();
			while (clients[i] != null && i < clients.length && !trobat) {
				clientSol = clients[i].split(" ; ");
				if (clientSol[1].equals(opcio)) {
					if (clientSol[0].equals("true")) {
						recuperat = true;
						trobat = true;
					}
				}
				if (!recuperat) {
					i++;
				}
			}
			if (!recuperat) {
				System.out.println("No s'ha trobat cap client esborrat amb aquest codi...");
			}
			while (!valid && recuperat) {
				System.out.println("Segur que vols recuperar aquest client? [s/n]");
				opcio = sc.next();
				if (opcio.equalsIgnoreCase("n")) {
					valid = true;
					recuperat = false;
				} else if (opcio.equalsIgnoreCase("s")) {
					clients[i] = clients[i].replaceFirst("true", "false");
					valid = true;
					recuperat = false;
				} else {
					System.out.println("Has de posar 's' per a si o 'n' per a no...");
				}
			}
			valid = false;
			while (!valid) {
				System.out.println("Vols recuperar altre usuari? [s/n]");
				opcio = sc.next();
				if (opcio.equalsIgnoreCase("s")) {
					recuperat = false;
					valid = true;
					trobat = false;
				} else if (opcio.equalsIgnoreCase("n")) {
					System.out.println("Tornem al menu...");
					fi = true;
					valid = true;
				} else {
					System.out.println("Has de posar 's' per a si o 'n' per a no...");
				}
			}
		}
	}
	
	/**
	 * Ens permet ordenar els clients per diferents criteris d'ordenacio, tots ascendents
	 * @param clients
	 */

	public static void ordenacioClients(String[] clients) {
		String opcio, aux;
		boolean fi = false;
		Scanner sc = new Scanner(System.in);
		int contadorNull = 0, i = 0, j = 0;
		String[] clientSol;
		String[] clientSolMes;
		while (clients[contadorNull] != null) {
			contadorNull++;
		}
		while (!fi) {
			System.out.println("Quin criteri vols escollir per la ordenacio?");
			System.out.println("CO - Codi client");
			System.out.println("NI - NIF");
			System.out.println("NO - Nom i cognoms");
			System.out.println("TE - Telefon");
			System.out.println("S - Sortir al menu");
			System.out.println("Escull una opcio...");
			opcio = sc.next();
			if (opcio.equalsIgnoreCase("co")) {
				while (i < contadorNull - 1) {
					while (j < contadorNull - i - 1) {
						clientSol = clients[j].split(" ; ");
						clientSolMes = clients[j + 1].split(" ; ");
						if (clientSol[1].compareTo(clientSolMes[1]) > 0) {
							aux = clients[j];
							clients[j] = clients[j + 1];
							clients[j + 1] = aux;
						}
						j++;
					}
					j = 0;
					i++;
				}
				i = 0;
				System.out.println("Fet!");
			} else if (opcio.equalsIgnoreCase("ni")) {
				while (i < contadorNull - 1) {
					while (j < contadorNull - i - 1) {
						clientSol = clients[j].split(" ; ");
						clientSolMes = clients[j + 1].split(" ; ");
						if (clientSol[2].compareTo(clientSolMes[2]) > 0) {
							aux = clients[j];
							clients[j] = clients[j + 1];
							clients[j + 1] = aux;
						}
						j++;
					}
					j = 0;
					i++;
				}
				i = 0;
				System.out.println("Fet!");
			} else if (opcio.equalsIgnoreCase("NO")) {
				while (i < contadorNull - 1) {
					while (j < contadorNull - i - 1) {
						clientSol = clients[j].split(" ; ");
						clientSolMes = clients[j + 1].split(" ; ");
						if (clientSol[3].compareTo(clientSolMes[3]) > 0) {
							aux = clients[j];
							clients[j] = clients[j + 1];
							clients[j + 1] = aux;
						}
						j++;
					}
					j = 0;
					i++;
				}
				i = 0;
				System.out.println("Fet!");
			} else if (opcio.equalsIgnoreCase("TE")) {
				while (i < contadorNull - 1) {
					while (j < contadorNull - i - 1) {
						clientSol = clients[j].split(" ; ");
						clientSolMes = clients[j + 1].split(" ; ");
						if (clientSol[1].compareTo(clientSolMes[1]) > 0) {
							aux = clients[j];
							clients[j] = clients[j + 1];
							clients[j + 1] = aux;
						}
						j++;
					}
					j = 0;
					i++;
				}
				i = 0;
				System.out.println("Fet!");
			} else if (opcio.equals("s")) {
				fi = true;
			} else {
				System.out.println("La opcio no es a la llista");
			}

		}
	}
	
	/**
	 * Aquesta funcio mostra tots els clients que hi han registrats fins al moment.
	 * @param clients
	 */

	public static void mostraTotsClients(String[] clients) {
		int i = 0;
		String[] clientSol;
		while (clients[i] != null && i < clients.length) {
			clientSol = clients[i].split(" ; ");
			System.out.println("\nNom: " + clientSol[3]);
			System.out.println("============================");
			System.out.print("Esta esborrat? ");
			if (clientSol[0].equals("true")) {
				System.out.println("Si");
			} else {
				System.out.println("No");
			}
			System.out.println("Codi client: " + clientSol[1]);
			System.out.println("NIF: " + clientSol[2]);
			System.out.println("Telefon: " + clientSol[4]);
			System.out.println("----------------------------");
			i++;
		}
	}
	
	/** 
	 * funcio main on es crida el menu, i fins que l'usuari no selecciona sortir, no tanca el bucle que crida a la funcio inici()
	 * @param args
	 */

	public static void main(String[] args) {
		String[] clients = new String[MAXIMCLIENTS];
		PracticaGrup negoci = new PracticaGrup();
		boolean fi = false;
		while (!fi) {
			fi = negoci.inici(clients);
		}
	}
}