import java.util.Scanner;

public class Principal {

	private static Discoteca discoteka;
	
	public static void main(String[] args) {
		
		discoteka = new Discoteca();
		
		Cliente miCliente = new Cliente("12345", "pedro");
		miCliente.setFechaNacimiento("23-11-2000");
		Cliente miClienteDos = new Cliente("21345", "juan");
		miClienteDos.setFechaNacimiento("22-11-2001");
		Cliente miClienteTres = new Cliente("32145", "alberto");
		miClienteTres.setFechaNacimiento("23-11-2002");

		discoteka.anhadirCliente(miCliente);
		discoteka.anhadirCliente(miClienteDos);
		discoteka.anhadirCliente(miClienteTres);
		
		mostrarMenu();
	}
	
	public static void mostrarMenu() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int opcionMenu;
		
		String menu = "----------MENU DE OPCIONES---------- \n"
				+ "- 1.Añadir cliente. \n"
				+ "- 2.Ver datos por DNI. \n"
				+ "- 3.Mostrar registro de clientes. \n"
				+ "- 0.Salir. \n";
		
		System.out.println(menu);
		
		System.out.print("Selecciona una opcion: ");
		opcionMenu = sc.nextInt();
	
		Principal.opcionMenu(opcionMenu);
		
		if(opcionMenu != 0) {
			mostrarMenu();
		}
	}	
	
	public static void opcionMenu(int opcion) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		switch(opcion) {
		
			case 1:
				Cliente c1 = Cliente.guardaCliente();
				if (c1 != null) {
					discoteka.anhadirCliente(c1);
					System.out.println("Cliente guardado correctamente.");
				}
				break;
			case 2:
				System.out.print("Introduce el dni por el que quieres buscar: ");
				String dni = sc.next();
				Cliente c2 = discoteka.encontrarDni(dni);
				if ( c2 != null) {
					System.out.println("Cliente encontrado: " + c2);
				}else {
					System.out.println("Cliente no encontrado");
				}
				break;
			case 3:
				System.out.println(discoteka);
				break;
			case 0:
				System.out.println("Saliendo del menu.");
				break;
				
			default:
				System.out.println("Opcion Invalida.");
				break;
			
		}
	
	}

}
