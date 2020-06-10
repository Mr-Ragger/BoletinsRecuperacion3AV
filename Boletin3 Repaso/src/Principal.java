import java.util.Scanner;

public class Principal {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente miCliente = new Cliente("12345", "pedro");
		miCliente.setFechaNacimiento("23-11-2000");
		Cliente miClienteDos = new Cliente("21345", "juan");
		miClienteDos.setFechaNacimiento("22-11-2001");
		Cliente miClienteTres = new Cliente("32145", "alberto");
		miClienteTres.setFechaNacimiento("23-11-2002");
//		mostrarMenu();
		Discoteca miDiscoteca = new Discoteca();
		miDiscoteca.anhadirCliente(miCliente);
		miDiscoteca.anhadirCliente(miClienteDos);
		miDiscoteca.anhadirCliente(miClienteTres);
		
		System.out.println(miDiscoteca);
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
				Cliente c1 = Cliente.guardarCliente();
				System.out.println("Cliente guardado correctamente.");
				break;
			case 2:
				System.out.println("");
				break;
			case 3:
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
